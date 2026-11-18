package com.bibliouni.servicio;

import com.bibliouni.modelo.Material;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PrestamoService {

    private final MaterialService materialService;

    public PrestamoService(MaterialService materialService) {
        this.materialService = materialService;
    }

    public boolean prestar(Long materialId) {
    if (materialId == null) {
        return false;
    }

    Optional<Material> materialEncontrado =
            materialService.buscarPorId(materialId);

    return materialEncontrado
            .map(Material::disponible)
            .orElse(false);
}
}