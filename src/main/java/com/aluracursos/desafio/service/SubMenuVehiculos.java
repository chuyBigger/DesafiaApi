package com.aluracursos.desafio.service;

import com.aluracursos.desafio.modelos.Vehiculos;

import java.util.List;
import java.util.Scanner;

public class SubMenuVehiculos {
    RepositorioDeArmas repositorioDeArmas = new RepositorioDeArmas();
    RepositorioDeVehiculos repositorioDeVehiculos = new RepositorioDeVehiculos();
    Scanner scanner = new Scanner(System.in);
    int opcion = 0;


    public void menuTipoVehiculos() {

        repositorioDeVehiculos.cargarDatos();

        do {
            System.out.println("""
                    ==========================================================
                    ----------------------------------------------------------
                            Mostrar vehiculos por disposicion de usuario
                    ..........................................................
                    
                                    1.- vehiculos que se pueden usar
                                    2.- vehiculos que No! se pueden usar
                                    3.- vehiculos indefinido!
                                    9.- Regresar al menu anterior
                    
                    ----------------------------------------------------------
                    ==========================================================
                    """);

            try {
                String entrada = scanner.nextLine();
                try {
                    opcion = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Por favor ingresa un número.");
                    opcion = -1;
                }
                switch (opcion) {
                    case 1:
                        repositorioDeVehiculos.vehiculosUtilizables();
                        System.out.println("Presiona enter para continuar...");
                        scanner.nextLine();
                        break;
                    case 2:
                        repositorioDeVehiculos.vehiculosNoUtilizables();
                        System.out.println("Presiona enter para continuar...");
                        scanner.nextLine();
                        break;
                    case 3:
                        List<Vehiculos> indefinido = repositorioDeVehiculos.vehiculosIndefinido();
                        if (indefinido.isEmpty()) {
                            System.out.println(" No hay vehiculos que no esten definidos");
                        } else {
                            indefinido.forEach(System.out::println);
                        }

                        System.out.println("Presiona enter para continuar...");
                        scanner.nextLine();
                        break;
                    default:


                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número entre las opciones mostradas.");

            }
        } while (opcion != 9);


    }

}
