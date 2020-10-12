package com.example.calculadora.OperacionesEspeciales;

public class Seno implements OperacionesEspeciales {

    @Override
    public double calcular(double numero) {
        return Math.sin(numero);
    }
}
