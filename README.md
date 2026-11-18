# BiblioUni — Unidad 2: Pruebas de Software

## Descripción del proyecto

BiblioUni es un proyecto académico desarrollado para aplicar estrategias, técnicas y herramientas de pruebas de software, como parte de la Unidad 2 de la asignatura Pruebas de Software de Uniempresarial.

**Advertencia académica:** este proyecto corresponde a una implementación de referencia, debido a que no se contó con el código original del Módulo 2. No debe considerarse la implementación original del sistema BiblioUni.

La aplicación utiliza Java 21 y Spring Boot, e incluye un catálogo de materiales en memoria, un servicio de consulta y un controlador REST. Las funcionalidades de préstamos, devoluciones, multas, persistencia y recomendaciones permanecen pendientes de implementación.

## Objetivos

- Diseñar y documentar casos de prueba utilizando técnicas de partición de equivalencia, análisis de valores límite y transición de estados.
- Aplicar pruebas automatizadas con JUnit 5 y Mockito.
- Desarrollar y documentar ciclos TDD mediante las fases RED, GREEN y REFACTOR.
- Registrar resultados y evidencias de ejecución.
- Organizar el proyecto y sus documentos mediante Git y GitHub.

## Contenido del repositorio

### Documentación

Los archivos se encuentran en `docs/pruebas/`:

- `estrategia.md`: estrategia y alcance de las pruebas.
- `plan_de_pruebas.md`: planificación de las actividades de prueba.
- `casos_de_prueba.md`: diseño de 15 casos de prueba.
- `escenarios.md`: escenarios funcionales propuestos.
- `calidad_iso25010.md`: análisis de calidad según ISO/IEC 25010.
- `mapa_conceptual.png`: mapa conceptual.
- `evidencias_tdd.md`: documentación de dos ciclos TDD RED–GREEN–REFACTOR.
- Archivos `.png`: capturas de evidencia de las ejecuciones y los ciclos TDD.

### Código fuente

- `src/main/java/com/bibliouni/`: aplicación Spring Boot, modelo, servicio y controlador.
- `src/test/java/com/bibliouni/`: pruebas automatizadas de servicio y controlador.
- `pom.xml`: configuración de Maven y dependencias.

## Herramientas utilizadas

- Java 21.
- Spring Boot.
- Maven.
- JUnit 5.
- Mockito.
- Visual Studio Code.
- Git y GitHub.

## Ejecución de las pruebas

Desde la carpeta principal del proyecto, ejecutar:

```powershell
mvn test
```

Es necesario contar con Java 21 y Maven instalado y configurado.

## Resultados obtenidos

La ejecución final de la suite automatizada registró:

| Indicador | Resultado |
|---|---|
| Pruebas automatizadas ejecutadas | 10 |
| Pruebas fallidas | 0 |
| Errores | 0 |
| Pruebas omitidas | 0 |
| Resultado de Maven | BUILD SUCCESS |
| Casos de prueba diseñados | 15 |
| Ciclos TDD documentados | 2 |

**Aclaración:** las 10 pruebas automatizadas no equivalen a la ejecución de los 15 casos de prueba documentados. Los casos correspondientes a funcionalidades no implementadas permanecen pendientes.

## Evidencias

Las capturas de las ejecuciones y de los ciclos TDD están disponibles en `docs/pruebas/`.

La documentación detallada se encuentra en:

- `docs/pruebas/casos_de_prueba.md`
- `docs/pruebas/evidencias_tdd.md`

## Estado del proyecto

Se completó la documentación de los 15 casos de prueba y la ejecución de 10 pruebas automatizadas sobre las funcionalidades disponibles en esta implementación de referencia.

Se documentaron dos ciclos TDD con sus respectivas evidencias. Las funcionalidades futuras requieren desarrollo y validación antes de ejecutar sus casos de prueba.

## Repositorio

Proyecto publicado en GitHub:

https://github.com/manuelduartearias22-blip/BiblioUni_Unidad2