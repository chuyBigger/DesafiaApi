package com.aluracursos.desafio.service;

import com.aluracursos.desafio.modelos.Armas;

import java.util.List;

public class RepositorioDeArmas {


    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private static final String URL_Type = "weapons";
    private List<Armas> datosArray;

    public void cargarDatos(){
        var json = consumoApi.obtenerDatos(URL_Type);
        datosArray = convierteDatos.obtenerLista(json, Armas.class);
    }


    public void listaDeArmasCompleta(){

        System.out.println(datosArray);
    }

    public void listaArmasGranadas() {
        datosArray.stream()
                .filter(g -> g.tipoDeArma().equalsIgnoreCase("Grenade"))
                .forEach(System.out::println);
    }

    public void listaArmasTurret() {
        datosArray.stream()
                .filter(t -> t.tipoDeArma().equalsIgnoreCase("Turret"))
                .forEach(System.out::println);
    }

    public void listaArmasVehicle() {
        datosArray.stream()
                .filter(v -> v.tipoDeArma().equalsIgnoreCase("Vehicle"))
                .forEach(System.out::println);
    }

    public void listaArmasStandard() {
        datosArray.stream()
                .filter(s -> s.tipoDeArma().equalsIgnoreCase("Standard"))
                .forEach(System.out::println);
    }

    public void listaArmasPower() {
        datosArray.stream()
                .filter(p -> p.tipoDeArma().equalsIgnoreCase("Power"))
                .forEach(System.out::println);
    }
    public void listaArmasSinTipo() {
        datosArray.stream()
                .filter(arma -> arma.tipoDeArma() == null || arma.tipoDeArma().equalsIgnoreCase("undefined"))
                .forEach(System.out::println);
    }

//    public void estadisticaDeArmas(){
//        listaArmasSinTipo(getClass().getName());
//    }

}
