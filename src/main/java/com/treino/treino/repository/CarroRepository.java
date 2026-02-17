package com.treino.treino.repository;

import com.treino.treino.entity.CarroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<CarroModel, Long> {
}
