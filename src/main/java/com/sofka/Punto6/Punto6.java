package com.sofka.Punto6;

import java.io.IOException;
import java.util.Scanner;

public class Punto6 {
    
    public String[] contactos = {"","",""};
    public String[] telefonos = {"","",""};
    public String[] organizacion = {"","",""};
    private boolean continuar = true;
    private int opcion;

    public void Punto6() throws IOException{
        Enunciado();
        presioneCualquierTeclaParaContinuar();
        do {
            limpiarPantalla();
            Menu();
            opcion = capturarOpcion();
            limpiarPantalla();
            continuar = evaluarOpcion(opcion, contactos, telefonos, organizacion);
            presioneCualquierTeclaParaContinuar();
        } while (continuar);
    }

    private static boolean evaluarOpcion(int opcion, String[] contactos, String[] telefonos, String[] organizacion) throws IOException{
        switch(opcion){
            case 1:
                agregarContacto(contactos, telefonos, organizacion);
                return true;
            case 2:
                buscarContacto(contactos, telefonos, organizacion);
                return true;
            case 3: 
                eliminarContacto(contactos, telefonos, organizacion);
                return true;
            case 0:
                return false;
            default:
                System.out.println("Opción incorrecta");
        }
        return true;
    }

    private static void agregarContacto(String[] contactos, String[] telefonos, String[] organizacion){
        System.out.println("Agregar un nuevo contacto---");
        solicitarDato("el nombre del nuevo contacto");
        String aux = capturarDatoString();
        int indice = verificarContacto(contactos, aux);
        if (indice == -1) {
            boolean guardado = false;
            for (int i = 0; i < contactos.length; i++) {
                if (contactos[i] == "") {
                    contactos[i] = aux;
                    solicitarDato("el telefono del nuevo contacto");
                    telefonos[i] = capturarDatoString();
                    solicitarDato("el nombre de organizacion del nuevo contacto");
                    organizacion[i] = capturarDatoString();
                    guardado = true;
                    break;
                }
            }
            if (guardado) {
                System.out.println("Contacto guardado correctamente!!");
            }else{
                System.out.println("Agenda de contactos llena.");
            }
        } else {
            System.out.println("El contacto ya se encuetra almacenado.");
        }
    }

    private static void buscarContacto(String[] contactos, String[] telefonos, String[] organizacion){
        System.out.println("Buscar contacto en agenda---");
        solicitarDato("el nombre del contacto que desea buscar");
        String aux = capturarDatoString();
        int indice = verificarContacto(contactos, aux);
        if (indice != -1) {
            System.out.println("");
            System.out.println("Contacto encontrado: ");
            System.out.println("- Nombre: " + contactos[indice] + ", Tel: " + telefonos[indice] + ", Org: " + organizacion[indice]);
        } else {
            System.out.println("El contacto no se encuetra almacenado en agenda.");
        }
    }

    private static void eliminarContacto(String[] contactos, String[] telefonos, String[] organizacion){
        System.out.println("Eliminar contacto en agenda---");
        solicitarDato("el nombre del contacto que desea eliminar");
        String aux = capturarDatoString();
        int indice = verificarContacto(contactos, aux);
        if (indice != -1) {
            System.out.println("");
            System.out.println("Contacto a eliminar: ");
            System.out.println("- Nombre: " + contactos[indice] + ", Tel: " + telefonos[indice] + ", Org: " + organizacion[indice]);
            contactos[indice]="";telefonos[indice]="";organizacion[indice]="";
            System.out.println("Contacto eliminado correctamente!");
        } else {
            System.out.println("El contacto no se encuetra almacenado en agenda.");
        }
    }

    private static int verificarContacto(String[] contactos, String aux){
        int indice = -1; //indice -1 indica que no existe el contacto en la agenda.
        for (int i = 0; i < contactos.length; i++) {
            if (aux.toLowerCase().equals(contactos[i].toLowerCase())) {
                indice = i;
                break;
            }
        }
        return indice;
    }

    private static void Enunciado(){
        System.out.println("6. Se está creando una aplicación que va a estar conectada con un prototipo que permita almacenar contactos telefónicos en el dispositivo. Para ello cada contacto debe contener nombre completo, teléfono y organización. Se requiere que la aplicación permita añadir 3 contactos verificando que el número no esté almacenado, buscar contactos almacenados y eliminar contactos si el usuario lo requiere. Recuerde que el sistema debe terminar cuando el usuario así lo indique.");
    }
    
    public static void Menu(){
        System.out.println("Mi agenda telefónica---");
        System.out.println("1. Agregar nuevo contacto");
        System.out.println("2. Buscar contacto almacenado");
        System.out.println("3. Eliminar contacto almacenado");
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
