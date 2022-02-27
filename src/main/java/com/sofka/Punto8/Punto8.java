package com.sofka.Punto8;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.BoldAction;

public class Punto8 {
    
    public String[] usuarios = {"","","","","","","",""};
    public boolean[] cursados = new boolean[8];
    public boolean[] aprobados = new boolean[8];
    private boolean continuar = true;
    private int opcion;

    public void Punto8() throws IOException{
        Enunciado();
        presioneCualquierTeclaParaContinuar();
        do {
            limpiarPantalla();
            Menu();
            opcion = capturarOpcion();
            limpiarPantalla();
            continuar = evaluarOpcion(opcion, usuarios, cursados, aprobados);
            presioneCualquierTeclaParaContinuar();
        } while (continuar);
    }

    private static boolean evaluarOpcion(int opcion, String[] usuarios, boolean[] cursados, boolean[] aprobados) throws IOException{
        switch(opcion){
            case 1:
                registrarIngreso(usuarios, cursados, aprobados);
                return true;
            case 2:
                presentaronCurso(usuarios, cursados, aprobados);
                return true;
            case 0:
                return false;
            default:
                System.out.println("Opción incorrecta");
        }
        return true;
    }

    private static void registrarIngreso(String[] usuarios, boolean[] cursados, boolean[] aprobados){
        System.out.println("Registrar ingreso al curso---");
        solicitarDato("el nombre del nuevo usuario a registrar");
        String aux = capturarDatoString();
        int indice = verificarRegistro(usuarios, aux);
        if (indice == -1) {
            boolean guardado = false;
            for (int i = 0; i < usuarios.length; i++) {
                if (usuarios[i] == "") {
                    usuarios[i] = aux;
                    cursados[i] = preguntarCursado();
                    aprobados[i] = preguntarAprobado();
                    guardado = true;
                    break;
                }
            }
            if (guardado) {
                System.out.println("Usuario registrado correctamente!!");
            }else{
                System.out.println("Capacidad máxima alcanzada.");
            }
        } else {
            System.out.println("El usuario ya se encuentra registrado.");
        }
    }

    private static boolean preguntarCursado(){
        System.out.println("El usuario ha presentado el curso SI/NO");
        String aux = capturarDatoString();
        if (aux.toLowerCase().equals("si")){
            return true;
        } else {
            return false;
        }
    }

    private static boolean preguntarAprobado(){
        System.out.println("El usuario ha aprobado el curso SI/NO");
        String aux = capturarDatoString();
        if (aux.toLowerCase().equals("si")){
            return true;
        } else {
            return false;
        }
    }

    private static void presentaronCurso(String[] usuarios, boolean[] cursados, boolean[] aprobados){
        System.out.println("Usuarios que presentaron el curso");
        for (int i = 0; i < usuarios.length; i++) {
            String aprob = (aprobados[i]) ? "Aprobado" : "No aprobado";
            if (usuarios[i] != "" && cursados[i]) {
                System.out.println(usuarios[i] + " presenta el curso en estado: " + aprob);
            }            
        }
        System.out.println("");
    }

    private static int verificarRegistro(String[] usuarios, String aux){
        int indice = -1; //indice -1 indica que no existe.
        for (int i = 0; i < usuarios.length; i++) {
            if (aux.toLowerCase().equals(usuarios[i].toLowerCase())) {
                indice = i;
                break;
            }
        }
        return indice;
    }

    private static void Enunciado(){
        System.out.println("8. La escuela automovilística El Maestro requiere una aplicación que permita registrar a sus clientes en los cursos de enseñanza automovilística y establecer quienes lo han aprobado para continuar con el trámite de adquirir la licencia de conducción. Para cada usuario se debe permitir registrar su ingreso al curso, consultar usuarios que hayan presentado el curso y resultados de la prueba del curso (si fueron aprobados o no). Recuerde que el sistema debe terminar cuando el usuario así lo indique. Tenga presente que la escuela tiene capacidad máxima de gestionar 8 usuarios en su totalidad.");
    }
    
    public static void Menu(){
        System.out.println("Escuela automovilística El Maestro---");
        System.out.println("1. Registrar ingreso al curso");
        System.out.println("2. Consultar usuarios que presentaron el curso y resultados");
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
