package com.synergen.vitos.repository;

import com.synergen.vitos.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long>{
	
	public Pizza findByPizzaId(long pizzaId);
	public Pizza findByCode(String code);
	public List<Pizza> findByStatus(String status);

}
