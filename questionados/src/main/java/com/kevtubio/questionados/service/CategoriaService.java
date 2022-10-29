package com.kevtubio.questionados.service;

import com.kevtubio.questionados.dto.request.CategoriaRequestDTO;
import com.kevtubio.questionados.entity.Categoria;
import com.kevtubio.questionados.exceptions.custom.ResourceNotFoundException;
import com.kevtubio.questionados.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria getCategoria(Integer id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categoria", "id", id));
    }

    public void deleteCategoria(Integer id) {
        Categoria categoria = categoriaRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria", "id", id));
        categoriaRepository.delete(categoria);
    }

    public void createCategoria(CategoriaRequestDTO categoriaRequestDTO) {
        Categoria categoria = Categoria.builder()
                .nombre(categoriaRequestDTO.getNombre())
                .descripcion(categoriaRequestDTO.getDescripcion())
                .build();
        categoriaRepository.save(categoria);
    }

}
