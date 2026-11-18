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
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PrestamoServiceTest {

    @Mock
    private MaterialService materialService;

    @InjectMocks
    private PrestamoService prestamoService;

    @Test
    void permitePrestarMaterialDisponible() {
        // Arrange: preparar el material simulado
        when(materialService.buscarPorId(1L))
                .thenReturn(Optional.of(
                        new Material(1L, "Introducción a Java", true)
                ));


        // Act: ejecutar la funcionalidad
        boolean resultado = prestamoService.prestar(1L);

        // Assert: verificar el resultado esperado
        assertTrue(resultado);
    }
    @Test
void noPermitePrestarMaterialNoDisponible() {
    // Arrange: preparar un material no disponible
    when(materialService.buscarPorId(2L))
            .thenReturn(Optional.of(
                    new Material(2L, "Ingeniería de Software", false)
            ));

    // Act: intentar prestar el material
    boolean resultado = prestamoService.prestar(2L);

    // Assert: verificar que el préstamo sea rechazado
    assertFalse(resultado);
}

@Test
void noConsultaCatalogoCuandoIdEsNulo() {
    // Arrange: el identificador del material es nulo
    Long materialId = null;

    // Act: intentar prestar un material sin identificador
    boolean resultado = prestamoService.prestar(materialId);

    // Assert: verificar el rechazo y que no se consulte el catálogo
    assertFalse(resultado);
    verify(materialService, never()).buscarPorId(null);
}


@Test
void debeCalcularMultaPorDevolucionTardia() {
    // Arrange: preparar el servicio y los datos de prueba
    MaterialService materialService = mock(MaterialService.class);
    PrestamoService prestamoService =
            new PrestamoService(materialService);

    int diasRetraso = 3;
    long multaEsperada = 3000L;

    // Act: calcular la multa por devolución tardía
    long multaCalculada =
            prestamoService.calcularMulta(diasRetraso);

    // Assert: comprobar el valor esperado
    assertEquals(multaEsperada, multaCalculada);
}

}