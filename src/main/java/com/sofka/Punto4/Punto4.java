package com.sofka.Punto4;

import java.util.Scanner;

public class Punto4 {

    private int numero;

    public void Punto4(){
        Enunciado();
        presioneCualquierTeclaParaContinuar();
        limpiarPantalla();
        solicitarDato("el numero ");
        numero = capturarDatoInt();
        calcularTabla(numero);
        presioneCualquierTeclaParaContinuar();
    }

    public static void Enunciado(){
        System.out.println("4. Se requiere un programa que pueda crear la tabla de multiplicar del número que el usuario indique por medio del ciclo Para for; esta debe ser impresa del 1 al 10. Ejemplo, si el usuario indica que desea crear la tabla del 5, entonces el resultado debería ser el siguiente:");
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

    private static void calcularTabla(int numero){
        for (int i = 1; i < 11; i++) {
            System.out.println(i + " x " + numero + " = " + (i*numero));
        }
    }
}
