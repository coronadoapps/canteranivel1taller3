package com.sofka.Punto1;

public class Punto1 {
    private int size;

    public void Punto1(){
        size = 10;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
