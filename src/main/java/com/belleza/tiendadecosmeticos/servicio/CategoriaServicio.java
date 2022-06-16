package com.belleza.tiendadecosmeticos.servicio;

import com.belleza.tiendadecosmeticos.modelo.Categoria;
import com.belleza.tiendadecosmeticos.modelo.Producto;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.List;

public interface CategoriaServicio {

    ResponseEntity<List<Categoria>> listarCategorias();

    ResponseEntity<Categoria>  guardarCategorias(Categoria categoria);

    ResponseEntity<Producto> eliminarCategoria(Long id);

    ResponseEntity<Collection<Producto>> listarProductoPorCategoria(Long id);

}
