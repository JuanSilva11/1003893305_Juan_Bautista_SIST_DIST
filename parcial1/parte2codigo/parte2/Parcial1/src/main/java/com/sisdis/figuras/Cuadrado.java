package com.sisdis.figuras;

public class Cuadrado extends FiguraGeometrica {

    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return Math.pow(lado, 2);
    }

}
