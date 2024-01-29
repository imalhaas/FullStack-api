package com.algamoneyapi.algamoney.Repository;

import com.algamoneyapi.algamoney.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
