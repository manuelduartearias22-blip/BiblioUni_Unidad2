package com.bibliouni.controlador;
import static org.junit.jupiter.api.Assertions.*;
import com.bibliouni.servicio.MaterialService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import java.util.List;
class MaterialControllerTest {
 @Test void controladorPuedeListar() { assertEquals(2, new MaterialController(new MaterialService()).listar().size()); }
 @Test void controladorDevuelve404SiNoExiste() { assertEquals(404, new MaterialController(new MaterialService()).buscar(999L).getStatusCode().value()); }
@Test
void controladorConsultaServicioParaListar() {
    MaterialService servicioSimulado = mock(MaterialService.class);

    when(servicioSimulado.listar()).thenReturn(List.of());

    MaterialController controlador = new MaterialController(servicioSimulado);

    assertTrue(controlador.listar().isEmpty());

    verify(servicioSimulado, times(1)).listar();
}
}
