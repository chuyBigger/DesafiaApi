package com.aluracursos.desafio.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ConvierteDatos implements IConvierteDatos {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return mapper.readValue(json, clase);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T> List<T> obtenerLista(String json, Class<T> clase) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, clase));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
