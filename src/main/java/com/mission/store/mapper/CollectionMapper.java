package com.mission.store.mapper;

import com.mission.store.entity.Collection;
import com.mission.store.vo.CollectionVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author mission
 * @date 2019/06/30 9:24
 */
public interface CollectionMapper {
  @Insert("INSERT INTO t_collection (uid,gid) value (#{uid},#{gid}) ")
  int add(Collection collection);

  @Select("SELECT uid from t_collection where uid =#{uid} and gid=#{gid} ")
  Integer findbyUIdAndGId(Integer uid,Long gid);

  @Select("SELECT " +
      "uid, cid, gid, title, image, price " +
      "FROM " +
      "t_collection LEFT JOIN t_goods " +
      "ON " +
      "t_collection.gid=t_goods.id " +
      "WHERE " +
      "t_collection.uid=#{uid} " +
      "ORDER BY " +
      "t_collection.modified_time DESC, cid DESC " +
      "LIMIT #{index},12")
  List<CollectionVO> list(Integer uid, Integer index);
}
