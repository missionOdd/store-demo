package com.mission.store.mapper;

import com.mission.store.entity.Collection;
import com.mission.store.vo.CollectionVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
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

  @Select("<script> SELECT " +
      "uid, cid, gid, title, image, price " +
      "FROM " +
      "t_collection LEFT JOIN t_goods " +
      "ON " +
      "t_collection.gid=t_goods.id " +
      " <where> " +
      "t_collection.uid=#{uid} "+
      " <if test='search!= null and search!= \"\" '> " +
      " and t_goods.title like concat('%',#{search},'%')  " +
      "</if>"+
      " <if test='greatprice!= null'> " +
      " and t_goods.price &gt;= #{greatprice} " +
      "</if>"+
      " <if test='lessprice!= null'> " +
      " and t_goods.price &lt;= #{lessprice} " +
      "</if>"+
      "</where>" +
      "ORDER BY " +
      "t_collection.modified_time DESC, cid DESC " +
      "LIMIT #{index},12" +
      "</script>")
  List<CollectionVO> list(@Param("uid") Integer uid,@Param("index") Integer index,@Param("search")String search, @Param("greatprice") Long greatprice, @Param("lessprice") Long lessprice);

  @Select("<script> select  count(*) " +
      "  FROM " +
      "      t_collection " +
      "  LEFT JOIN " +
      "  t_goods " +
      "      ON " +
      "  t_collection.gid=t_goods.id " +
      " <where> " +
      "  t_collection.uid=#{uid} "+
      " <if test='search!= null and search!= \"\" '> " +
      " and t_goods.title like concat('%',#{search},'%') " +
      "</if>"+
      " <if test='greatprice!= null '> " +
      " and t_goods.price &gt;= #{greatprice} " +
      "</if>"+
      " <if test='lessprice!= null'> " +
      " and t_goods.price &lt;= #{lessprice} " +
      "</if>"+
      "</where>" +
      "</script>")
  Integer countByUid(@Param("uid") Integer uid, @Param("search")String search, @Param("greatprice") Long greatprice, @Param("lessprice") Long lessprice);

  @Delete("delete from t_collection where  cid =#{cid}")
  Integer deleteById(@Param("cid")Integer cid);

}
