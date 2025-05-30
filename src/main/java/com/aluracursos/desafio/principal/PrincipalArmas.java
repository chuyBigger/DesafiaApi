package com.aluracursos.desafio.principal;

import com.aluracursos.desafio.modelos.Armas;
import com.aluracursos.desafio.service.ConsumoApi;
import com.aluracursos.desafio.service.ConvierteDatos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrincipalArmas {


    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private static final String URL_Type = "weapons";
    Scanner scanner = new Scanner(System.in);

    public void menuArmas(){

        System.out.println("Haz iniciado el 'MENU DE ARMAS DE HALO 5'");
        System.out.println("******************************************");
        var json = consumoApi.obtenerDatos(URL_Type);
        var datosArray = convierteDatos.obtenerLista(json, Armas.class);
        var opcion = 0;

        do {
            System.out.println("""
                    ==========================================================
                    ***                   Menu de armas                    ***
                    ==========================================================
                    
                                1.- Mostrar lista de todas las armas
                                2.- Mostrar lista de armas por tipo de arma
                                3.- Mostrar Estadisticas de armas
                                4.- Regresar al menu anterior
                                
                    ==========================================================
                    """);
            try {
                opcion = scanner.nextInt();
                switch (opcion){
                    case 1:
                        System.out.println(datosArray);
                        break;
                    case 2:
                        // todo Mostrar submenu de tipo sde armas y crear solicitudes
                        break;
                    case 3:
                        // todo mostrar las estadisticas - cantidad de armas total - cantidad de armas por tipo
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
