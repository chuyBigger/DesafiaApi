package com.aluracursos.desafio.service;

import com.aluracursos.desafio.principal.PrincipalArmas;

import java.io.IOException;
import java.util.Scanner;

public class SubMenuArmas {
    RepositorioDeArmas repositorioDeArmas = new RepositorioDeArmas();
    Scanner scanner = new Scanner(System.in);
    int opcion = 0;


    public void menuTipoArma() {

        do {
            System.out.println("""
                    ==========================================================
                    ----------------------------------------------------------
                                    Tipos de arma disponibles:
                    ..........................................................
                    
                                    1.- Grenade
                                    2.- Turret
                                    3.- Vehicle
                                    4.- Standard
                                    5.- Power
                                    6.- Indefinido(Aun no has sido categirizadas en el server)
                                    9.- SALIR
                    
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
                        repositorioDeArmas.listaArmasGranadas();
                        System.out.println("Presiona enter para continuar...");
                        scanner.nextLine();
                        break;
                    case 2:
                        repositorioDeArmas.listaArmasTurret();
                        System.out.println("Presiona enter para continuar...");
                        scanner.nextLine();
                        break;
                    case 3:
                        repositorioDeArmas.listaArmasVehicle();
                        System.out.println("Presiona enter para continuar...");
                        scanner.nextLine();
                        break;
                    case 4:
                        repositorioDeArmas.listaArmasStandard();
                        System.out.println("Presiona enter para continuar...");
                        scanner.nextLine();
                        break;
                    case 5:
                        repositorioDeArmas.listaArmasPower();
                        System.out.println("Presiona enter para continuar...");
                        scanner.nextLine();
                        break;
                    case 6:
                        repositorioDeArmas.listaArmasSinTipo();
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
