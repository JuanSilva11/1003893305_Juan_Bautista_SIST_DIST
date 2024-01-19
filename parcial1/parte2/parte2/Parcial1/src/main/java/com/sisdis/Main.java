package com.sisdis;

import com.sisdis.figuras.Circulo;
import com.sisdis.figuras.Cuadrado;
import com.sisdis.figuras.Triangulo;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ingrese el radio del círculo:");
        Circulo circulo = new Circulo(scanner.nextDouble());
        System.out.println("El área del círculo es: " + circulo.calcularArea());

        System.out.println("Ingrese la base del triángulo:");
        double base = scanner.nextDouble();
        System.out.println("Ingrese la altura del triángulo:");
        double altura = scanner.nextDouble();
        Triangulo triangulo = new Triangulo(base, altura);
        System.out.println("El área del triángulo es: " + triangulo.calcularArea());

        System.out.println("Ingrese el lado del cuadrado:");
        Cuadrado cuadrado = new Cuadrado(scanner.nextDouble());
        System.out.println("El área del cuadrado es: " + cuadrado.calcularArea());

    }
}