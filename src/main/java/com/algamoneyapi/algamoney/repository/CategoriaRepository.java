package com.algamoneyapi.algamoney.repository;

import com.algamoneyapi.algamoney.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
