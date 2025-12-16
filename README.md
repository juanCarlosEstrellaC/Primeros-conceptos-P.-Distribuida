# Proyecto de Programación Distribuida (CDI & REST)

Este repositorio contiene ejemplos progresivos para aprender **Jakarta EE (CDI y REST)**, desde una aplicación de consola hasta microservicios modernos.

El proyecto es **multi-módulo con Gradle** y contiene los siguientes ejemplos:

## Estructura de Módulos

### 1. `ejemplo01-cdi` (CDI Standalone)
**Concepto:** Inyección de Dependencias pura ("Spring Core").
*   **Qué hace:** Una aplicación de consola simple (`main`) que usa **Weld SE** para gestionar la inyección de dependencias (`@Inject`).
*   **Para qué sirve:** Entender cómo funciona CDI sin la complejidad de servidores web.
*   **Cómo correrlo:** Ejecutando la clase `PrincipalCdi` como una aplicación Java normal.

### 2. `ejemplo02-rest` (Servicio REST Clásico - WAR)
**Concepto:** Aplicación Web Tradicional ("Spring MVC en Tomcat").
*   **Qué hace:** Expone una API REST usando **Jakarta REST (JAX-RS)** y CDI.
*   **Arquitectura:** Genera un archivo `.war`. No tiene servidor propio; "parasita" al servidor donde se despliega.
*   **Dependencias:** `compileOnly` (porque el servidor real, como Payara o WildFly, ya trae las librerías).
*   **Cómo correrlo:** Desplegando el archivo WAR generado en un servidor de aplicaciones compatible (Payara, WildFly, OpenLiberty).

### 3. `ejemplo03-custom-rest` (Servicio REST Moderno - Fat JAR)
**Concepto:** Microservicio Autocontenido ("Estilo Quarkus/Spring Boot").
*   **Qué hace:** Una aplicación autónoma que **incluye su propio servidor** embebido.
*   **Arquitectura:** Genera un "Fat JAR" (Jar con todas las dependencias).
*   **Tecnologías:** Combina manualmente **Undertow** (servidor web), **RESTEasy** (implementación JAX-RS) y **Weld** (CDI).
*   **Cómo correrlo:** Ejecutando el JAR generado: `java -jar app-all.jar`.

---
**Tecnologías Clave:**
*   **Java 17+**
*   **Gradle:** Gestor de construcción.
*   **Jakarta CDI:** Estándar de inyección de dependencias.
*   **Jakarta REST (JAX-RS):** Estándar de servicios web REST.
