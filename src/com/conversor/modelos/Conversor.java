package com.conversor.modelos;

public interface Conversor {
    double convertir(double cantidad);
    String obtenerMonedaOrigen();
    String obtenerMonedaDestino();
}
