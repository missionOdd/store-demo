package com.mission.store.service.impl;

import com.mission.store.entity.Goods;
import com.mission.store.mapper.GoodsMapper;
import com.mission.store.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 处理商品数据的业务层实现类
 */
@Service
public class GoodsServiceImpl implements IGoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
	
	@Override
	public List<Goods> getHotGoods() {
		return findHotGoods();
	}

	@Override
	public List<Goods> getNewGoods() {
		return goodsMapper.findNewGoods();
	}

	@Override
	public Goods getById(Long id) {
		return findById(id);
	}
	
	/**
	 * 获取热销商品列表
	 * @return 热销商品列表
	 */
	private List<Goods> findHotGoods() {
		return goodsMapper.findHotGoods();
	}
	
	/**
	 * 根据id查询商品详情
	 * @param id 商品的id
	 * @return 匹配的商品的详情，如果没有匹配的数据，则返回null
	 */
	private Goods findById(Long id) {
		return goodsMapper.findById(id);
	}


}
