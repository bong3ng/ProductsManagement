package ghtk.excel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ghtk.excel.dto.DTO;
import ghtk.excel.model.entity.ProductEntity;
import ghtk.excel.services.ProductService;

@RestController
@RequestMapping("api/v1.0/product")
public class ProductController {
	

	@Autowired
	private ProductService productService;
	
	
	@GetMapping("")
	public ResponseEntity get() {
		DTO<ProductEntity> products = productService.findAll();
		return ResponseEntity.ok(products);
	}
	

	@PostMapping("")
	public ResponseEntity create(@RequestBody @Valid ProductEntity productEntity) {
		productService.create(productEntity);
		return ResponseEntity.ok("Ok");
		
	}
	
	@PutMapping("")
	public ResponseEntity update(@RequestBody @Valid ProductEntity productEntity) {
		productService.update(productEntity);
	
		return ResponseEntity.ok("ok");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		productService.deleteById(id);
		return ResponseEntity.ok("Da xoa " + id);
	}
	
	@GetMapping("/search")

	
	public ResponseEntity search(@RequestParam(value = "page") int page, @RequestParam(value = "page_size")int pageSize,@RequestParam(value = "name") String name, @RequestParam(value = "price") Double price) {
		
		return ResponseEntity.ok(productService.findByQuery(page, pageSize,name,price));
	}
	
}
