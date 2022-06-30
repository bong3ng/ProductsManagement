package ghtk.excel.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "warehouse")
@Builder
public class WareHouseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
//	@Column(name = "province_id")
//	private Long provinceId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "province_id", referencedColumnName = "id")
	private ProvinceEntity province;
	
	private Long status;
//	@Column(name = "district_id")
//	private Long districtId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "district_id", referencedColumnName = "id")
	private DistrictEntity district;
	
}
