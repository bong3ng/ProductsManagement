package ghtk.excel.services;

import org.springframework.data.domain.Page;

import ghtk.excel.dto.DTO;
import ghtk.excel.model.entity.ProductEntity;


public interface ProductService {
	
	public DTO<ProductEntity> findAll();
	
	public ProductEntity findById(Long id);
	
	public void create(ProductEntity product);
	
	public void update(ProductEntity product);
	
	public void deleteById(Long id);
	
	public Page<ProductEntity> findByQuery(int page, int pageSize, String name, Double price);
	
}
