package id.dlabs.multipledatasource.repositoryread;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import id.dlabs.multipledatasource.entity.MasterProvince;

public interface MasterProvinceReadRepository extends PagingAndSortingRepository<MasterProvince, String>, JpaSpecificationExecutor<MasterProvince>{

}
