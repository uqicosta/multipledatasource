package id.dlabs.multipledatasource.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import id.dlabs.multipledatasource.entity.MasterProvince;

public interface MasterProvinceRepository extends PagingAndSortingRepository<MasterProvince, String>, JpaSpecificationExecutor<MasterProvince>{

}
