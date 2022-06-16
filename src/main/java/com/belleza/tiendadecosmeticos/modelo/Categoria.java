package com.belleza.tiendadecosmeticos.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id")
    private Long id;

    private String nombre;

    @OneToMany
    @JsonBackReference
    @JoinTable(name = "ProductosCategorias", joinColumns = @JoinColumn(name = "categoria_id",
    referencedColumnName = "categoria_id"), inverseJoinColumns = @JoinColumn(name = "producto_id",
    referencedColumnName = "producto_id" ))
    private Set<Producto> productos = new HashSet<>();


}
