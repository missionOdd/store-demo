package com.mission.store.controller;

import com.mission.store.entity.Cart;
import com.mission.store.service.ICartService;
import com.mission.store.util.ResponseResult;
import com.mission.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 处理购物车数据的控制器类
 */
@RestController
@RequestMapping("/carts")
public class CartController extends BaseController {

	@Autowired
	private ICartService cartService;
	
	@RequestMapping("/add")
	public ResponseResult<Void> addToCart(Cart cart, HttpSession session) {
		// 注意：客户端提交的cart只会包含gid, num
		// 从session中获取uid
		Integer uid = getUidFromSession(session);
		// 从session中获取username
		String username = session.getAttribute("username").toString();
		// 将uid封装到cart中
		cart.setUid(uid);
		// 执行：service.addToCart(username, cart);
		cartService.addToCart(username, cart);
		// 返回
		return new ResponseResult<>(SUCCESS);
	}

	@RequestMapping("/{id}/add_num")
	public ResponseResult<Void> addNum(
	    @PathVariable("id") Integer cid,
	    HttpSession session) {
	    // 从session中获取uid和username
		Integer uid = getUidFromSession(session);
		String username = session.getAttribute("username").toString();
	    // 执行
		cartService.addNum(uid, username, cid);
	    // 返回
		return new ResponseResult<>(SUCCESS);
	}
	
	@GetMapping("/")
	public ResponseResult<List<CartVO>> getByUid(
		HttpSession session,Integer page) {
		// 从session中获取uid
		Integer uid = getUidFromSession(session);
		// 执行：service.addToCart(username, cart);
		List<CartVO> data = cartService.getByUid(uid,page-1);
		Integer count=cartService.countByUid(uid);
		ResponseResult<List<CartVO>> result = new ResponseResult<>(SUCCESS, data);
		result.setCount(count);
		// 返回
		return result;
	}
	
	@GetMapping("/checked_list")
	public ResponseResult<List<CartVO>> getByCids(
			Integer[] cids) {
		// 执行
		List<CartVO> data = cartService.getByCids(cids);

		// 返回
		return new ResponseResult<>(SUCCESS, data);
	}
	
}






