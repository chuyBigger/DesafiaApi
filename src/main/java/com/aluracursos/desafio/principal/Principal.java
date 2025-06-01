package com.aluracursos.desafio.principal;

import java.util.Scanner;
                                    // Clase principal que muestra el menú principal de opciones del sistema
public class Principal {

    private PrincipalArmas principalArmas = new PrincipalArmas();
    private PrincipalEnemigos principalEnemigos = new PrincipalEnemigos();
    private PrincipalVehiculos principalVehiculos = new PrincipalVehiculos();

    Scanner scanner = new Scanner(System.in);
    public void muestraElMenu(){
        var opcion = 0 ;

        do {
            System.out.println("Este servidor muetra informacion de Armas, Vehiculos y Enemigos del Juego 'Halo 5' ");
            System.out.println("""
                =========================================================================================
                             POR FAVOR INGRESA LA OPCION DESDEDA 
                             1.- MENU ARMAS 
                             2.- MENU ENEMIGOS 
                             3.- MENU VEHICULOS
                             9.- SALIR
                """);

            try {

                String entrada = scanner.nextLine();
                try {
                    opcion = Integer.parseInt(entrada);
                }catch (NumberFormatException e){
                    System.out.println("Entrada no válida. Por favor ingresa un número.");
                    opcion = -1; // fuerza a que el bucle continúe
                }
                switch (opcion){
                    case 1:
                        principalArmas.menuArmas();
                        break;
                    case 2:
                        principalEnemigos.menuEnemigos();
                        break;
                    case 3:
                        principalVehiculos.menuVehiculos();
                        break;
                    case 9:
                        System.out.println("Gracias por usar esta app de Halo 5 ...");
                        break;
                    default:
                        System.out.println("La opcion no es valida vuelve a intentarlo");

                }
            }catch (NumberFormatException e){
                System.out.println(" Entrada no valida vuelve a intentarlo");
            }
        }while (opcion != 9);


    }




}
