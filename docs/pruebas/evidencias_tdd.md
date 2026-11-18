# Evidencias de Test Driven Development (TDD) — BiblioUni

**Asignatura:** Pruebas de Software  
**Unidad:** 2  
**Proyecto:** BiblioUni — Implementación académica de referencia  
**Fecha:** 17 de noviembre de 2026

## Ciclo TDD 1: Conteo de materiales disponibles

### Objetivo
Implementar y verificar una funcionalidad que permita contar los materiales disponibles en el catálogo de la biblioteca, aplicando la metodología RED–GREEN–REFACTOR.

### Fase RED: Prueba antes de la implementación

Se agregó una prueba unitaria en `MaterialServiceTest.java` para comprobar que el método `contarDisponibles()` devolviera el valor 1, correspondiente al único material disponible del catálogo de referencia.

Al ejecutar Maven, se produjo un error de compilación porque el método todavía no existía.

**Resultado:** RED confirmado mediante error de compilación esperado.

**Evidencia:** `evidencia_tdd_ciclo1_red.png`

### Fase GREEN: Implementación mínima

Se agregó el método `contarDisponibles()` en `MaterialService.java`, utilizando una operación Stream para filtrar y contar los materiales disponibles.

Después de implementar el método, se ejecutaron las pruebas mediante Maven.

**Resultado:** 9 pruebas ejecutadas, 0 fallos, 0 errores y BUILD SUCCESS.

**Evidencia:** `evidencia_tdd_ciclo1_green.png`

### Fase REFACTOR: Mejora del código

Se modificó el método `contarDisponibles()` para reutilizar el método existente `listar()`, conservando el comportamiento esperado.

Se ejecutaron nuevamente todas las pruebas para verificar que la refactorización no introdujera errores.

**Resultado:** 9 pruebas ejecutadas, 0 fallos, 0 errores y BUILD SUCCESS.

**Evidencia:** `evidencia_tdd_ciclo1_refactor.png`

### Conclusión del ciclo 1

Se completó satisfactoriamente el ciclo RED–GREEN–REFACTOR. La prueba permitió identificar inicialmente una funcionalidad ausente, verificar su implementación y confirmar que una refactorización posterior conservó el comportamiento esperado.

## Ciclo TDD 2 — Consulta de disponibilidad por identificador

### Fase RED
Se incorporaron pruebas para verificar la consulta de disponibilidad de un material mediante su identificador.

Inicialmente, las pruebas no pudieron compilar porque el método `buscarDisponiblePorId(long)` todavía no existía en `MaterialService`.

**Resultado:** BUILD FAILURE.

**Evidencia:** `evidencia_tdd_ciclo2_red.png`

### Fase GREEN
Se implementó el método `buscarDisponiblePorId(long)` en `MaterialService`, permitiendo satisfacer las pruebas definidas.

**Resultado:** Las pruebas se ejecutaron correctamente.

**Evidencia:** `evidencia_tdd_ciclo2_green.png`

### Fase REFACTOR
Se verificó el funcionamiento de la implementación después de los ajustes realizados y se ejecutó nuevamente la suite de pruebas mediante Maven.

**Resultados:**
- Pruebas ejecutadas: 10.
- Pruebas fallidas: 0.
- Errores: 0.
- Pruebas omitidas: 0.
- Estado final: BUILD SUCCESS.

**Evidencia:** `evidencia_tdd_ciclo2_refactor.png`

### Conclusión
Se completaron dos ciclos de desarrollo guiado por pruebas (TDD), documentando las fases RED, GREEN y REFACTOR. La ejecución final de Maven confirmó que las 10 pruebas existentes finalizaron satisfactoriamente.