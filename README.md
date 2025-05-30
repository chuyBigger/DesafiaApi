# Proyecto Halo 5 - API y Menús en Java

¡Bienvenido al proyecto de manejo de información del juego **Halo 5**! Este proyecto consume datos de una API externa para mostrar información sobre armas, vehículos y enemigos del juego, además de proporcionar menús interactivos para explorarlos y obtener estadísticas.

---

## Descripción

Este proyecto en **Java** utiliza técnicas modernas como **Streams**, **lambdas** y el framework **Spring Boot** para:

* Consultar una API REST que provee datos del juego Halo 5. [APi halo 5 Oficial 343 Industries](https://developer.haloapi.com/)
* Mostrar menús para explorar armas, vehículos y enemigos.
* Presentar estadísticas simples basadas en los datos obtenidos.
* Practicar buenas prácticas en programación, diseño modular y manejo de excepciones.

---

## Funcionalidades principales

* Menú principal con opciones para:

    * Listar todas las armas.
    * Filtrar armas por tipo.
    * Mostrar estadísticas de armas.
    * Navegar entre menús para vehículos y enemigos (en desarrollo).
* Consumo de API con manejo de datos en formato JSON.
* Uso de Streams para manipulación eficiente de colecciones.
* Control de errores robusto para entradas de usuario.

---

## Tecnologías usadas

* Java 17+
* Spring Boot
* Gson (para parseo JSON)
* Maven/Gradle (según configuración)
* API REST pública (externa para Halo 5)

---

## Cómo usar

1. Clona el repositorio:

   ```bash
   git clone https://github.com/tuusuario/halo5-java.git
   ```

2. Importa el proyecto en tu IDE favorito (IntelliJ IDEA, Eclipse, etc).

3. Ejecuta la aplicación principal (`ApiSpringBootApplication.java`).

4. Navega en el menú interactivo para explorar las opciones.

---

## Estructura del proyecto

* `principal` — Clases con menús principales y navegación.
* `modelos` — Modelos que representan datos como Armas, Vehículos y Enemigos.
* `service` — Servicios para consumir la API y convertir los datos JSON.
* `resources` — Archivos de configuración y recursos estáticos (si aplica).

---

## Licencia

Este proyecto está bajo la licencia **MIT**. Esto significa que puedes usar, modificar y distribuir el código libremente, siempre y cuando mantengas el aviso de copyright.

```text
MIT License

Copyright (c) 2025 Jesús Medina Casas

Se concede permiso, libre de cargos, a cualquier persona que obtenga una copia de este software y los archivos de documentación asociados para usar el software sin restricción, incluyendo sin limitación los derechos a usar, copiar, modificar, fusionar, publicar, distribuir, sublicenciar y/o vender copias del software, y permitir a las personas a quienes se les proporcione el software a hacer lo mismo, sujeto a las siguientes condiciones:

El aviso de copyright anterior y este aviso de permiso se incluirán en todas las copias o partes sustanciales del software.

EL SOFTWARE SE PROPORCIONA "TAL CUAL", SIN GARANTÍA DE NINGÚN TIPO.
```

---

## Próximos pasos

* Completar menús de vehículos y enemigos.
* Implementar filtros y búsquedas más avanzadas.
* Añadir reportes y estadísticas detalladas.
* Mejorar la interfaz de usuario y experiencia.

---

## Contacto

Jesús Medina Casas
LinkedIn: [Jesus MC](https://www.linkedin.com/in/jesus-medina-casas/)
GitHub: [Jesus Code MC](https://github.com/chuyBigger)
