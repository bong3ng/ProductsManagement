package ghtk.excel.controller;

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

import ghtk.excel.dto.DTO;
import ghtk.excel.model.entity.CategoryEntity;
import ghtk.excel.services.CategoryService;



@RestController
@RequestMapping("/api/v1.0/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping("")
	public ResponseEntity get() {
		DTO<CategoryEntity> listCate = categoryService.findAll();
		return ResponseEntity.ok(listCate);
	}
	
	@PostMapping("")
	public ResponseEntity create(@RequestBody CategoryEntity categoryEntity) {
		categoryService.create(categoryEntity);
		return ResponseEntity.ok().body(categoryEntity);
		
	}
	@PutMapping("")
	public ResponseEntity update(@RequestBody CategoryEntity categoryEntity) {
		categoryService.update(categoryEntity);
		return ResponseEntity.ok("ok");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		categoryService.delete(id);
		return ResponseEntity.ok("Da xoa thanh cong " + id);
	}
	
}
