package com.mission.store.controller;

import com.mission.store.entity.Collection;
import com.mission.store.service.ICollectionService;
import com.mission.store.util.CalcPageUtil;
import com.mission.store.util.ResponseResult;
import com.mission.store.vo.CollectionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author mission
 * @date 2019/06/30 9:22
 */
@RestController
@RequestMapping("/collection")
public class CollectionController  extends BaseController{

  @Autowired
  private ICollectionService collectionService;

  @PostMapping("add")
  public ResponseResult add(Collection collection, HttpSession session){

    Integer uid = getUidFromSession(session);
    // 从session中获取username
    String username = session.getAttribute("username").toString();
    // 将uid封装到cart中
    collection.setUid(uid);
    collectionService.add(collection);
    return new  ResponseResult<>(SUCCESS);
  }
  @GetMapping("/{page}")
  public ResponseResult page(@PathVariable("page") Integer page,
                             @RequestParam(required = false) String search,
                             @RequestParam(required = false) Long greatprice,
                             @RequestParam(required = false) Long lessprice,
                             HttpSession session){

    Integer uid = getUidFromSession(session);
    // 从session中获取username
    String username = session.getAttribute("username").toString();
    // 将uid封装到cart中
    Integer index = CalcPageUtil.getIndex(page, 12);
    List<CollectionVO> list = collectionService.list(uid, index,search,greatprice,lessprice);
    Integer count = collectionService.countByUid(uid,search,greatprice,lessprice);
    ResponseResult<List<CollectionVO>> result = new ResponseResult<>(SUCCESS, list);
    result.setCount(count);
    return result;
  }

  @PostMapping("/del")
  public ResponseResult del( Integer id, HttpSession session){


    collectionService.deleteById(id);
    System.out.println("删除成功");
    return new  ResponseResult<>(SUCCESS);
  }


}



