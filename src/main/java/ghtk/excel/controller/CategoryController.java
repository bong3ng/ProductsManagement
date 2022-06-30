package ghtk.excel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ghtk.excel.model.entity.CategoryEntity;
import ghtk.excel.repository.CategoryRepository;



@RestController
@RequestMapping("/api/v1.0/category")
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@GetMapping("")
	public ResponseEntity get() {
		List<CategoryEntity> categoryEntities = categoryRepository.findAll();
		
		return ResponseEntity.ok(categoryEntities);
	}
	
	@PostMapping("")
	public ResponseEntity create(@RequestBody CategoryEntity categoryEntity) {
		categoryRepository.save(categoryEntity);
		
		return ResponseEntity.ok().body(categoryEntity);
		
	}
	@PutMapping("")
	public ResponseEntity update(@RequestBody CategoryEntity categoryEntity) {
		return ResponseEntity.ok(categoryRepository.save(categoryEntity));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		categoryRepository.deleteById(id);
		return ResponseEntity.ok("Da xoa thanh cong " + id);
	}
	
}
