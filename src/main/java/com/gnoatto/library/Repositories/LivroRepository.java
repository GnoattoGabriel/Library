package com.gnoatto.library.Repositories;

import com.gnoatto.library.Models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {

}
