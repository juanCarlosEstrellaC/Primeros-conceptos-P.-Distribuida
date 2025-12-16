package com.programacion.distribuida.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ServicioStringImpl implements IServicioString {

    @Inject
    IServicioLog log;

    @Override
    public String convertirAMayuscula(String texto) {
        log.imprimir("Convertiendo: " + texto);
        return texto.toUpperCase();
    }
}
