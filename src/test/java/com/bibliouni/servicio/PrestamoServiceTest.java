package com.bibliouni.servicio;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
}