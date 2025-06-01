package com.aluracursos.desafio.principal;

import com.aluracursos.desafio.modelos.Vehiculos;
import com.aluracursos.desafio.service.ConsumoApi;
import com.aluracursos.desafio.service.ConvierteDatos;
import com.aluracursos.desafio.service.RepositorioDeVehiculos;
import com.aluracursos.desafio.service.SubMenuVehiculos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrincipalVehiculos {

    Scanner scanner = new Scanner(System.in);
    RepositorioDeVehiculos repositorioDeVehiculos = new RepositorioDeVehiculos();
    SubMenuVehiculos subMenuVehiculos = new SubMenuVehiculos();

    public void menuVehiculos() {
        System.out.println("Haz iniciado el 'MENU DE VEHICULOS DE HALO 5'");
        System.out.println("******************************************");
        repositorioDeVehiculos.cargarDatos();
        var opcion = 0;

        do {
            System.out.println("""
                    ==========================================================
                    ***                   Menu de Vehiculos                    ***
                    ==========================================================
                    
                                1.- Mostrar lista de todos los vehiculos
                                2.- Mostrar lista de vehiculos por juegabilidad 
                                3.- Mostrar Estadisticas de vehiculos
                                4.- Regresar al menu anterior
                    
                    ==========================================================
                    """);
            try {
                String entrada = scanner.nextLine();
                try {
                    opcion = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Por favor ingresa un número.");
                    opcion = -1; // fuerza a que el bucle continue
                }
                switch (opcion) {
                    case 1:
                        repositorioDeVehiculos.listaTodosVehiculos();
                        break;
                    case 2:
                        subMenuVehiculos.menuTipoVehiculos();
                        break;
                    case 3:
                        // todo mostrar las estadisticas - cantidad de vehiculos total - cantidad de vehiculos por tipo
                        repositorioDeVehiculos.estadisticaDeVehiculos();

                        break;
                    case 9:
                        System.out.println("Regresando al menú principal...");
                        break;
                    default:
                        System.out.println("La opcion no es valida vuelve a intentarlo");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingresa un número.");
                scanner.nextLine();
            }
        } while (opcion != 9);

    }
}

