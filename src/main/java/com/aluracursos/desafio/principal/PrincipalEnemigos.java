package com.aluracursos.desafio.principal;

import com.aluracursos.desafio.modelos.Enemigos;
import com.aluracursos.desafio.modelos.Vehiculos;
import com.aluracursos.desafio.service.ConsumoApi;
import com.aluracursos.desafio.service.ConvierteDatos;
import com.aluracursos.desafio.service.RepositorioDeEnemigos;
import com.aluracursos.desafio.service.SubMenuEnemigos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrincipalEnemigos {

    RepositorioDeEnemigos repositorioDeEnemigos = new RepositorioDeEnemigos();
    SubMenuEnemigos subMenuEnemigos = new SubMenuEnemigos();
    Scanner scanner = new Scanner(System.in);

    public void menuEnemigos() {
        System.out.println("Haz iniciado el 'MENU DE ENEMIGOS DE HALO 5'");
        System.out.println("******************************************");
        repositorioDeEnemigos.cargarDatos();

        int opcion = 0;

        do {
            System.out.println("""
                    ==========================================================
                    ***                   Menu de Enemigos                    ***
                    ==========================================================
                    
                                1.- Buscar enemigo por "nombre"
                                2.- Mostrar lista de todos los enemigos
                                3.- Mostrar Menu de enemigos por faccion 
                                4.- Mostrar Estadisticas de enemigos
                                9.- Regresar al menu anterior
                    
                    ==========================================================
                    """);
            try {
                String entrada = scanner.nextLine();
                try {
                    opcion = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Por favor ingresa un número.");
                    opcion = -1; // fuerza a que el bucle continúe
                }
                switch (opcion) {
                    case 1:
                        repositorioDeEnemigos.busquedaPorNombre();
                        System.out.println("Presiona enter para continuar...");
                        scanner.nextLine();
                        break;
                    case 2:
                        repositorioDeEnemigos.listaDeEnemigosCompleta();
                        System.out.println("Presiona enter para continuar...");
                        scanner.nextLine();
                        break;
                    case 3:
                        subMenuEnemigos.menuFaccionesEnemigos();
                        break;
                    case 4:
                        repositorioDeEnemigos.estadisticaDeEnemigos();
                        System.out.println("Presiona una tecla para continuar...");
                        scanner.nextLine();
                        break;
                    case 5:
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



