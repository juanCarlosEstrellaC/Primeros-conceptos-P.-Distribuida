plugins {
    id("java")
    id("application")
    // Uso shadow para crear un jar ejecutable, con todas las dependencias, ie, autocontenido.
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    //CDI: Weld
    // https://mvnrepository.com/artifact/org.jboss.weld.se/weld-se-core
    // implementation("org.jboss.weld.se:weld-se-core:6.0.2.Final")

    //implementation("org.jboss.weld.se:weld-se-core:6.0.2.Final")
    // https://mvnrepository.com/artifact/io.smallrye/jandex
    //implementation("io.smallrye:jandex:3.2.7")

    //REST: usando RESTEasy
    // https://mvnrepository.com/artifact/org.jboss.resteasy/resteasy-core
    implementation("org.jboss.resteasy:resteasy-core:6.2.12.Final")

    //Necesitamos un servidor
    implementation("org.jboss.resteasy:resteasy-undertow-cdi:6.2.12.Final")

}

sourceSets {
    main {
        output.setResourcesDir( file("${buildDir}/classes/java/main") )
    }}

tasks.shadowJar{
 mergeServiceFiles()
}

tasks.jar{
    manifest {
        attributes("Main-Class" to "com.programacion.distribuida.Ejemplo03Main",
            "Class-Path" to configurations.runtimeClasspath
                .get()
                .joinToString(" "){
                    file->"${file.name}"
                })
    }
}