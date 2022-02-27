package com.sofka.Punto2;

public class Punto2 {
    private int size, x, i, j;

    public void Punto2(){
        size = 10;
        x = size;
        j = size;
        i = 0;
        while(!(x == 0)){
            while(i < x) {
                System.out.print(" ");
                i = i + 1;
            }
            while(x <= j){
                System.out.print("*");
                j = j - 1;
            }
            System.out.println("");
            i = 0;
            j = size;
            x = x - 1;
        }
    }
}
