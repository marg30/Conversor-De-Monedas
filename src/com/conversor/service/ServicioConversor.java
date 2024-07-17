package com.conversor.service;

import com.conversor.modelos.*;

public class ServicioConversor {

    public Conversor obtenerConversor(int opcion) {
        return switch (opcion) {
            case 1 -> new DolarAPesoArgentino();
            case 2 -> new PesoArgentinoADolar();
            case 3 -> new DolarARealBrasilenio();
            case 4 -> new RealBrasilenioADolar();
            case 5 -> new DolarAPesoColombiano();
            case 6 -> new PesoColombianoADolar();
            default -> null;
        };
    }
}
