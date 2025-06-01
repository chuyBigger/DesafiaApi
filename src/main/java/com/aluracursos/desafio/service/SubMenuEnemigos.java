package com.aluracursos.desafio.service;

import java.util.Scanner;

public class SubMenuEnemigos {
    RepositorioDeEnemigos repositorioDeEnemigos = new RepositorioDeEnemigos();
    Scanner scanner = new Scanner(System.in);
    int opcion = 0;


    public void menuFaccionesEnemigos() {
        repositorioDeEnemigos.cargarDatos();

        do {
            System.out.println("""
                    ==========================================================
                    ----------------------------------------------------------
                                    Tipos de arma disponibles:
                    ..........................................................
                    
                                    1.- UNSC
                                    2.- Covenant
                                    3.- Promethean
                                    4.- Indefinido(Aun no has sido categirizadas en el server)
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
                        repositorioDeEnemigos.listaEnemigosUNSC();
                        System.out.println("Presiona enter para continuar...");
                        scanner.nextLine();
                        break;
                    case 2:
                        repositorioDeEnemigos.listaEnemigosCovenant();
                        System.out.println("Presiona enter para continuar...");
                        scanner.nextLine();
                        break;
                    case 3:
                        repositorioDeEnemigos.listaEnemigosPromethean();
                        System.out.println("Presiona enter para continuar...");
                        scanner.nextLine();
                        break;
                    case 4:
                        repositorioDeEnemigos.listaEnemigosIndefinido();
                        System.out.println("Presiona enter para continuar...");
                        scanner.nextLine();
                        break;
                    default:


                }

            } catch (NumberFormatException e) {
                System.out.println("h");

            }
        } while (opcion != 9);


    }

}
