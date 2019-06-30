package com.mission.store.service;

import com.mission.store.entity.Collection;
import com.mission.store.vo.CollectionVO;

import java.util.List;

/**
 * @author mission
 * @date 2019/06/30 9:35
 */
public interface ICollectionService {

  int add(Collection collection);

  List<CollectionVO> list(Integer uid, Integer index);
}
