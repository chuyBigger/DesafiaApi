# Proyecto Halo 5 - API y Menús en Java

¡Bienvenido al proyecto de manejo de información del juego **Halo 5 Guardians**!  
Este servidor en consola, desarrollado en **Java**, consume datos de una API externa y permite al usuario explorar información sobre **armas**, **vehículos** y **enemigos**, además de consultar estadísticas mediante menús interactivos.

---

## 🕹️ Descripción

Este proyecto utiliza técnicas modernas de Java para:

- Consultar una API REST de Halo 5.
  > [API oficial de 343 Industries](https://developer.haloapi.com/)
- Explorar armas, vehículos y enemigos del juego.
- Obtener estadísticas generales por tipo o categoría.
- Practicar buenas prácticas de programación, diseño modular y manejo de errores.
- Integrar conceptos como `Streams`, `Lambdas` y `POJOs` con consumo de API JSON.

---

## 📌 Funcionalidades principales

### ✅ Menú de Armas
- Buscar armas por nombre.
- Listar todas las armas.
- Filtrar armas por tipo (`Power`, `Standard`, `Grenade`, `Turret`, etc.).
- Mostrar estadísticas agrupadas por tipo.

### ✅ Menú de Enemigos
- Buscar enemigos por nombre.
- Listar todos los enemigos.
- Filtrar enemigos por facción (`UNSC`, `Covenant`, `Promethean`, etc.).
- Mostrar estadísticas por facción.

### ✅ Menú de Vehículos
- Listar todos los vehículos.
- Filtrar vehículos por jugabilidad (`Jugables`, `No Jugables`).
- Mostrar estadísticas generales de uso.

### Otras características:
- Menú de navegación intuitivo por consola.
- Interfaz de texto clara y estructurada.
- Estadísticas visuales con barras proporcionales.
- Control robusto de errores en la entrada del usuario.
- Separación por capas: modelo, servicio y presentación.

---

## 🛠️ Tecnologías utilizadas

- **Java 17+**
- **Spring Boot**
- **Gson** (para manejo de JSON)
- **Maven** (gestión de dependencias)
- **API REST pública** (Halo 5 de 343 Industries)

---

## 🚀 Cómo ejecutar el proyecto

1. Clona el repositorio:

   ```bash
   git clone https://github.com/tuusuario/halo5-java.git
   ```

2. Importa el proyecto en tu IDE favorito (IntelliJ, Eclipse, VS Code con extensión Java, etc.).

3. Ejecuta la clase principal:

   ```java
   ApiSpringBootApplication.java
   ```

4. Navega a través de los menús desde la terminal.

---

## 🧱 Estructura del proyecto

```
/src
├── principal/        → Menús principales y navegación
├── modelos/          → Clases que representan Armas, Enemigos, Vehículos
├── service/          → Lógica de negocio y consumo de API
├── resources/        → Configuración y recursos (si aplica)
```

---

## 📈 Ejemplo de estadísticas (ARMAS)

```
Tipo: Power      → 22 armas   ████████████████████
Tipo: Turret     → 15 armas   █████████████
Tipo: Standard   → 13 armas   ███████████
Tipo: Vehicle    → 10 armas   █████████
Tipo: Unknown    →  5 armas   ████
Tipo: Grenade    →  3 armas   ██

Total de armas registradas: 68
```

---

## 📅 Estado actual del proyecto

✅ Funcionalidad completa de los menús:
- Armas ✅
- Enemigos ✅
- Vehículos ✅

🛠️ Mejora continua:
- Validaciones refinadas en consola.
- Limpieza y refactorización del código.
- Módulo de reportes planeado.

---

## 📌 Próximos pasos

- Agregar persistencia de datos con archivos JSON o base de datos.
- Implementar generación automática de reportes.
- Mejorar formato visual en consola (con colores o tablas ASCII).
- Añadir pruebas unitarias con JUnit.
- Versionar con releases estables.

---

## 📄 Licencia

Este proyecto está bajo la licencia **MIT**, lo que permite su uso, modificación y distribución bajo los términos siguientes:

```text
MIT License

Copyright (c) 2025 Jesús Medina Casas

Se concede permiso, libre de cargos, a cualquier persona que obtenga una copia de este software y los archivos de documentación asociados para usar el software sin restricción, incluyendo sin limitación los derechos a usar, copiar, modificar, fusionar, publicar, distribuir, sublicenciar y/o vender copias del software, y permitir a las personas a quienes se les proporcione el software a hacer lo mismo, sujeto a las siguientes condiciones:

El aviso de copyright anterior y este aviso de permiso se incluirán en todas las copias o partes sustanciales del software.

EL SOFTWARE SE PROPORCIONA "TAL CUAL", SIN GARANTÍA DE NINGÚN TIPO.
```

---

## 👨‍💻 Desarrollador

**Jesús Medina Casas**

- 🎓 Estudiante de Oracle Next Education (ONE)
- 💻 Autodidacta y apasionado por la programación en Java
- 🌐 [LinkedIn - Jesús MC](https://www.linkedin.com/in/jesus-medina-casas/)
- 🧑‍💻 [GitHub - Jesus Code MC](https://github.com/chuyBigger)
