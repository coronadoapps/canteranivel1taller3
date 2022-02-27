package com.sofka.Punto7;

import java.io.IOException;
import java.util.Scanner;

public class Punto7 {
    
    public String[] placas = {"","","","",""};
    public String[] marcas = {"","","","",""};
    public String[] nombres = {"","","","",""};
    public String[] telefonos = {"","","","",""};
    private boolean continuar = true;
    private int opcion;

    public void Punto7() throws IOException{
        Enunciado();
        presioneCualquierTeclaParaContinuar();
        do {
            limpiarPantalla();
            Menu();
            opcion = capturarOpcion();
            limpiarPantalla();
            continuar = evaluarOpcion(opcion, placas, marcas, nombres, telefonos);
            presioneCualquierTeclaParaContinuar();
        } while (continuar);
    }

    private static boolean evaluarOpcion(int opcion, String[] placas, String[] marcas, String[] nombres, String[] telefonos) throws IOException{
        switch(opcion){
            case 1:
                ingresarParqueadero(placas, marcas, nombres, telefonos);
                return true;
            case 2:
                retirarVehiculo(placas, marcas, nombres, telefonos);
                return true;
            case 3: 
                buscarVehiculo(placas, marcas, nombres, telefonos);
                return true;
            case 0:
                return false;
            default:
                System.out.println("Opción incorrecta");
        }
        return true;
    }

    private static void ingresarParqueadero(String[] placas, String[] marcas, String[] nombres, String[] telefonos){
        System.out.println("Ingresar nuevo vehículo al parqueadero---");
        solicitarDato("la placa del nuevo vehículo");
        String aux = capturarDatoString();
        int indice = verificarVehiculo(placas, aux);
        if (indice == -1) {
            boolean guardado = false;
            for (int i = 0; i < placas.length; i++) {
                if (placas[i] == "") {
                    placas[i] = aux;
                    solicitarDato("la marca del nuevo vehículo");
                    marcas[i] = capturarDatoString();
                    solicitarDato("el nombre del propietario del nuevo vehículo");
                    nombres[i] = capturarDatoString();
                    solicitarDato("el numero de telefono del propietario");
                    telefonos[i] = capturarDatoString();
                    guardado = true;
                    break;
                }
            }
            if (guardado) {
                System.out.println("Vehículo ingresado correctamente!!");
            }else{
                System.out.println("Capacidad máxima del parqueadero alcanzada.");
            }
        } else {
            System.out.println("El vehículo ya se encuentra ingresado.");
        }
    }

    private static void buscarVehiculo(String[] placas, String[] marcas, String[] nombres, String[] telefonos){
        System.out.println("Buscar vehículo en el parqueadero---");
        solicitarDato("la placa del vehículo que desea buscar");
        String aux = capturarDatoString();
        int indice = verificarVehiculo(placas, aux);
        if (indice != -1) {
            System.out.println("");
            System.out.println("Vehículo encontrado en el puesto " + indice + ": ");
            System.out.println("- Nombre: " + nombres[indice] + ", Tel: " + telefonos[indice] + ", Vehículo: " + marcas[indice] + " - " + placas[indice]);
        } else {
            System.out.println("El vehículo no se encuentra registrado en el parqueadero.");
        }
    }

    private static void retirarVehiculo(String[] placas, String[] marcas, String[] nombres, String[] telefonos){
        System.out.println("Retirar vehículo del parqueadero---");
        solicitarDato("la placa del vehículo que desea retirar");
        String aux = capturarDatoString();
        int indice = verificarVehiculo(placas, aux);
        if (indice != -1) {
            System.out.println("");
            System.out.println("Vehículo a retirar: ");
            System.out.println("- Nombre: " + nombres[indice] + ", Tel: " + telefonos[indice] + ", Vehículo: " + marcas[indice] + " - " + placas[indice]);
            placas[indice]="";marcas[indice]="";nombres[indice]="";telefonos[indice]="";
            System.out.println("Vehículo retirado correctamente!");
        } else {
            System.out.println("El vehículo no se encuentra registrado en el parqueadero.");
        }
    }

    private static int verificarVehiculo(String[] placas, String aux){
        int indice = -1; //indice -1 indica que no existe el contacto en la agenda.
        for (int i = 0; i < placas.length; i++) {
            if (aux.toLowerCase().equals(placas[i].toLowerCase())) {
                indice = i;
                break;
            }
        }
        return indice;
    }

    private static void Enunciado(){
        System.out.println("7. El parqueadero El guardián presta sus servicios de parqueadero nocturno para los usuarios del barrio y requiere una aplicación que permita registrar los vehículos que se cuidan en estas instalaciones. Se sugiere que el parqueadero tenga los atributos del vehículo como son, placa y marca, y los datos del cliente como son nombre completo y número de teléfono. Para cada vehículo se debe permitir la opción de ingresar al parqueadero, retirar del parqueadero y consultar si un vehículo se encuentra en el parqueadero. Recuerde que el sistema debe terminar cuando el usuario así lo indique. Tenga en presente que el parqueadero solo puede almacenar máximo 5 vehículos.");
    }
    
    public static void Menu(){
        System.out.println("Parqueadero El Guardián---");
        System.out.println("1. Ingresar vehículo al parqueadero");
        System.out.println("2. Retirar vehículo del parqueadero");
        System.out.println("3. Consultar si su vehículo se encuentra en el parqueadero");
        System.out.println("0. Salir de la aplicación");
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    private static int capturarOpcion() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
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

    public static void solicitarDato(String dato){
        System.out.println("Por favor ingrese " + dato);
    }

    private static String capturarDatoString(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
