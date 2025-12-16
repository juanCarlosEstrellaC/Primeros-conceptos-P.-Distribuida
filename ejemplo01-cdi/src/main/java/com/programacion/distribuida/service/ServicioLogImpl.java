package com.programacion.distribuida.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServicioLogImpl implements IServicioLog {

    @Override
    public void imprimir(String mensaje) {
        System.out.println(java.time.LocalDateTime.now() + " LOG: " + mensaje);
    }
}
