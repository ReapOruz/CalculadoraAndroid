package com.example.calculadora.OperacionesBasicas;

public class Resta implements OperacionesBasicas{
    @Override
    public double calcular(double numero1, double numero2) {
        return  numero1 - numero2;
    }
}
