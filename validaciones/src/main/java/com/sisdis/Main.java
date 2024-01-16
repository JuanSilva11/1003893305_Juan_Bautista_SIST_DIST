package com.sisdis;

public class Main {

    public static void main(String[] args) {

        IValidarDatos validarDatos = new ValidarDatos();

        System.out.println("Ingrese una cadena de solo texto:");
        String texto = validarDatos.validarSoloTexto();
        System.out.println("El texto ingresado es: " + texto);

        System.out.println("Ingrese un número entero:");
        int entero = validarDatos.validarEntero();
        System.out.println("El número entero ingresado es: " + entero);

        System.out.println("Ingrese un número entero dentro de un rango");
        int enteroConRango = validarDatos.validarEnteroConRango();
        System.out.println("El número entero ingresado es: " + enteroConRango);

        System.out.println("Ingrese un número entero positivo mayor a 0:");
        int enteroPositivo = validarDatos.validarEnteroPositivo();
        System.out.println("El número entero positivo ingresado es: " + enteroPositivo);

        System.out.println("Ingrese un número entero negativo menor a 0:");
        int enteroNegativo = validarDatos.validarEnteroNegativo();
        System.out.println("El número entero negativo ingresado es: " + enteroNegativo);

        System.out.println("Ingrese un número decimal:");
        double decimal = validarDatos.validarDecimal();
        System.out.println("El número decimal ingresado es: " + decimal);

        System.out.println("Ingrese un número decimal dentro de un rango");
        double decimalConRango = validarDatos.validarDecimalConRango();
        System.out.println("El número decimal ingresado es: " + decimalConRango);

        System.out.println("Ingrese un número decimal positivo mayor a 0:");
        double decimalPositivo = validarDatos.validarDecimalPositivo();
        System.out.println("El número decimal positivo ingresado es: " + decimalPositivo);

        System.out.println("Ingrese un número decimal negativo menor a 0:");
        double decimalNegativo = validarDatos.validarDecimalNegativo();
        System.out.println("El número decimal negativo ingresado es: " + decimalNegativo);

    }

}