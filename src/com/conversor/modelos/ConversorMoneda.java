package com.conversor.modelos;
import com.conversor.api.ApiConversor;


public abstract class ConversorMoneda implements Conversor {
    protected String monedaOrigen;
    protected String monedaDestino;
    protected String siglaOrigen;
    protected String siglaDestino;

    public ConversorMoneda(String monedaOrigen, String siglaOrigen, String monedaDestino, String siglaDestino) {
        this.monedaOrigen = monedaOrigen;
        this.siglaOrigen = siglaOrigen;
        this.monedaDestino = monedaDestino;
        this.siglaDestino = siglaDestino;
    }

    @Override
    public double convertir(double cantidad) {
        try {
            return ApiConversor.obtenerTasaCambio(siglaOrigen, siglaDestino, cantidad);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public String obtenerMonedaOrigen() {
        return siglaOrigen;
    }

    @Override
    public String obtenerMonedaDestino() {
        return siglaDestino;
    }
}
