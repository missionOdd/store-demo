package com.mission.store.controller;

import com.mission.store.entity.Order;
import com.mission.store.service.IOrderService;
import com.mission.store.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/orders")
public class OrderController extends BaseController {

	@Autowired
	private IOrderService orderService;
	
	@RequestMapping("/create")
	public ResponseResult<Order> createOrder(
		Integer aid, Integer[] cids, HttpSession session) {
		// 从session中获取uid
		Integer uid = getUidFromSession(session);
		// 从session中获取username
		String username = session.getAttribute("username").toString();
		// 执行
		Order data = orderService.createOrder(uid, username, aid, cids);
		// 返回
		return new ResponseResult<>(SUCCESS, data);
	}
	
}



