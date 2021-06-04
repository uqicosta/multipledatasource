package id.dlabs.multipledatasource.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import id.dlabs.multipledatasource.dto.MasterProvinceDto;
import id.dlabs.multipledatasource.dto.response.Response;
import id.dlabs.multipledatasource.entity.MasterProvince;
import id.dlabs.multipledatasource.repository.MasterProvinceRepository;
import id.dlabs.multipledatasource.repositoryread.MasterProvinceReadRepository;

@RestController
@RequestMapping("/rest/admin/secured/settings/province")
public class AdminSettingsProvinceController {
	@Autowired
	private MasterProvinceRepository masterProvinceRepository;
	@Autowired
	private MasterProvinceReadRepository masterProvinceReadRepository;
	
	@RequestMapping(path = "/findAll", method = RequestMethod.GET)
	public Response<Iterable<MasterProvince>> findAll() {
		Iterable<MasterProvince> results = masterProvinceReadRepository.findAll();
		Response<Iterable<MasterProvince>> response = new Response<Iterable<MasterProvince>>(results);
		return response;
	}
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public Response<MasterProvinceDto> save(@RequestBody MasterProvinceDto dto) {
		MasterProvince entity = null;
		if(dto.getProvinceId() != null && dto.getProvinceId().trim().length() > 0) {
			Optional<MasterProvince> optionalEntity = masterProvinceReadRepository.findById(dto.getProvinceId());
			if(optionalEntity.isPresent()) {
				entity = optionalEntity.get();
			}
		}
		
		if(entity == null) {
			entity = new MasterProvince();
			entity.setProvinceId(dto.getProvinceId());
		}
		entity.setProvinceName(dto.getProvinceName());
		
		masterProvinceRepository.save(entity);
		
		MasterProvinceDto resultDto = new MasterProvinceDto();
		resultDto.setProvinceId(entity.getProvinceId());
		resultDto.setProvinceName(entity.getProvinceName());
		Response<MasterProvinceDto> response = new Response<MasterProvinceDto>(resultDto);
		return response;
	}
}
