package ghtk.excel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ghtk.excel.model.entity.ProvinceEntity;
@Repository
public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Long>{

}
