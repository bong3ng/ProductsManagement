package ghtk.excel.serviceimpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ghtk.excel.dto.DTO;
import ghtk.excel.model.entity.ProductEntity;
import ghtk.excel.repository.ProductRepository;
import ghtk.excel.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	ProductRepository productRepo;
	
//	@Override
//	public List<ProductEntity> findAll(){
//		return productRepo.findAll();
//	}
	
	@Override
	public ProductEntity findById(Long id) {
		Optional<ProductEntity> product = productRepo.findById(id);
		if(product.isPresent()) {
			return product.get();		
		}
		return null;
	}
	@Override
	public DTO<ProductEntity> findAll(){
		DTO<ProductEntity> product = new DTO<ProductEntity>();
		product.setData(productRepo.findAll());
		product.setMessage("Tra ve danh sach tat ca san pham.");
		product.setSuccess(true);
		return product;
	}
	
	@Override
	public void create(ProductEntity newProduct) {
		ProductEntity productCreated = newProduct;
		LocalDate createdTime = LocalDate.now();
		productCreated.setCreatedAt(createdTime);
		productCreated.setStatus(1);
		DateTimeFormatter fm = DateTimeFormatter.BASIC_ISO_DATE;
		
		String createdTimeString = createdTime.format(fm);
		
		String codeProduct = Long.toString(newProduct.getCategoryId()) + "." + newProduct.getSku() + "." + createdTimeString;
		productCreated.setCode(codeProduct);
		
		productRepo.save(productCreated);
	}
	
	@Override
	public void update(ProductEntity product) {
		Optional<ProductEntity> opt = productRepo.findById(product.getId());
		if(opt.isPresent()) {
			LocalDate modifiedTime = LocalDate.now();
			ProductEntity productUpdate = opt.get();
			productUpdate.setModifiedAt(modifiedTime);
			productRepo.save(productUpdate);
		}
	}
	
	@Override
	public void deleteById(Long id) {
		Optional<ProductEntity> opt = productRepo.findById(id);
		if(opt.isPresent()) {
			ProductEntity productDelete = opt.get();
			productDelete.setStatus(0);
			productRepo.save(productDelete);			
		}
	}
	@Override
	public Page<ProductEntity> findByQuery(int page, int pageSize, String name, Double price){
		Page<ProductEntity> pageProduct = productRepo.findListByQuery(price,name,PageRequest.of(page, pageSize,Sort.by("price").descending()));
		
		return pageProduct;
	}
	
	
}
