package com.bibliouni.servicio;
import static org.junit.jupiter.api.Assertions.*;
import com.bibliouni.BiblioUniApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.bibliouni.modelo.Material;
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

@Test
void debeCrearMaterialExitosamente() {
    // Arrange: preparar los datos de prueba
    MaterialService servicioPrueba = new MaterialService();
    Material nuevoMaterial = new Material(
        3L,
        "Pruebas de Software",
        true
    );

    // Act: ejecutar la funcionalidad
    Material resultado = servicioPrueba.crearMaterial(nuevoMaterial);

    // Assert: verificar los resultados
    assertNotNull(resultado);
    assertEquals(3L, resultado.id());
    assertEquals("Pruebas de Software", resultado.titulo());
    assertTrue(servicioPrueba.buscarPorId(3L).isPresent());
    assertEquals(3, servicioPrueba.listar().size());
}

}
