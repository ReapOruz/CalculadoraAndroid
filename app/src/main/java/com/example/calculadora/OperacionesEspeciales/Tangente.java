package com.example.calculadora.OperacionesEspeciales;

public class Tangente implements OperacionesEspeciales{

    @Override
    public double calcular(double numero) {
        return Math.tan(numero);
    }
}
