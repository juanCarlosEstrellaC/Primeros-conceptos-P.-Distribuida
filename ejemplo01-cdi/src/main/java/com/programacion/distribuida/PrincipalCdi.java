package com.programacion.distribuida;

import com.programacion.distribuida.service.IServicioString;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class PrincipalCdi {

    public static void main(String[] args) {
        // Se inicia el contenedor CDI
        try (SeContainer contenedor = SeContainerInitializer.newInstance().initialize()) {
            // Se obtiene el servicio de mi clase ServicioString.
            IServicioString servicio = contenedor.select(IServicioString.class).get();
            String respuesta = servicio.convertirAMayuscula("Hola mundo, xd.");
            System.out.println(respuesta);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
