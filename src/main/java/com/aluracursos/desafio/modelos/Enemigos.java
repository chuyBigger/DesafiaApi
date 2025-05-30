package com.aluracursos.desafio.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Enemigos(
        @JsonAlias("faction")
        String procedencia,
        @JsonAlias("name")
        String nombre,
        @JsonAlias("largeIconImageUrl")
        String imagen,
        @JsonAlias("description")
        boolean loPuedeUsarElJugador,
        @JsonAlias("id")
        String codigo
) {
    @Override
    public String toString() {
        return "\nEquipo: " +
                "\n     Nombre: " + nombre +
                "\n     De que equipo es: " + procedencia +
                "\n     Imagen Url: " + imagen +
                "\n     Se puede usar: " + loPuedeUsarElJugador +
                "\n     Codigo: " + codigo ;
    }
}
