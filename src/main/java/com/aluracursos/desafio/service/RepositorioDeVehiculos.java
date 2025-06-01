package com.aluracursos.desafio.service;

import com.aluracursos.desafio.modelos.Enemigos;
import com.aluracursos.desafio.modelos.Vehiculos;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RepositorioDeVehiculos {
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private static final String URL_Type = "vehicles";
    private List<Vehiculos> datosArray;
    Scanner scanner = new Scanner(System.in);

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
    // Buscar de vehiculos por nombre.

    public void busquedaVehiculosPorNombre() {
        System.out.println("Ingrese el nombre del vehiculo que desea buscar:");
        var busqueda = scanner.nextLine();

        Optional<Vehiculos> vehiculoExacto = datosArray.stream()
                .filter(vehiculos -> vehiculos.nombre().toLowerCase().equalsIgnoreCase(busqueda))
                .findFirst();
        if (vehiculoExacto.isPresent()) {
            System.out.println("Vehiculo Encontrado!!");
            System.out.println(vehiculoExacto.get());
        } else {
            List<Vehiculos> coicidenciasParciales = datosArray.stream()
                    .filter(vehiculos -> vehiculos.nombre().toLowerCase().contains(busqueda.toLowerCase()))
                    .toList();
            if (!coicidenciasParciales.isEmpty()) {
                System.out.println("No se encontraron coicidencias exactas pero se encontraron estos vehiculos que incluyan: " + busqueda + " en su nombre.");
                coicidenciasParciales.forEach(vehiculos -> System.out.println("_ " + vehiculos.nombre()));
            } else {
                System.out.println(" No se encontraron coicidencias es el nombre: " + busqueda);
            }
        }

    }


}