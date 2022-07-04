package ghtk.excel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ghtk.excel.dto.DTO;
import ghtk.excel.model.entity.WareHouseEntity;
import ghtk.excel.services.WarehouseService;

@RestController
@RequestMapping("api/v1.0/warehouse")
public class WarehouseController {
	@Autowired
	private WarehouseService warehouseService;
	
	@GetMapping("")
	public ResponseEntity get() {
		DTO<WareHouseEntity> listWarehouse = warehouseService.findAll();
		return ResponseEntity.ok(listWarehouse);
	}
	
	
	@PostMapping("")
	public ResponseEntity create(@RequestBody WareHouseEntity warehouse, @RequestParam Long province_id, @RequestParam Long district_id) {
		warehouseService.create(warehouse,province_id,district_id);
		
		return ResponseEntity.ok("ok");
	}

	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		warehouseService.deleteById(id);
		return ResponseEntity.ok("Da xoa kho " + id);
	}
}
