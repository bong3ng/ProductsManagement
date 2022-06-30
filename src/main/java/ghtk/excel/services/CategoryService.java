package ghtk.excel.services;

import ghtk.excel.dto.DTO;
import ghtk.excel.model.entity.CategoryEntity;

public interface CategoryService {
	public DTO<CategoryEntity> findAll();
	
	public void create(CategoryEntity category);
	
	public void update(CategoryEntity category);
	
	public void delete(Long id);
}
