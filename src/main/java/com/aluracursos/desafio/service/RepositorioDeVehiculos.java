package com.aluracursos.desafio.service;

import com.aluracursos.desafio.modelos.Vehiculos;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepositorioDeVehiculos {
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private static final String URL_Type = "vehicles";
    private List<Vehiculos> datosArray;

    public void cargarDatos() {
        var json = consumoApi.obtenerDatos(URL_Type);
        datosArray = convierteDatos.obtenerLista(json, Vehiculos.class);
    }

    public void listaTodosVehiculos() {
        System.out.println(datosArray);
    }

    public void vehiculosUtilizables() {
        List<Vehiculos> vehiculosUtilizablesList = datosArray.stream()
                .filter(Vehiculos::loPuedeUsarElJugador)
                .collect(Collectors.toList());
        if (vehiculosUtilizablesList.isEmpty()) {
            System.out.println("No hay vehiculos utilizables!");
        } else {
            vehiculosUtilizablesList.forEach(System.out::println);
        }
    }

    public void vehiculosNoUtilizables() {
        List<Vehiculos> vehiculosListNoUsables = datosArray.stream()
                .filter(v -> Boolean.FALSE.equals(v.loPuedeUsarElJugador()))
                .collect(Collectors.toList());

        vehiculosListNoUsables.forEach(System.out::println);
    }

    public List<Vehiculos> vehiculosIndefinido() {
        List<Vehiculos> vehiculosIndefinidoList = datosArray.stream()
                .filter(v -> v.loPuedeUsarElJugador() == false)
                .collect(Collectors.toList());
        return vehiculosIndefinidoList;
    }

    // Menu de estadisticas de evhiculos basado en vehiculos que puede o no usar el jugador

    public void estadisticaDeVehiculos() {

        System.out.println("""
                =======================================================
                
                              Estadísticas de Vehiculos
                
                =======================================================\n
                """);
        Map<Boolean, Long> conteoPorJugabilidad = datosArray.stream()
                .collect(Collectors.groupingBy(
                        Vehiculos::loPuedeUsarElJugador,
                        Collectors.counting()
                ));
        long max = conteoPorJugabilidad.values().stream().mapToLong(Long::longValue).max().orElse(1);
        int barraMaxima = 20; // número máximo de bloques "█"


        System.out.println(" Vehiculos agrupados por jugabilidad:\n");
        conteoPorJugabilidad.forEach((tipo, cantidad) -> {
                    int longitudBarra = (int) ((double) cantidad / max * barraMaxima);
                    String barra = "█".repeat(longitudBarra);
                    String tipoTexto = tipo ? "Jugable":"No Jugable";
                    System.out.printf("Tipo: %-10s → %2d Vehiculos   %s%n", tipoTexto, cantidad, barra);
                }

        );

        long total = datosArray.size();
        System.out.println("\n Total de vehiculos registrados: " + total);

        System.out.println("\n=======================================================");

    }


}