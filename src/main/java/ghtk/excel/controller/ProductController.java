package ghtk.excel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

import ghtk.excel.model.entity.ProductEntity;
import ghtk.excel.repository.ProductRepository;

@RestController
@RequestMapping("api/v1.0/product")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	
	@GetMapping("")
	public ResponseEntity get() {
		Page<ProductEntity> products = productRepository.findAll(PageRequest.of(0, 10));
		return ResponseEntity.ok(products);
	}
	
	@PostMapping("")
	public ResponseEntity create(@RequestBody ProductEntity productEntity) {
		productRepository.save(productEntity);
		return ResponseEntity.ok(productEntity);
		
	}
	@PutMapping("")
	public ResponseEntity update(@RequestBody ProductEntity productEntity) {
		productRepository.save(productEntity);
		return ResponseEntity.ok(productEntity);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		productRepository.deleteById(id);
		return ResponseEntity.ok("thanh cong");
	}
	
	@GetMapping("/search")
//	public ResponseEntity search(@RequestParam(value = "page") int page, @RequestParam(value = "page_size") int pageSize) {
//		Page<ProductEntity> productEntities = productRepository.search(PageRequest.of(page, pageSize));
	
//	    return ResponseEntity.ok(productEntities);
//	}
	
	public ResponseEntity search(@RequestParam(value = "page") int page, @RequestParam(value = "page_size")int pageSize) {
		
		Page<ProductEntity> pageProduct = productRepository.findListByQuery(PageRequest.of(page, pageSize,Sort.by("price").descending()));
		
		return ResponseEntity.ok(pageProduct);
	}
	
}
