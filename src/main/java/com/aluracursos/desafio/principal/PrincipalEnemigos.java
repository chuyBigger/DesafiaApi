package com.aluracursos.desafio.principal;

import com.aluracursos.desafio.modelos.Enemigos;
import com.aluracursos.desafio.modelos.Vehiculos;
import com.aluracursos.desafio.service.ConsumoApi;
import com.aluracursos.desafio.service.ConvierteDatos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrincipalEnemigos {

    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private static final String URL_Type = "enemies";
    Scanner scanner = new Scanner(System.in);

    public void menuEnemigos(){
        System.out.println("Haz iniciado el 'MENU DE ENEMIGOS DE HALO 5'");
        System.out.println("******************************************");
        var json = consumoApi.obtenerDatos(URL_Type);
        var datosArray = convierteDatos.obtenerLista(json, Enemigos.class);
        int opcion=0;

        do {
            System.out.println("""
                    ==========================================================
                    ***                   Menu de Enemigos                    ***
                    ==========================================================
                    
                                1.- Mostrar lista de todos los enemigos
                                2.- Mostrar lista de enemigos por faccion 
                                3.- Mostrar Estadisticas de enemigos
                                4.- Regresar al menu anterior
                                
                    ==========================================================
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
                        System.out.println(datosArray);
                        break;
                    case 2:
                        // todo Mostrar submenu de tipo de vehiculos y crear solicitudes
                        break;
                    case 3:
                        // todo mostrar las estadisticas - cantidad de vehiculos total - cantidad de vehiculos por tipo
                    case 4:
                        System.out.println("Regresando al menú principal...");
                        break;
                    default:
                        System.out.println("La opcion no es valida vuelve a intentarlo");
                }
            }catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingresa un número.");
                scanner.nextLine();
            }
        }while (opcion != 4);
    }

}



