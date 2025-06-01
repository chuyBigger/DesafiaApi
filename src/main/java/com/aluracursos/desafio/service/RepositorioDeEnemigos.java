package com.aluracursos.desafio.service;

import com.aluracursos.desafio.modelos.Armas;
import com.aluracursos.desafio.modelos.Enemigos;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RepositorioDeEnemigos {


    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private static final String URL_Type = "enemies";
    private List<Enemigos> datosArray;
    private Scanner scanner = new Scanner(System.in);

    public void cargarDatos() {
        var json = consumoApi.obtenerDatos(URL_Type);
        datosArray = convierteDatos.obtenerLista(json, Enemigos.class);
    }

    public void listaDeEnemigosCompleta() {

        System.out.println(datosArray);
    }

    public void listaEnemigosUNSC() {
        datosArray.stream()
                .filter(g -> g.procedencia().equalsIgnoreCase("UNSC"))
                .forEach(System.out::println);
    }

    public void listaEnemigosCovenant() {
        datosArray.stream()
                .filter(g -> g.procedencia().equalsIgnoreCase("Covenant"))
                .forEach(System.out::println);
    }

    public void listaEnemigosPromethean() {
        datosArray.stream()
                .filter(g -> g.procedencia().equalsIgnoreCase("Promethean"))
                .forEach(System.out::println);
    }

    public void listaEnemigosIndefinido() {
        datosArray.stream()
                .filter(enemigos -> enemigos.procedencia() == null|| enemigos.procedencia().equalsIgnoreCase("undefined"))
                .forEach(System.out::println);
    }


    // Datos para estadisticas de Enemigos cantidad de Enemigo por faccion.

    public void estadisticaDeEnemigos() {

        System.out.println("""
                =======================================================
                
                              Estadísticas de Armas
                
                =======================================================\n
                """);
        Map<String, Long> conteoPorFaccion = datosArray.stream()
                .collect(Collectors.groupingBy(
                        Enemigos::procedencia,
                        Collectors.counting()
                ));
        long max = conteoPorFaccion.values().stream().mapToLong(Long::longValue).max().orElse(1);
        int barraMaxima = 20; // número máximo de bloques "█"


        System.out.println(" Enemigos agrupados por faccion:\n");
        conteoPorFaccion.forEach((tipo, cantidad) -> {
                    int longitudBarra = (int) ((double) cantidad / max * barraMaxima);
                    String barra = "█".repeat(longitudBarra);
                    System.out.printf("Tipo: %-10s → %2d faccion   %s%n", tipo, cantidad, barra);
                }

        );

        long total = datosArray.size();
        System.out.println("\n Total de armas registradas: " + total);

        System.out.println("\n=======================================================");

    }


    // Buscar de enemigos por nombre.
    public void busquedaPorNombre() {
        System.out.println("Ingrese el nombre del enemigo que desea buscar:");
        var busqueda = scanner.nextLine();

        Optional<Enemigos> enemigoExacto = datosArray.stream()
                .filter(enemigos -> enemigos.nombre().toLowerCase().equalsIgnoreCase(busqueda))
                .findFirst();
        if (enemigoExacto.isPresent()) {
            System.out.println("Arma Encontrada!!");
            System.out.println(enemigoExacto.get());
        } else {
            List<Enemigos> coicidenciasParciales = datosArray.stream()
                    .filter(enemigos -> enemigos.nombre().toLowerCase().contains(busqueda.toLowerCase()))
                    .toList();
            if (!coicidenciasParciales.isEmpty()) {
                System.out.println("No se encontraron coicidencias exactas pero se encontraron estas Enemigos que incluyan: " + busqueda + " en su nombre.");
                coicidenciasParciales.forEach(enemigos -> System.out.println("_ " + enemigos.nombre()));
            } else {
                System.out.println(" No se encontraron coicidencias es el nombre: " + busqueda);
            }
        }

    }

}
