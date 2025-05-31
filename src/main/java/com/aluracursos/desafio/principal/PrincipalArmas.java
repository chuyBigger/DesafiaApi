package com.aluracursos.desafio.principal;

import com.aluracursos.desafio.service.RepositorioDeArmas;
import com.aluracursos.desafio.service.SubMenuArmas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrincipalArmas {

    RepositorioDeArmas repositorioDeArmas = new RepositorioDeArmas();
    SubMenuArmas subMenuArmas = new SubMenuArmas();
    Scanner scanner = new Scanner(System.in);

    public void menuArmas(){

        System.out.println("Haz iniciado el 'MENU DE ARMAS DE HALO 5'");
        System.out.println("******************************************");

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
                String entrada = scanner.nextLine();
                try {
                    opcion = Integer.parseInt(entrada);
                }catch (NumberFormatException e){
                    System.out.println("Entrada no válida. Por favor ingresa un número.");
                    opcion = -1; // fuerza a que el bucle continue
                }
                switch (opcion){
                    case 1:
                        repositorioDeArmas.listaDeArmasCompleta();
                        System.out.println("Presiona enter para continuar...");
                        scanner.nextLine();
                        break;
                    case 2:
                        subMenuArmas.menuTipoArma();
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
