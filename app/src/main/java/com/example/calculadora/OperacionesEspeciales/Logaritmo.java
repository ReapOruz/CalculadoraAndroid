package com.example.calculadora.OperacionesEspeciales;

public class Logaritmo implements OperacionesEspeciales {

    @Override
    public double calcular(double numero) {
        return Math.log10(numero);
    }

}
