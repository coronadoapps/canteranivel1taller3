package com.sofka.Punto5;

import java.io.IOException;
import java.util.Scanner;

public class Punto5 {
    private String nombre;
    private boolean continuar = true;
    private int opcion;

    public void Punto5() throws IOException{
        Enunciado();
        presioneCualquierTeclaParaContinuar();
        do{
            limpiarPantalla();
            Menu();
            opcion = capturarDatoInt();
            limpiarPantalla();
            switch(opcion){
                case 1:
                    nombre = capturarNombre();
                    continuar = true;
                    break;
                case 2:
                    saludarPersona(nombre);
                    continuar = true;
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    System.in.read();
            }
            presioneCualquierTeclaParaContinuar();
        } while(continuar == true);
    }

    public static void Enunciado(){
        System.out.println("5. Utilizando el ciclo que usted desee, crear un menú de ejecución infinita hasta que el usuario desee terminar dicho ciclo.");
    }

    private static void presioneCualquierTeclaParaContinuar() { 
        System.out.println("Presione cualquier tecla para continuar...");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}  
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static void solicitarDato(String dato){
        System.out.println("Por favor ingrese " + dato);
    }

    private static int capturarDatoInt(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    private static String capturarDatoString(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private static void Menu(){
        System.out.println("Menú de usuario");
        System.out.println("1. Captura nombre");
        System.out.println("2. Saludar persona");
        System.out.println("3. Salir del sistema");
    }

    private static String capturarNombre(){
        solicitarDato("su nombre ");
        String nombre = capturarDatoString();
        return nombre;
    }

    private static void saludarPersona(String nombre){
        if (nombre != null) {
            System.out.println("Hola " + nombre);
        } else{
            System.out.println("Por favor ingrese su nombre");
        }
    }
}
