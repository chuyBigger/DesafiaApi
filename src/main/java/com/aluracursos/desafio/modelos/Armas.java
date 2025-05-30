package com.aluracursos.desafio.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Armas(
        @JsonAlias("name")
        String nombre,
        @JsonAlias("type")
        String tipoDeArma,
        @JsonAlias("largeIconImageUrl")
        String imagen,
        @JsonAlias("description")
        String loPuedeUsarElJugador,
        @JsonAlias("id")
        String codigo
) {
    @Override
    public String toString() {
        return "\nEquipo: " +
                "\n     Nombre: " + nombre +
                "\n     Imagen Url: " + imagen +
                "\n     Tipo de Arma: " + tipoDeArma +
                "\n     Se puede usar: " + loPuedeUsarElJugador +
                "\n     Codigo: " + codigo ;
    }
}
