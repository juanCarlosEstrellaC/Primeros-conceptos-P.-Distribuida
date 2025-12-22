package com.programacion.distribuida;

import jakarta.ws.rs.SeBootstrap;

import java.net.URI;

public class Ejemplo03Main {

    public static void main(String[] args) throws Exception {
        // SeBootstrap es una clase que permite iniciar un servidor embebido como Undertow.
        var configuracion = SeBootstrap.Configuration.builder()
                .port(8080)
                .build();

        SeBootstrap.start(RestApplication.class, configuracion)
                .thenApply(instancia -> {
                    URI uri = instancia.configuration().baseUri();
                    System.out.printf("La instancia %s está corriendo en %s", instancia, uri);
                    return instancia;
                })
                .exceptionally(ex -> {
                    ex.printStackTrace();
                    return null;
                });

        Thread.currentThread().join();
    }
}