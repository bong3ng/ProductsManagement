package ghtk.excel.services;

import ghtk.excel.dto.DTO;
import ghtk.excel.model.entity.WareHouseEntity;

public interface WarehouseService {
	public DTO<WareHouseEntity> findAll();
	public void create(WareHouseEntity warehouse, Long provinceId,Long districtId);
	
//	public void create(WareHouseEntity warehouse);
	
//	public void save(WareHouseEntity warehouse);
	
	public void deleteById(Long id);
}
