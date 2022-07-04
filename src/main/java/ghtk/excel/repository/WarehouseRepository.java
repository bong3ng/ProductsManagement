package ghtk.excel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ghtk.excel.model.entity.WareHouseEntity;
@Repository
public interface WarehouseRepository extends JpaRepository<WareHouseEntity, Long>{
}
