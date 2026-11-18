
# Plan de pruebas formal — BiblioUni

## 1. Identificación del plan

- **Proyecto:** BiblioUni — Sistema de gestión bibliotecaria.
- **Asignatura:** Pruebas de Software.
- **Unidad:** 2 — Ecosistema de pruebas.
- **Identificador:** PP-BU-002.
- **Versión:** 1.0.
- **Fecha:** 17 de noviembre de 2026.
- **Responsable:** Estudiante / equipo de pruebas.
- **Estado:** Planificación.

## 2. Introducción

El presente plan establece la estrategia de verificación del sistema BiblioUni, tomando como referencia las funcionalidades y los escenarios documentados durante la Unidad 1.

Se adopta el estándar IEEE 829 para organizar el alcance, los recursos, los criterios de entrada y salida, las responsabilidades, los riesgos y las evidencias del proceso de pruebas.

El proyecto corresponde a una implementación académica de referencia. Actualmente dispone de funcionalidades de consulta y validación de materiales bibliográficos, así como de una implementación básica del servicio de préstamos que permite verificar la disponibilidad de un material antes de autorizarlo. La gestión completa de préstamos, devoluciones, multas, usuarios y persistencia requiere desarrollo adicional.

## 3. Objetivos

### Objetivo general

Planificar, diseñar y ejecutar pruebas de software para verificar el comportamiento de los servicios de BiblioUni, utilizando técnicas de diseño de casos, JUnit 5, Mockito y desarrollo guiado por pruebas (TDD).

### Objetivos específicos

1. Documentar al menos 15 casos de prueba formales.
2. Aplicar partición de equivalencia y análisis de valores límite.
3. Implementar al menos 6 pruebas unitarias con JUnit 5 y Mockito.
4. Desarrollar al menos 2 funcionalidades mediante ciclos TDD.
5. Identificar defectos y documentar los resultados.
6. Conservar evidencias de ejecución y cambios en GitHub.

## 4. Alcance

### 4.1 Funcionalidades incluidas

- Creación y consulta de materiales bibliográficos.
- Búsqueda de materiales por identificador.
- Manejo de materiales inexistentes.
- Validación de disponibilidad de materiales.
- Registro de préstamos.
- Restricciones para prestar materiales no disponibles.
- Cálculo de multas por devolución tardía.
- Validaciones de entradas y valores límite.

Las funcionalidades de préstamos que aún no estén implementadas se desarrollarán como parte del alcance de esta unidad.

### 4.2 Funcionalidades excluidas

- Pruebas de carga masiva.
- Pruebas de penetración avanzadas.
- Compatibilidad exhaustiva entre navegadores.
- Pruebas de infraestructura distribuida.
- Recomendaciones automatizadas de materiales.
- Integración con servicios externos no disponibles.

Estas exclusiones responden al alcance académico y a los recursos disponibles.

## 5. Enfoque y estrategia de pruebas

Se aplicará un enfoque basado en riesgos, priorizando las funcionalidades relacionadas con la disponibilidad de materiales y la integridad de los préstamos.

### 5.1 Pruebas unitarias

Se utilizarán JUnit 5 y Mockito para verificar los métodos de los servicios de forma aislada.

### 5.2 Pruebas de integración

Se contemplará la verificación de la interacción entre componentes cuando las dependencias necesarias estén implementadas.

### 5.3 Pruebas de API REST

Se verificarán los códigos HTTP, las respuestas JSON y el tratamiento de errores de los endpoints disponibles.

### 5.4 Técnicas de diseño

- Partición de equivalencia.
- Análisis de valores límite.
- Casos positivos y negativos.
- Transiciones de estado cuando corresponda.
- Desarrollo guiado por pruebas (TDD).

## 6. Criterios de entrada

Las pruebas podrán comenzar cuando:

1. El proyecto Java compile correctamente.
2. Las dependencias de Maven estén disponibles.
3. Los requisitos de las funcionalidades estén definidos.
4. Los datos de prueba estén preparados.
5. Las clases bajo prueba estén implementadas o identificadas para desarrollo TDD.
6. El entorno de ejecución permita utilizar JUnit 5 y Mockito.

## 7. Criterios de salida

Se considerará completada la actividad cuando:

1. Se hayan documentado al menos 15 casos de prueba.
2. Se hayan implementado al menos 6 pruebas unitarias.
3. El 100 % de las pruebas unitarias obligatorias se ejecute satisfactoriamente.
4. No existan defectos críticos abiertos en las funcionalidades incluidas.
5. Se hayan documentado 2 ciclos TDD completos.
6. Se haya conservado la captura de ejecución de Maven.
7. Los cambios estén disponibles en GitHub mediante un Pull Request.

### Metas de cobertura

- Cobertura objetivo de líneas: al menos 80 % en los servicios evaluados.
- Cobertura objetivo de ramas críticas: al menos 80 %.
- Tasa objetivo de aprobación de pruebas obligatorias: 100 %.

Estos porcentajes son metas de planificación y deberán verificarse mediante resultados reales. No representan cobertura alcanzada.

## 8. Recursos y herramientas

| Recurso | Aplicación |
|---|---|
| Java 21 | Desarrollo de funcionalidades |
| Maven | Compilación y ejecución de pruebas |
| JUnit 5 | Pruebas unitarias |
| Mockito | Simulación de dependencias |
| Visual Studio Code | Edición del código |
| Git y GitHub | Control de versiones |
| JaCoCo | Medición de cobertura, si se configura |
| Postman | Pruebas de API disponibles |
| H2 | Base de datos de pruebas, si se incorpora |

### Recursos humanos

El estudiante o equipo asumirá las actividades de diseño, implementación, ejecución, documentación y revisión de las pruebas.

## 9. Responsabilidades

| Actividad | Responsable |
|---|---|
| Elaboración del plan | Estudiante / QA |
| Diseño de casos de prueba | Estudiante / QA |
| Implementación de pruebas unitarias | Estudiante / desarrollador |
| Corrección de defectos | Estudiante / desarrollador |
| Ejecución y registro de resultados | Estudiante / QA |
| Revisión de evidencias | Estudiante / equipo |
| Evaluación académica | Docente |

## 10. Cronograma y estimación de esfuerzo

| Fase | Actividad | Tiempo estimado |
|---|---|---|
| 1 | Elaboración del plan IEEE 829 | 2 horas |
| 2 | Diseño de 15 casos de prueba | 2 horas |
| 3 | Implementación de pruebas unitarias | 3 horas |
| 4 | Aplicación de ciclos TDD | 2 horas |
| 5 | Evidencias, GitHub y revisión | 1 hora |
| **Total** | | **10 horas** |

La estimación corresponde al tiempo sugerido para la actividad y podrá ajustarse si es necesario implementar servicios adicionales.

## 11. Riesgos y contingencias

Se utiliza una escala de probabilidad e impacto de 1 a 3.

Prioridad = Probabilidad × Impacto.

| Riesgo | Prob. | Impacto | Prioridad | Mitigación |
|---|---:|---:|---:|---|
| Servicios de préstamos no implementados | 3 | 3 | 9 | Implementar funcionalidad mínima y verificarla |
| Dependencias Maven incompatibles | 2 | 3 | 6 | Revisar pom.xml y versiones |
| Material inexistente tratado incorrectamente | 2 | 3 | 6 | Probar respuestas vacías y errores |
| Préstamo de material no disponible | 2 | 3 | 6 | Crear pruebas negativas y validaciones |
| Cálculo incorrecto de multas | 2 | 2 | 4 | Verificar días y valores límite |
| Falta de evidencia TDD | 2 | 3 | 6 | Registrar commits separados por fase |
| Pérdida de archivos del proyecto | 1 | 3 | 3 | Conservar respaldo y repositorio remoto |

Los riesgos de prioridad 6 a 9 recibirán atención preferente.

## 12. Casos y requisitos trazables

| Requisito | Funcionalidad | Evidencia prevista |
|---|---|---|
| RF-01 | Consultar materiales | Casos documentados y tests de MaterialService |
| RF-02 | Buscar material por ID | Pruebas de material existente e inexistente |
| RF-03 | Registrar préstamos | Pruebas de PrestamoService |
| RF-04 | Validar disponibilidad | Prueba de préstamo rechazado |
| RF-05 | Calcular multa por retraso | Prueba de cálculo de multa |

RF-04 y RF-05 son identificadores propuestos para ampliar los requisitos de la Unidad 2; deberán confirmarse al revisar el código y los requisitos del proyecto.

## 13. Ejecución y registro de defectos

Las pruebas unitarias se ejecutarán mediante Maven:

```bash
mvn test
```

Para cada ejecución se registrará:

- Fecha y versión del proyecto.
- Número de pruebas ejecutadas.
- Número de pruebas aprobadas y fallidas.
- Defectos encontrados.
- Evidencia de ejecución.
- Acciones correctivas.

Cada defecto deberá documentarse con identificador, descripción, severidad, pasos para reproducirlo y resultado esperado.

## 14. Entregables

1. `docs/pruebas/plan_de_pruebas.md`.
2. `docs/pruebas/casos_de_prueba.md`.
3. `MaterialServiceTest.java`.
4. `PrestamoServiceTest.java`.
5. Evidencia de ejecución de `mvn test`.
6. Historial de commits de dos ciclos TDD.
7. Pull Request hacia la rama `develop`.

## 15. Seguimiento, cierre y control de cambios

El plan será revisado durante el desarrollo de las pruebas y actualizado cuando se identifiquen cambios de alcance, nuevos riesgos o modificaciones en los requisitos.

Toda modificación deberá registrar versión, fecha, descripción y responsable.

### Historial de versiones

| Versión | Fecha | Descripción | Responsable |
|---|---|---|---|
| 1.0 | 17/11/2026 | Creación inicial del plan de pruebas | Estudiante / QA |

El cierre se realizará después de verificar los criterios de salida y consolidar las evidencias.

## 16. Aprobación

- **Elaborado por:** Estudiante / equipo.
- **Revisado por:** Pendiente.
- **Estado de aprobación:** Pendiente de evaluación académica.
