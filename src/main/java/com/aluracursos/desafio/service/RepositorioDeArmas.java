package com.aluracursos.desafio.service;

import com.aluracursos.desafio.modelos.Armas;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RepositorioDeArmas {


    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private static final String URL_Type = "weapons";
    private List<Armas> datosArray;
    private Scanner scanner = new Scanner(System.in);

    public void cargarDatos() {
        var json = consumoApi.obtenerDatos(URL_Type);
        datosArray = convierteDatos.obtenerLista(json, Armas.class);
    }

    public void listaDeArmasCompleta() {

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

    // Datos para estadisticas de armas cuenta la cantidad de armas or tipo
    public void estadisticaDeArmas() {

        System.out.println("""
                =======================================================
                
                              Estadísticas de Armas
                
                =======================================================\n
                """);
        Map<String, Long> conteoPorTipo = datosArray.stream()
                .collect(Collectors.groupingBy(
                        Armas::tipoDeArma,
                        Collectors.counting()
                ));
        long max = conteoPorTipo.values().stream().mapToLong(Long::longValue).max().orElse(1);
        int barraMaxima = 20; // número máximo de bloques "█"


        System.out.println(" Armas agrupadas por tipo:\n");
        conteoPorTipo.forEach((tipo, cantidad) -> {
                    int longitudBarra = (int) ((double) cantidad / max * barraMaxima);
                    String barra = "█".repeat(longitudBarra);
                    System.out.printf("Tipo: %-10s → %2d armas   %s%n", tipo, cantidad, barra);
                }

        );


        long total = datosArray.size();
        System.out.println("\n Total de armas registradas: " + total);

        System.out.println("\n=======================================================");

    }


    // Buscar armas por nombre
    public void busquedaPorNombre() {
        System.out.println("Ingrese el nombre del arma que desea buscar:");
        var busqueda = scanner.nextLine();

        Optional<Armas> armaExacta = datosArray.stream()
                .filter(armas -> armas.nombre().toLowerCase().equalsIgnoreCase(busqueda))
                .findFirst();
        if (armaExacta.isPresent()) {
            System.out.println("Arma Encontrada!!");
            System.out.println(armaExacta.get());
        } else {
            List<Armas> coicidenciasParciales = datosArray.stream()
                    .filter(armas -> armas.nombre().toLowerCase().contains(busqueda.toLowerCase()))
                    .toList();
            if (!coicidenciasParciales.isEmpty()) {
                System.out.println("No se encontraron coicidencias exactas pero se encontraron estas armas que incluyan: " + busqueda + " en su nombre.");
                coicidenciasParciales.forEach(armas -> System.out.println("_ " + armas.nombre()));
            } else {
                System.out.println(" No se encontraron coicidencias es el nombre: " + busqueda);
            }
        }

    }

}
