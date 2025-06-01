package com.aluracursos.desafio.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Vehiculos(
        @JsonAlias("name")
        String nombre,
        @JsonAlias("largeIconImageUrl")
        String imagen,
        @JsonAlias("description")
        String descripcion,
        @JsonAlias("isUsableByPlayer")
        boolean loPuedeUsarElJugador,
        @JsonAlias("id")
        String codigo
) {
    @Override
    public String toString() {
        return "\nEquipo: " +
                "\n     Nombre: " + nombre +
                "\n     Descricion: " + descripcion +
                "\n     Imagen_Url: " + imagen +
                "\n     Se puede usar: " + loPuedeUsarElJugador +
                "\n     Codigo: " + codigo;
    }
}
