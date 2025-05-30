package com.aluracursos.desafio.principal;

import java.util.Scanner;
                                    // Clase principal que muestra el menú principal de opciones del sistema
public class Principal {

    private PrincipalArmas principalArmas = new PrincipalArmas();
    private PrincipalEnemigos principalEnemigos = new PrincipalEnemigos();
    private PrincipalVehiculos principalVehiculos = new PrincipalVehiculos();

    Scanner scanner = new Scanner(System.in);
    public void muestraElMenu(){
        var eleccion = 0 ;

        do {
            System.out.println("Este servidor muetra informacion de Armas, Vehiculos y Enemigos del Juego 'Halo 5' ");
            System.out.println("""
                =========================================================================================
                             POR FAVOR INGRESA LA OPCION DESDEDA 
                             1.- MENU ARMAS 
                             2.- MENU VEHICULOS
                             3.- MENU ENEMIGOS
                             9.- SALIR
                """);
            try {
                eleccion = scanner.nextInt();
                switch (eleccion){
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
                        System.out.println("Gracias por usar esta app de Halo5...");
                    default:
                        System.out.println("La opcion no es valida vuelve a intentarlo");

                }
            }catch (NumberFormatException e){
                System.out.println(" Entrada no valida vuelve a intentarlo");
            }
        }while (eleccion != 9);


    }




}
