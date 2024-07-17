package com.conversor.principal;

import com.conversor.modelos.Conversor;
import com.conversor.service.ServicioConversor;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServicioConversor servicioConversor = new ServicioConversor();

        while (true) {
            System.out.println("******************************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.print("Elija una opción válida: ");
            int opcion = scanner.nextInt();

            if (opcion == 7) break;

            try {
                Conversor conversor = servicioConversor.obtenerConversor(opcion);
                if (conversor != null) {
                    System.out.print("Ingrese el valor que desear convertir: ");
                    double valor = scanner.nextDouble();
                    double resultado = conversor.convertir(valor);
                    System.out.printf("El valor %.2f [%s] corresponde al valor final de =>>> %.2f [%s]%n",
                            valor, conversor.obtenerMonedaOrigen(), resultado, conversor.obtenerMonedaDestino());
                } else {
                    System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Gracias por usar el Conversor de Moneda. ¡Adiós!");
    }
}
