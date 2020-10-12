package com.example.calculadora.OperacionesEspeciales;

public class Coseno implements OperacionesEspeciales {

    @Override
    public double calcular(double numero) {
        return Math.cos(numero);
    }
}
