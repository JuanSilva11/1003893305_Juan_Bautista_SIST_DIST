package com.sisdis;

import java.util.Scanner;

public class ValidarDatos implements IValidarDatos{

    @Override
    public String validarSoloTexto() {
        String input;
        do {
            input = scanner.nextLine();
            if (!input.matches("[a-zA-Z]+")) {
                System.out.println("Por favor, ingrese solo texto.");
            }
        } while (!input.matches("[a-zA-Z]+"));
        return input;
    }

    private Scanner scanner = new Scanner(System.in);

    @Override
    public int validarEntero() {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número entero válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    @Override
    public int validarEnteroConRango() {
        System.out.println("Ingrese el valor mínimo del rango:");
        int min = validarEntero();
        System.out.println("Ingrese el valor máximo del rango:");
        int max = validarEntero();

        int num;
        do {
            System.out.println("Ingrese un número entero dentro del rango " + min + " - " + max + ":");
            num = validarEntero();
            if (num < min || num > max) {
                System.out.println("Por favor, ingrese un número entero dentro del rango " + min + " - " + max + ".");
            }
        } while (num < min || num > max);
        return num;
    }

    @Override
    public int validarEnteroPositivo() {
        int num;
        do {
            num = validarEntero();
            if (num <= 0) {
                System.out.println("Por favor, ingrese un número entero positivo. mayor a 0");
            }
        } while (num <= 0);
        return num;
    }

    @Override
    public int validarEnteroNegativo() {
        int num;
        do {
            num = validarEntero();
            if (num >= 0) {
                System.out.println("Por favor, ingrese un número entero negativo.");
            }
        } while (num >= 0);
        return num;
    }

    @Override
    public double validarDecimal() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Por favor, ingrese un número decimal válido.");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    @Override
    public double validarDecimalConRango() {
        System.out.println("Ingrese el valor mínimo del rango:");
        double min = validarDecimal();
        System.out.println("Ingrese el valor máximo del rango:");
        double max = validarDecimal();

        double num;
        do {
            System.out.println("Ingrese un número decimal dentro del rango " + min + " - " + max + ":");
            num = validarDecimal();
            if (num < min || num > max) {
                System.out.println("Por favor, ingrese un número decimal dentro del rango " + min + " - " + max + ".");
            }
        } while (num < min || num > max);
        return num;
    }

    @Override
    public double validarDecimalPositivo() {
        double num;
        do {
            num = validarDecimal();
            if (num <= 0) {
                System.out.println("Por favor, ingrese un número decimal positivo.");
            }
        } while (num <= 0);
        return num;
    }

    @Override
    public double validarDecimalNegativo() {
        double num;
        do {
            num = validarDecimal();
            if (num >= 0) {
                System.out.println("Por favor, ingrese un número decimal negativo.");
            }
        } while (num >= 0);
        return num;
    }

}
