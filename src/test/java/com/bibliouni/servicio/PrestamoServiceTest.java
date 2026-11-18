package com.bibliouni.servicio;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import com.bibliouni.modelo.Material;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class PrestamoServiceTest {

    @Test
    void permitePrestarMaterialDisponible() {
        // Arrange: preparar los datos y el servicio simulado
        MaterialService materialService = mock(MaterialService.class);

        when(materialService.buscarPorId(1L))
                .thenReturn(Optional.of(
                        new Material(1L, "Introducción a Java", true)
                ));

        PrestamoService prestamoService =
                new PrestamoService(materialService);

        // Act: ejecutar la funcionalidad
        boolean resultado = prestamoService.prestar(1L);

        // Assert: verificar el resultado esperado
        assertTrue(resultado);
    }
    @Test
void noPermitePrestarMaterialNoDisponible() {
    // Arrange: preparar un material que no está disponible
    MaterialService materialService = mock(MaterialService.class);

    when(materialService.buscarPorId(2L))
            .thenReturn(Optional.of(
                    new Material(2L, "Ingeniería de Software", false)
            ));

    PrestamoService prestamoService =
            new PrestamoService(materialService);

    // Act: intentar prestar el material
    boolean resultado = prestamoService.prestar(2L);

    // Assert: verificar que el préstamo sea rechazado
    assertFalse(resultado);
}
@Test
void noConsultaCatalogoCuandoIdEsNulo() {
    // Arrange
    MaterialService materialService = mock(MaterialService.class);
    PrestamoService prestamoService = new PrestamoService(materialService);

    // Act
    boolean resultado = prestamoService.prestar(null);

    // Assert
    assertFalse(resultado);
    verify(materialService, never()).buscarPorId(null);
}
}