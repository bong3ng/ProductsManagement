package ghtk.excel.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ghtk.excel.model.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	@Query("SELECT p FROM ProductEntity p WHERE p.price > :price and p.name LIKE :name")
	Page<ProductEntity> findListByQuery(@Param("price") Double price, @Param("name") String name,Pageable pageable);
}
