package ghtk.excel.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ghtk.excel.dto.DTO;
import ghtk.excel.model.entity.CategoryEntity;
import ghtk.excel.repository.CategoryRepository;
import ghtk.excel.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepo;
	
	@Override
	public DTO<CategoryEntity> findAll(){
		DTO<CategoryEntity> listCate = new DTO<CategoryEntity>();
		listCate.setData(categoryRepo.findAll());
		listCate.setMessage("Tra ve danh sach category cua san pham");
		return listCate;
	}
	
	@Override
	public void create(CategoryEntity category){
		categoryRepo.save(category);
		
	}
	
	@Override
	public void update(CategoryEntity category){
		Optional<CategoryEntity> categoryUpdate = categoryRepo.findById(category.getId());
		categoryRepo.save(categoryUpdate.get());
	}
	
	@Override
	public void delete(Long id){
		Optional<CategoryEntity> categoryUpdate = categoryRepo.findById(id);
		categoryRepo.deleteById(id);
	}
}
