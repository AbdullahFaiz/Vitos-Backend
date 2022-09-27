package com.synergen.vitos.repository;

import com.synergen.vitos.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	public Category findByCategoryId(long categoryId);
	public Category findByCode(String code);
	public List<Category> findByStatus(String status);

}
