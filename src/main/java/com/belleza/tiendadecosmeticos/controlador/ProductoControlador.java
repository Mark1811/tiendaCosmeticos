package com.belleza.tiendadecosmeticos.controlador;

import com.belleza.tiendadecosmeticos.modelo.Producto;
import com.belleza.tiendadecosmeticos.servicio.Impl.ProductoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/api/producto")
public class ProductoControlador {

    @Autowired
    private ProductoServicioImpl productoServicio;

    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos(){
        return productoServicio.listarProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Long id){
        return productoServicio.productoPorId(id);
    }

    @PostMapping
    public ResponseEntity<Producto> guardarProductos(@RequestBody Producto producto){
        return productoServicio.guardarProducto(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto, @PathVariable Long id){
        return productoServicio.actualizarProducto(producto,id);
    }

    @DeleteMapping("/{id}")
    public void eliminarProductos(@PathVariable Long id){
        productoServicio.eliminarProducto(id);
    }

}
