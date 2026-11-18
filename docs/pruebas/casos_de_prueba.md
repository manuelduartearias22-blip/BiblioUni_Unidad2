
# Casos de prueba — BiblioUni
## Unidad 2 — Pruebas de Software

**Identificador:** CP-BU-002  
**Versión:** 1.0  
**Fecha:** 17 de noviembre de 2026  
**Proyecto:** BiblioUni  
**Documento relacionado:** `plan_de_pruebas.md`  
**Estado:** Casos de prueba documentados. Ejecución automatizada parcial: 10 pruebas exitosas, 0 fallidas y 0 errores. Los casos correspondientes a funcionalidades no implementadas permanecen pendientes.

---

## 1. Objetivo

Documentar 15 casos de prueba para verificar el comportamiento del sistema BiblioUni, aplicando técnicas de diseño de pruebas de software, especialmente partición de equivalencia, análisis de valores límite y transición de estados.

El proyecto corresponde a una implementación académica de referencia. Actualmente permite listar y buscar materiales. Las funcionalidades de préstamos, devoluciones y multas se consideran requisitos propuestos y pendientes de implementación.

## 2. Alcance y criterios

Los casos CP-001 a CP-007 corresponden a funcionalidades existentes en el código.

Los casos CP-008 a CP-015 corresponden a funcionalidades futuras y no pueden ejecutarse hasta que se implementen los servicios y las reglas de negocio correspondientes.

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

## 4. Casos de prueba de préstamos (funcionalidad futura)

Los siguientes escenarios son especificaciones propuestas para el desarrollo de `PrestamoService`. Sus reglas deberán confirmarse antes de automatizarlos.

### CP-008 — Registrar préstamo de material disponible

**Requisito:** RF-03 — Gestionar préstamos.  
**Técnica:** PE, operación válida; TE.  
**Prioridad:** Crítica.  
**Precondición:** Material disponible y usuario habilitado.  
**Datos de entrada:** Material ID 1 y usuario válido.  
**Procedimiento:**
1. Solicitar el préstamo del material.
2. Consultar el resultado.
3. Verificar el nuevo estado de disponibilidad.

**Resultado esperado propuesto:** Préstamo registrado y material marcado como no disponible.  
**Estado:** Bloqueado: `PrestamoService` no implementado.

### CP-009 — Rechazar préstamo de material no disponible

**Requisito:** RF-03 — Gestionar préstamos.  
**Técnica:** PE, operación inválida; TE.  
**Prioridad:** Crítica.  
**Precondición:** Material ID 2 no disponible.  
**Datos de entrada:** Material ID 2 y usuario válido.  
**Procedimiento:**
1. Solicitar el préstamo.
2. Verificar que la operación sea rechazada.
3. Comprobar que no se registre un préstamo adicional.

**Resultado esperado propuesto:** Préstamo rechazado y estado del material sin cambios.  
**Estado:** Bloqueado: `PrestamoService` no implementado.

### CP-010 — Rechazar préstamo con identificador inexistente

**Requisito:** RF-03 — Gestionar préstamos.  
**Técnica:** PE, identificador inválido.  
**Prioridad:** Alta.  
**Precondición:** El material ID 999 no existe.  
**Datos de entrada:** Material ID 999 y usuario válido.  
**Procedimiento:**
1. Solicitar el préstamo del material inexistente.
2. Verificar el resultado.

**Resultado esperado propuesto:** Operación rechazada; no se crea un préstamo.  
**Estado:** Bloqueado: `PrestamoService` no implementado.

### CP-011 — Préstamo en el límite máximo permitido

**Requisito:** RF-03 — Gestionar préstamos.  
**Técnica:** AVL, límite superior válido.  
**Prioridad:** Alta.  
**Precondición:** Existe una regla de máximo de préstamos por usuario, pendiente de definir.  
**Datos de entrada:** Usuario con un préstamo menos del máximo permitido.  
**Procedimiento:**
1. Configurar el número de préstamos activos del usuario.
2. Solicitar un préstamo adicional.
3. Verificar el resultado.

**Resultado esperado propuesto:** Se permite alcanzar exactamente el máximo definido.  
**Estado:** Bloqueado: regla de límite y servicio no implementados.

### CP-012 — Préstamo que supera el máximo permitido

**Requisito:** RF-03 — Gestionar préstamos.  
**Técnica:** AVL, primer valor inválido superior.  
**Prioridad:** Alta.  
**Precondición:** El usuario alcanzó el máximo de préstamos activos.  
**Datos de entrada:** Solicitud de un préstamo adicional.  
**Procedimiento:**
1. Configurar un usuario con el máximo permitido.
2. Solicitar otro préstamo.
3. Verificar el rechazo.

**Resultado esperado propuesto:** El préstamo adicional es rechazado sin alterar los préstamos existentes.  
**Estado:** Bloqueado: regla de límite y servicio no implementados.

---

## 5. Casos de prueba de devoluciones y multas (funcionalidad futura)

Los casos siguientes dependen de una regla de vencimiento y de cálculo de multas que aún debe definirse.

### CP-013 — Devolución antes del vencimiento

**Requisito:** RF-05 — Gestionar devoluciones y multas (propuesto).  
**Técnica:** AVL, fecha anterior al vencimiento; TE.  
**Prioridad:** Alta.  
**Precondición:** Existe un préstamo activo con fecha de vencimiento definida.  
**Datos de entrada:** Fecha de devolución un día antes del vencimiento.  
**Procedimiento:**
1. Registrar la devolución.
2. Consultar la multa calculada.
3. Verificar el estado del material.

**Resultado esperado propuesto:** Multa igual a cero y material disponible.  
**Estado:** Bloqueado: devolución y cálculo de multas no implementados.

### CP-014 — Devolución en la fecha exacta de vencimiento

**Requisito:** RF-05 — Gestionar devoluciones y multas (propuesto).  
**Técnica:** AVL, valor límite.  
**Prioridad:** Alta.  
**Precondición:** Existe un préstamo activo con fecha de vencimiento definida.  
**Datos de entrada:** Fecha de devolución igual a la fecha de vencimiento.  
**Procedimiento:**
1. Registrar la devolución en la fecha límite.
2. Consultar la multa.

**Resultado esperado propuesto:** Multa igual a cero.  
**Estado:** Bloqueado: devolución y cálculo de multas no implementados.

### CP-015 — Devolución un día después del vencimiento

**Requisito:** RF-05 — Gestionar devoluciones y multas (propuesto).  
**Técnica:** AVL, primer valor fuera del límite.  
**Prioridad:** Alta.  
**Precondición:** Existe un préstamo activo con fecha de vencimiento definida.  
**Datos de entrada:** Fecha de devolución un día después del vencimiento.  
**Procedimiento:**
1. Registrar la devolución tardía.
2. Calcular los días de retraso.
3. Consultar la multa.

**Resultado esperado propuesto:** Se registra un día de retraso y se calcula la multa según la tarifa que se defina.  
**Estado:** Bloqueado: tarifa y servicio de multas no implementados.

---

## 6. Matriz de trazabilidad

| Requisito | Casos de prueba | Situación |
|---|---|---|
| RF-01 — Consultar catálogo | CP-001 | Implementado |
| RF-02 — Buscar material | CP-002, CP-003, CP-004, CP-005 | Implementado |
| RF-04 — Consultar disponibilidad | CP-006, CP-007 | Atributo implementado; requisito formal propuesto |
| RF-03 — Gestionar préstamos | CP-008 a CP-012 | Pendiente |
| RF-05 — Devoluciones y multas | CP-013 a CP-015 | Pendiente |

## 7. Resumen de los casos

| Clasificación | Cantidad |
|---|---:|
| Casos sobre funcionalidades implementadas | 7 |
| Casos sobre funcionalidades futuras | 8 |
| **Total de casos diseñados** | **15** |

**Nota:** Se documentaron 15 casos de prueba. Se ejecutaron 10 pruebas automatizadas con JUnit 5 y Mockito, obteniendo 0 fallos, 0 errores y BUILD SUCCESS. Este resultado corresponde a la suite automatizada y no significa que los 15 casos documentados hayan sido ejecutados. Los casos asociados a funcionalidades aún no implementadas permanecen pendientes.

## 8. Registro de ejecución

| Registro | Fecha | Resultado obtenido | Estado | Evidencia |
|---|---|---|---|---|
| Suite automatizada JUnit 5 y Mockito | 17/11/2026 | 10 pruebas ejecutadas, 0 fallos, 0 errores, 0 omitidas | Aprobada | `evidencia_tdd_ciclo2_refactor.png` |
| CP-001 a CP-007 | Pendiente de registro individual | Sin correspondencia individual verificada con la suite automatizada | Por verificar | Revisar pruebas implementadas |
| CP-008 a CP-015 | No aplica todavía | Funcionalidades pendientes de implementación | Pendiente | Sin evidencia de ejecución |

## 9. Observaciones finales

Los casos fueron diseñados a partir del código de referencia existente y de los escenarios propuestos para la Unidad 2.

Se realizaron pruebas automatizadas utilizando JUnit 5 y Mockito, obteniendo un resultado satisfactorio de 10 pruebas ejecutadas, sin fallos ni errores. Asimismo, se documentaron dos ciclos de desarrollo guiado por pruebas (TDD), incluyendo las fases RED, GREEN y REFACTOR, con sus respectivas evidencias. Los casos correspondientes a funcionalidades aún no implementadas permanecen pendientes de ejecución.

Las funcionalidades futuras requieren implementación y validación de sus reglas de negocio antes de considerar sus casos como ejecutables.
