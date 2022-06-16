package com.belleza.tiendadecosmeticos.servicio.Impl;

import com.belleza.tiendadecosmeticos.modelo.Producto;
import com.belleza.tiendadecosmeticos.repositorio.ProductosRepositorio;
import com.belleza.tiendadecosmeticos.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicioImpl implements ProductoServicio {

    @Autowired
    private ProductosRepositorio productosRepositorio;

    @Override
    public ResponseEntity<List<Producto>> listarProductos() {
        try {
            List<Producto> productos = productosRepositorio.findAll();
            if (productos.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(productos);
        }catch (Exception e){
            System.out.println(e);
        }

        return null;
    }

    @Override
    public ResponseEntity<Producto> guardarProducto(Producto producto) {
        try {
            Producto nuevoProducto = productosRepositorio.save(producto);
            if (nuevoProducto == null){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(producto);
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return null;

    }

    @Override
    public ResponseEntity<Producto> eliminarProducto(Long id) {
        try {
            productosRepositorio.deleteById(id);
        }catch (Exception e){
            System.out.println(e);
        }

        return null;
    }

    @Override
    public ResponseEntity<Producto> productoPorId(Long id) {
        try {
            Producto producto = productosRepositorio.findById(id).orElse(null);
            if (producto == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(producto);
        }catch (Exception e){
            System.out.println(e);
        }

        return null;
    }

    @Override
    public ResponseEntity<Producto> actualizarProducto(Producto producto, Long id) {
        try {
            var productoExistente = productosRepositorio.findById(id);
            producto.setNombre(producto.getNombre());
            producto.setPrecio(producto.getPrecio());
            producto.setCantidad(producto.getCantidad());
            productosRepositorio.save(producto);
            return  new ResponseEntity<Producto>(HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }
}
