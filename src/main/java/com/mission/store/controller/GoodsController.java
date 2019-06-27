package com.mission.store.controller;

import com.mission.store.entity.Goods;
import com.mission.store.service.IGoodsService;
import com.mission.store.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController extends BaseController {
	
	@Autowired
	private IGoodsService goodsService;
	
	@GetMapping("/hot")
	public ResponseResult<List<Goods>> getHotGoods() {
		// 获取数据
		List<Goods> data = goodsService.getHotGoods();
		// 返回
		return new ResponseResult<>(SUCCESS, data);
	}

	@GetMapping("/new")
	public ResponseResult<List<Goods>> getNewGoods() {
		// 获取数据
		List<Goods> data = goodsService.getNewGoods();
		// 返回
		return new ResponseResult<>(SUCCESS, data);
	}
	
	@GetMapping("/{id}/details")
	public ResponseResult<Goods> getById(
		@PathVariable("id") Long id) {
		// 执行
		Goods data = goodsService.getById(id);
		// 返回
		return new ResponseResult<>(SUCCESS, data);
	}
	
}








