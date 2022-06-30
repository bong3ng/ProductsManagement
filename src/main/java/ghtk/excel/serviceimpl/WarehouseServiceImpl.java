package ghtk.excel.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ghtk.excel.dto.DTO;
import ghtk.excel.model.entity.DistrictEntity;
import ghtk.excel.model.entity.ProvinceEntity;
import ghtk.excel.model.entity.WareHouseEntity;
import ghtk.excel.repository.DistrictRepository;
import ghtk.excel.repository.ProvinceRepository;
import ghtk.excel.repository.WarehouseRepository;
import ghtk.excel.services.WarehouseService;

@Service
public class WarehouseServiceImpl implements WarehouseService{
	@Autowired
	WarehouseRepository warehouseRepo;
	
	@Autowired
	ProvinceRepository provinceRepo;
	
	@Autowired
	DistrictRepository districtRepo;
	
	
	@Override
	public DTO<WareHouseEntity> findAll(){
		DTO<WareHouseEntity> warehouse = new DTO<WareHouseEntity>();
		warehouse.setData(warehouseRepo.findAll());
		warehouse.setMessage("Tra ve danh sach tat ca kho.");
		warehouse.setSuccess(true);
		return warehouse;
	}
	@Override
	public void create(WareHouseEntity warehouse, Long provinceId,Long districtId) {
		Optional<ProvinceEntity> optP = provinceRepo.findById(provinceId);
		Optional<DistrictEntity> optD = districtRepo.findById(districtId);
		if(optP.isPresent() && optD.isPresent()) {
			
			WareHouseEntity warehouseCreate = warehouse;
			warehouseCreate.setProvince(optP.get());
			warehouseCreate.setDistrict(optD.get());
			warehouseCreate.setStatus(1l);
			warehouseRepo.save(warehouseCreate);
		}
		
		
	}
	@Override
	public void deleteById(Long id) {
		Optional<WareHouseEntity> optW = warehouseRepo.findById(id);
		if(optW.isPresent()) {
			WareHouseEntity warehouseDel = optW.get();
			warehouseDel.setStatus(0l);
			warehouseRepo.save(warehouseDel);
		}
	}
}
