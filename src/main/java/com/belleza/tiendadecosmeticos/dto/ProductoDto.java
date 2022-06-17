package com.belleza.tiendadecosmeticos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {

    private  String nombre;

    private int precio;

    private int cantidad;

    private String color;

    private Long categoriaId;

}
