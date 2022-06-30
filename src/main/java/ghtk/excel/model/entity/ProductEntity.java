package ghtk.excel.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Length(max = 100)
	private String name;
	@Min(0)
	private Double price;
	private String sku;
	private int status;
	private String description;
	@Column(name = "category_id")
	private Long categoryId;
	private String code;
	@Column(name = "created_at")
	private LocalDate createdAt;
	@Column(name = "modified_at")
	private LocalDate modifiedAt;
}
