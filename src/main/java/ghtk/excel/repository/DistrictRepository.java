package ghtk.excel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ghtk.excel.model.entity.DistrictEntity;
@Repository
public interface DistrictRepository extends JpaRepository<DistrictEntity, Long> {

}
