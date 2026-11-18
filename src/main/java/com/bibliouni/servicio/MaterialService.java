
package com.bibliouni.servicio;

import com.bibliouni.modelo.Material;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {

    private final List<Material> catalogo = new ArrayList<>(
        List.of(
            new Material(1L, "Introducción a Java", true),
            new Material(2L, "Ingeniería de Software", false)
        )
    );

    public List<Material> listar() {
        return List.copyOf(catalogo);
    }

    public Optional<Material> buscarPorId(Long id) {
        return catalogo.stream()
                .filter(m -> m.id().equals(id))
                .findFirst();
    }

    public Material crearMaterial(Material material) {
        if (material == null) {
            throw new IllegalArgumentException(
                "El material no puede ser nulo"
            );
        }

        if (buscarPorId(material.id()).isPresent()) {
            throw new IllegalArgumentException(
                "Ya existe un material con ese identificador"
            );
        }

        catalogo.add(material);
        return material;
    }

    public long contarDisponibles() {
        return listar().stream()
                .filter(Material::disponible)
                .count();
    }

    public Optional<Material> buscarDisponiblePorId(Long id) {
        Optional<Material> materialEncontrado = buscarPorId(id);
        return materialEncontrado.filter(Material::disponible);
    }
}
