package id.dlabs.multipledatasource.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "MASTER_PROVINCE")
public class MasterProvince {
	@Id
	private String provinceId;
	private String provinceName;

}
