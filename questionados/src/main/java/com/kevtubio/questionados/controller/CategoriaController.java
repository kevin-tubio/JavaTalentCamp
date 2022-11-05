package com.kevtubio.questionados.controller;

import com.kevtubio.questionados.dto.request.CategoriaRequestDTO;
import com.kevtubio.questionados.entity.Categoria;
import com.kevtubio.questionados.service.CategoriaService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping(path = "/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaService.getAllCategorias();
    }

    @PostMapping
    @Secured({"ROLE_MODERATOR", "ROLE_ADMIN"})
    public void createCategoria(@Valid @RequestBody CategoriaRequestDTO categoriaRequestDTO) {
        categoriaService.createCategoria(categoriaRequestDTO);
    }

    @GetMapping(path = "/{id}")
    public Categoria getCategoriaById(@PathVariable Integer id) {
        return categoriaService.getCategoria(id);
    }

    @DeleteMapping(path = "/{id}")
    @Secured({"ROLE_MODERATOR", "ROLE_ADMIN"})
    public void deleteCategoria(@PathVariable Integer id) {
        categoriaService.deleteCategoria(id);
    }

}
