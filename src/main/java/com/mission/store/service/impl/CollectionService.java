package com.mission.store.service.impl;

import com.mission.store.entity.Collection;
import com.mission.store.mapper.CollectionMapper;
import com.mission.store.service.ICollectionService;
import com.mission.store.vo.CollectionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mission
 * @date 2019/06/30 9:38
 */
@Service
public class CollectionService implements ICollectionService {

  @Autowired
  private CollectionMapper collectionMapper;

  @Override
  public int add(Collection collection) {
    if (collectionMapper.findbyUIdAndGId(collection.getUid(),collection.getGid())!=null){
      return 0;
    }
    return collectionMapper.add(collection);
  }

  @Override
  public List<CollectionVO> list(Integer uid, Integer index) {
    return collectionMapper.list(uid,index);
  }
}
