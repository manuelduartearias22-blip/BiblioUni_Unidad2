
# Casos de prueba — BiblioUni
## Unidad 2 — Pruebas de Software

**Identificador:** CP-BU-002  
**Versión:** 1.0  
**Fecha:** 17 de noviembre de 2026  
**Proyecto:** BiblioUni  
**Documento relacionado:** `plan_de_pruebas.md`  
**Estado:** Se documentaron 15 casos de prueba formales. La suite automatizada cuenta con 15 pruebas exitosas, 0 fallos y 0 errores, verificadas mediante Maven, JUnit 5 y Mockito. Existe una implementación básica de `PrestamoService` para validar solicitudes de préstamo según la disponibilidad del material. Las funcionalidades de gestión completa de préstamos, límites por usuario, devoluciones y multas permanecen pendientes de implementación. Los 15 casos formales no deben considerarse ejecutados individualmente sin verificar su correspondencia con las pruebas automatizadas.

---

## 1. Objetivo

Documentar 15 casos de prueba para verificar el comportamiento del sistema BiblioUni, aplicando técnicas de diseño de pruebas de software, especialmente partición de equivalencia, análisis de valores límite y transición de estados.

El proyecto BiblioUni corresponde a una implementación académica de referencia desarrollada para la Unidad 2 de Pruebas de Software. Actualmente permite listar y buscar materiales bibliográficos, consultar su disponibilidad y validar solicitudes básicas de préstamo mediante `PrestamoService`. La gestión completa de préstamos, los límites de préstamos por usuario, las devoluciones y el cálculo de multas se consideran funcionalidades pendientes de implementación.

Los casos de prueba documentados incluyen tanto funcionalidades existentes como requisitos propuestos, diferenciando su diseño formal de su ejecución automatizada.

## 2. Alcance y criterios

Los casos CP-001 a CP-007 corresponden a funcionalidades existentes relacionadas con la consulta, búsqueda y disponibilidad de materiales bibliográficos.

Los casos CP-008 a CP-010 corresponden a la validación básica de solicitudes de préstamo. Actualmente, `PrestamoService` permite comprobar si un material está disponible antes de autorizar una solicitud. Sin embargo, todavía no implementa el registro persistente de préstamos, la asociación con usuarios ni la actualización del estado del material después de prestar.

Los casos CP-011 y CP-012 evalúan una regla propuesta de máximo de 3 préstamos activos por usuario, que todavía no está implementada.

Los casos CP-013 a CP-015 corresponden a funcionalidades futuras de devoluciones y cálculo de multas, pendientes de implementación.

Los resultados esperados de los casos formales representan especificaciones de prueba y no constituyen evidencia de ejecución. Su estado debe verificarse individualmente antes de declararlos aprobados.

**Técnicas utilizadas:**
- PE: partición de equivalencia.
- AVL: análisis de valores límite.
- TE: transición de estados.
- RF: requisito funcional.

**Estados de ejecución:**
- Pendiente: caso diseñado, todavía no ejecutado.
- Aprobado: resultado obtenido coincide con el esperado.
- Fallido: resultado obtenido difiere del esperado.
- Bloqueado: no puede ejecutarse por una dependencia o funcionalidad ausente.

Los resultados esperados no representan resultados de ejecución.

---

## 3. Casos de prueba de materiales

### CP-001 — Consultar catálogo completo

**Requisito:** RF-01 — Consultar catálogo.  
**Técnica:** PE, clase válida.  
**Prioridad:** Alta.  
**Precondición:** El catálogo contiene dos materiales.  
**Datos de entrada:** Ninguno.  
**Procedimiento:**
1. Ejecutar `MaterialService.listar()`.
2. Consultar el número de elementos devueltos.

**Resultado esperado:** La lista contiene exactamente dos materiales.  
**Estado:** Pendiente de ejecución.

### CP-002 — Buscar material existente con ID 1

**Requisito:** RF-02 — Buscar material por ID.  
**Técnica:** PE, identificador válido.  
**Prioridad:** Alta.  
**Precondición:** Existe el material con ID 1.  
**Datos de entrada:** `1L`.  
**Procedimiento:**
1. Ejecutar `MaterialService.buscarPorId(1L)`.
2. Verificar la presencia del resultado.
3. Consultar el título.

**Resultado esperado:** Se encuentra el material "Introducción a Java".  
**Estado:** Pendiente de ejecución.

### CP-003 — Buscar material existente no disponible

**Requisito:** RF-02 — Buscar material por ID.  
**Técnica:** PE, identificador válido.  
**Prioridad:** Alta.  
**Precondición:** Existe el material con ID 2.  
**Datos de entrada:** `2L`.  
**Procedimiento:**
1. Ejecutar `MaterialService.buscarPorId(2L)`.
2. Consultar el material devuelto.
3. Verificar su disponibilidad.

**Resultado esperado:** Se encuentra "Ingeniería de Software" con `disponible = false`.  
**Estado:** Pendiente de ejecución.

### CP-004 — Buscar material inexistente

**Requisito:** RF-02 — Buscar material por ID.  
**Técnica:** PE, identificador inexistente.  
**Prioridad:** Alta.  
**Precondición:** El catálogo no contiene el ID 999.  
**Datos de entrada:** `999L`.  
**Procedimiento:**
1. Ejecutar `MaterialService.buscarPorId(999L)`.
2. Verificar el resultado.

**Resultado esperado:** Se devuelve `Optional.empty()`.  
**Estado:** Pendiente de ejecución.

### CP-005 — Buscar material con identificador nulo

**Requisito:** RF-02 — Buscar material por ID.  
**Técnica:** PE, entrada nula.  
**Prioridad:** Media.  
**Precondición:** Servicio inicializado.  
**Datos de entrada:** `null`.  
**Procedimiento:**
1. Ejecutar `MaterialService.buscarPorId(null)`.
2. Verificar el resultado.

**Resultado esperado:** Se devuelve `Optional.empty()` sin lanzar una excepción.  
**Estado:** Pendiente de ejecución.

### CP-006 — Consultar material disponible

**Requisito:** RF-04 — Consultar disponibilidad (propuesto).  
**Técnica:** PE, estado disponible.  
**Prioridad:** Alta.  
**Precondición:** El material con ID 1 está registrado.  
**Datos de entrada:** `1L`.  
**Procedimiento:**
1. Buscar el material con ID 1.
2. Consultar el atributo `disponible()`.

**Resultado esperado:** El valor de disponibilidad es `true`.  
**Estado:** Pendiente de ejecución.

### CP-007 — Consultar material no disponible

**Requisito:** RF-04 — Consultar disponibilidad (propuesto).  
**Técnica:** PE, estado no disponible.  
**Prioridad:** Alta.  
**Precondición:** El material con ID 2 está registrado.  
**Datos de entrada:** `2L`.  
**Procedimiento:**
1. Buscar el material con ID 2.
2. Consultar el atributo `disponible()`.

**Resultado esperado:** El valor de disponibilidad es `false`.  
**Estado:** Pendiente de ejecución.

---

## 4. Casos de prueba de préstamos

Los casos CP-008 a CP-010 evalúan la validación básica de solicitudes de préstamo mediante PrestamoService, funcionalidad actualmente implementada. Los casos CP-011 y CP-012 corresponden a una regla propuesta de máximo de 3 préstamos activos por usuario, pendiente de implementación.

### CP-008 — Autorizar solicitud de préstamo de material disponible

**Requisito:** RF-03 — Validar solicitudes de préstamo.  
**Técnica:** PE, partición válida de material disponible.  
**Prioridad:** Crítica.  
**Precondición:** El catálogo contiene un material con ID 1, título "Introducción a Java" y disponibilidad `true`. El servicio `PrestamoService` está inicializado.  
**Datos de entrada:** Identificador del material: `1L`. Disponibilidad del material: `true`.  
**Procedimiento:**
1. Configurar el catálogo con el material ID 1 disponible.
2. Ejecutar `PrestamoService.prestar(1L)`.
3. Consultar el resultado booleano de la operación.
4. Verificar que la solicitud sea autorizada.

**Resultado esperado:** El método `prestar(1L)` devuelve `true`, indicando que el material está disponible y la solicitud puede autorizarse. Este resultado no implica que el préstamo quede registrado ni que cambie el estado del material.  
**Estado:** Funcionalidad implementada y cubierta por una prueba automatizada en `PrestamoServiceTest`. Pendiente de registrar la correspondencia y ejecución individual del caso formal.

### CP-009 — Rechazar préstamo de material no disponible

**Requisito:** RF-03 — Validar solicitudes de préstamo.  
**Técnica:** PE, partición inválida de material no disponible.  
**Prioridad:** Crítica.  
**Precondición:** El catálogo contiene un material con ID 2, título "Ingeniería de Software" y disponibilidad `false`. El servicio `PrestamoService` está inicializado.  
**Datos de entrada:** Identificador del material: `2L`. Disponibilidad del material: `false`.  
**Procedimiento:**
1. Configurar el catálogo con el material ID 2 no disponible.
2. Ejecutar `PrestamoService.prestar(2L)`.
3. Consultar el resultado booleano de la operación.
4. Verificar que la solicitud sea rechazada.

**Resultado esperado:** El método `prestar(2L)` devuelve `false`, indicando que el material no está disponible y la solicitud debe rechazarse. No se afirma que exista un registro de préstamos ni una actualización del estado del material, porque esas funcionalidades todavía no están implementadas.  
**Estado:** Funcionalidad implementada y cubierta por una prueba automatizada en `PrestamoServiceTest`. Pendiente de registrar la correspondencia y ejecución individual del caso formal.

### CP-010 — Rechazar préstamo con identificador inexistente

**Requisito:** RF-03 — Validar solicitudes de préstamo.  
**Técnica:** PE, partición inválida de identificador inexistente.  
**Prioridad:** Alta.  
**Precondición:** El catálogo contiene materiales con ID 1 e ID 2, pero no existe ningún material con ID 999. El servicio `PrestamoService` está inicializado.  
**Datos de entrada:** Identificador del material: `999L`. Resultado de la búsqueda: `Optional.empty()`.  
**Procedimiento:**
1. Configurar el catálogo sin ningún material con ID 999.
2. Ejecutar `PrestamoService.prestar(999L)`.
3. Consultar el resultado booleano de la operación.
4. Verificar que la solicitud sea rechazada.

**Resultado esperado:** El método `prestar(999L)` devuelve `false`, porque el material solicitado no existe en el catálogo. No se afirma que se modifique un registro de préstamos, ya que esa funcionalidad todavía no está implementada.  
**Estado:** Funcionalidad contemplada en la validación básica de `PrestamoService`. Pendiente de verificar mediante una prueba automatizada específica para el identificador inexistente.

### CP-011 — Préstamo en el límite máximo permitido

**Requisito:** RF-03 — Gestionar préstamos.  
**Técnica:** AVL, límite superior válido.  
**Prioridad:** Alta.  
**Precondición:** Se propone un máximo de 3 préstamos activos por usuario. El usuario tiene 2 préstamos activos y existe un material disponible para prestar.  
**Datos de entrada:** Usuario con 2 préstamos activos; solicitud de 1 préstamo adicional; máximo propuesto de 3 préstamos.  
**Procedimiento:**
1. Configurar un usuario con 2 préstamos activos.
2. Solicitar el préstamo de un material disponible.
3. Verificar si la solicitud es aceptada.
4. Comprobar que el usuario alcance exactamente 3 préstamos activos.

**Resultado esperado propuesto:** El préstamo es aceptado porque el usuario alcanza el máximo permitido de 3 préstamos activos, sin superarlo.  
**Estado:** Bloqueado: la regla de máximo de préstamos por usuario todavía no está implementada.

### CP-012 — Préstamo que supera el máximo permitido

**Requisito:** RF-03 — Gestionar préstamos.  
**Técnica:** AVL, primer valor inválido superior.  
**Prioridad:** Alta.  
**Precondición:** Se propone un máximo de 3 préstamos activos por usuario. El usuario ya tiene 3 préstamos activos y existe otro material disponible para prestar.  
**Datos de entrada:** Usuario con 3 préstamos activos; solicitud de 1 préstamo adicional; resultado solicitado de 4 préstamos activos; máximo propuesto de 3 préstamos.  
**Procedimiento:**
1. Configurar un usuario con 3 préstamos activos.
2. Solicitar el préstamo de un cuarto material disponible.
3. Verificar que la solicitud sea rechazada.
4. Comprobar que el usuario conserve sus 3 préstamos activos originales.

**Resultado esperado propuesto:** El cuarto préstamo es rechazado porque supera el máximo propuesto de 3 préstamos activos. Los préstamos existentes permanecen sin modificaciones.  
**Estado:** Bloqueado: la regla de máximo de préstamos por usuario todavía no está implementada.

---

## 5. Casos de prueba de devoluciones y multas (funcionalidad futura)

Los casos siguientes dependen de una regla de vencimiento y de cálculo de multas que aún debe definirse.

### CP-013 — Devolución antes del vencimiento

**Requisito:** RF-05 — Gestionar devoluciones y multas (propuesto).  
**Técnica:** AVL, fecha anterior al vencimiento; TE, transición de estado.  
**Prioridad:** Alta.  
**Precondición:** Existe un préstamo activo con fecha de vencimiento del 20 de noviembre de 2026. El material se encuentra registrado como no disponible.  
**Datos de entrada:** Fecha de vencimiento: 20/11/2026. Fecha de devolución: 19/11/2026 (un día antes).  
**Procedimiento:**
1. Configurar un préstamo activo con vencimiento el 20/11/2026.
2. Registrar la devolución el 19/11/2026.
3. Consultar los días de retraso y la multa calculada.
4. Verificar el estado de disponibilidad del material.

**Resultado esperado propuesto:** La devolución se registra correctamente, los días de retraso son 0, la multa es 0 y el material cambia de no disponible a disponible.  
**Estado:** Bloqueado: la funcionalidad de devoluciones y cálculo de multas todavía no está implementada.

### CP-014 — Devolución en la fecha exacta de vencimiento

**Requisito:** RF-05 — Gestionar devoluciones y multas (propuesto).  
**Técnica:** AVL, valor límite exacto; TE, transición de estado.  
**Prioridad:** Alta.  
**Precondición:** Existe un préstamo activo con fecha de vencimiento del 20 de noviembre de 2026. El material se encuentra registrado como no disponible.  
**Datos de entrada:** Fecha de vencimiento: 20/11/2026. Fecha de devolución: 20/11/2026 (fecha límite exacta).  
**Procedimiento:**
1. Configurar un préstamo activo con vencimiento el 20/11/2026.
2. Registrar la devolución el 20/11/2026.
3. Consultar los días de retraso y la multa calculada.
4. Verificar el estado de disponibilidad del material.

**Resultado esperado propuesto:** La devolución se registra correctamente, los días de retraso son 0, la multa es 0 y el material cambia de no disponible a disponible.  
**Estado:** Bloqueado: la funcionalidad de devoluciones y cálculo de multas todavía no está implementada.

### CP-015 — Devolución un día después del vencimiento

**Requisito:** RF-05 — Gestionar devoluciones y multas (propuesto).  
**Técnica:** AVL, primer valor inválido posterior al límite; TE, transición de estado.  
**Prioridad:** Alta.  
**Precondición:** Existe un préstamo activo con fecha de vencimiento del 20 de noviembre de 2026. El material se encuentra registrado como no disponible. La tarifa de multa por día de retraso está pendiente de definición.  
**Datos de entrada:** Fecha de vencimiento: 20/11/2026. Fecha de devolución: 21/11/2026 (un día después). Días de retraso esperados: 1.  
**Procedimiento:**
1. Configurar un préstamo activo con vencimiento el 20/11/2026.
2. Registrar la devolución el 21/11/2026.
3. Calcular los días de retraso.
4. Consultar la multa correspondiente a un día de retraso.
5. Verificar el estado de disponibilidad del material.

**Resultado esperado propuesto:** La devolución se registra correctamente, se identifica 1 día de retraso y se calcula la multa correspondiente a un día según la tarifa que se establezca. El material cambia de no disponible a disponible.  
**Estado:** Bloqueado: la funcionalidad de devoluciones y cálculo de multas, así como la tarifa aplicable, todavía no están implementadas.

---

## 6. Matriz de trazabilidad

| Requisito | Casos de prueba | Situación |
|---|---|---|
| RF-01 — Consultar catálogo | CP-001 | Implementado |
| RF-02 — Buscar material | CP-002, CP-003, CP-004, CP-005 | Implementado |
| RF-04 — Consultar disponibilidad | CP-006, CP-007 | Implementado |
| RF-03 — Validar solicitudes de préstamo | CP-008, CP-009, CP-010 | Validación básica implementada; CP-010 pendiente de prueba automatizada específica |
| RF-03 — Límite de préstamos por usuario | CP-011, CP-012 | Regla propuesta de máximo 3 préstamos; pendiente de implementación |
| RF-05 — Devoluciones y multas | CP-013, CP-014, CP-015 | Pendiente de implementación |

## 7. Resumen de los casos

| Clasificación | Cantidad |
|---|---:|
| Casos sobre funcionalidades implementadas (CP-001 a CP-010) | 10 |
| Casos sobre funcionalidades pendientes de implementación (CP-011 a CP-015) | 5 |
| **Total de casos diseñados** | **15** |

**Nota:** Se documentaron 15 casos de prueba formales, de los cuales 10 corresponden a comportamientos implementados o contemplados en los servicios actuales y 5 a funcionalidades pendientes de implementación.

La suite automatizada cuenta con 15 pruebas ejecutadas mediante JUnit 5, Mockito y Maven, con 0 fallos, 0 errores, 0 pruebas omitidas y resultado `BUILD SUCCESS`, según la última evidencia disponible.

Las 15 pruebas automatizadas no equivalen a la ejecución individual de los 15 casos formales. La correspondencia entre cada caso documentado y su prueba automatizada debe verificarse antes de declarar su ejecución como aprobada.

Los casos CP-011 a CP-015 permanecen bloqueados porque las reglas de límite de préstamos por usuario, devoluciones y multas todavía no están implementadas.

## 8. Registro de ejecución

| Registro | Fecha | Resultado obtenido | Estado | Evidencia |
|---|---|---|---|---|
| Suite automatizada JUnit 5 y Mockito | 18/11/2026 | 15 pruebas ejecutadas, 0 fallos, 0 errores y 0 omitidas. `BUILD SUCCESS`. | Aprobada | `evidencia_mvn_test_15_pruebas.png` |
| CP-001 a CP-007 | Pendiente de registro individual | Funcionalidades implementadas; correspondencia individual con las pruebas automatizadas pendiente de verificar. | Por verificar | `MaterialServiceTest.java` y `MaterialControllerTest.java` |
| CP-008 | Pendiente de registro individual | Existe la prueba automatizada `permitePrestarMaterialDisponible()`, relacionada con la autorización de un préstamo de material disponible. | Por verificar | `PrestamoServiceTest.java` |
| CP-009 | Pendiente de registro individual | Existe la prueba automatizada `noPermitePrestarMaterialNoDisponible()`, relacionada con el rechazo de préstamos de materiales no disponibles. | Por verificar | `PrestamoServiceTest.java` |
| CP-010 | Pendiente de ejecución específica | No se ha confirmado una prueba automatizada para el identificador inexistente `999L`. | Pendiente | Sin evidencia específica |
| CP-011 a CP-012 | No aplica todavía | Regla propuesta de máximo de 3 préstamos activos por usuario, pendiente de implementación. | Bloqueado | Sin evidencia de ejecución |
| CP-013 a CP-015 | No aplica todavía | Funcionalidades de devoluciones y cálculo de multas pendientes de implementación. | Bloqueado | Sin evidencia de ejecución |

**Observación:** El resultado satisfactorio de la suite automatizada corresponde a 15 pruebas JUnit y no significa que los 15 casos formales hayan sido ejecutados individualmente. La correspondencia entre casos y pruebas debe verificarse antes de registrar cada caso como aprobado.

## 9. Observaciones finales

Los 15 casos de prueba formales fueron diseñados a partir de las funcionalidades existentes en el proyecto BiblioUni y de los requisitos propuestos para la Unidad 2 de Pruebas de Software. Se aplicaron las técnicas de partición de equivalencia, análisis de valores límite y transición de estados, incluyendo escenarios válidos, entradas inválidas y operaciones no permitidas.

Se ejecutó una suite automatizada mediante JUnit 5, Mockito y Maven, obteniendo un resultado satisfactorio de 15 pruebas ejecutadas, 0 fallos, 0 errores y 0 pruebas omitidas, con resultado `BUILD SUCCESS`. La evidencia actualizada se encuentra en el archivo `evidencia_mvn_test_15_pruebas.png`, correspondiente a la ejecución del 18 de noviembre de 2026.

Asimismo, se documentaron dos ciclos de desarrollo guiado por pruebas (TDD), incluyendo las fases RED, GREEN y REFACTOR, con sus respectivas evidencias y registros de ejecución.

El sistema cuenta actualmente con funcionalidades de consulta, búsqueda y validación de disponibilidad de materiales, así como con una implementación básica de `PrestamoService` para autorizar o rechazar solicitudes de préstamo. La gestión completa de préstamos, el límite de préstamos por usuario, las devoluciones y el cálculo de multas permanecen pendientes de implementación.

Los 15 casos formales documentados no deben confundirse con las 15 pruebas automatizadas ejecutadas. La correspondencia y ejecución individual de cada caso deberán verificarse antes de registrarlo como aprobado. Los casos asociados a funcionalidades todavía no implementadas permanecen bloqueados hasta que se desarrollen y validen sus respectivas reglas de negocio.
