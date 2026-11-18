package com.bibliouni.servicio;
import static org.junit.jupiter.api.Assertions.*;
import com.bibliouni.BiblioUniApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest(classes = BiblioUniApplication.class)
class MaterialServiceTest {
 @Autowired MaterialService servicio;
 @Test void contextLoads() { assertNotNull(servicio); }
 @Test void materialExistente() { assertTrue(servicio.buscarPorId(1L).isPresent()); }
 @Test void materialInexistente() { assertTrue(servicio.buscarPorId(999L).isEmpty()); }
@Test
void catalogoContieneDosMateriales() {
    assertEquals(2, servicio.listar().size());
}

@Test
void materialConIdCeroNoExiste() {
    assertTrue(servicio.buscarPorId(0L).isEmpty());
}
@Test
void debeContarMaterialesDisponibles() {
    assertEquals(1, servicio.contarDisponibles());
}
@Test
void buscarMaterialDisponible() {
    assertTrue(servicio.buscarDisponiblePorId(1L).isPresent());
    assertTrue(servicio.buscarDisponiblePorId(2L).isEmpty());
}
}
