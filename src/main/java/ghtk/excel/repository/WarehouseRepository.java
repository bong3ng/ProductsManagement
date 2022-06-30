package ghtk.excel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ghtk.excel.model.entity.WareHouseEntity;

public interface WarehouseRepository extends JpaRepository<WareHouseEntity, Long>{
}
