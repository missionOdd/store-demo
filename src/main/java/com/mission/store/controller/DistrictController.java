package com.mission.store.controller;

import com.mission.store.entity.District;
import com.mission.store.service.IDistrictService;
import com.mission.store.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/districts")
public class DistrictController extends BaseController {

	@Autowired
	private IDistrictService districtService;
	
	@GetMapping("/")
	public ResponseResult<List<District>>
		getByParent(@RequestParam("parent") String parent) {
		List<District> data
			= districtService.getByParent(parent);
		return new ResponseResult<>(SUCCESS, data);
	}
	
}









