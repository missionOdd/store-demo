package com.mission.store.mapper;

import com.mission.store.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * 处理用户数据的持久层接口
 */
public interface UserMapper {
	
	/**
	 * 插入用户数据
	 * @param user 用户数据
	 * @return 受影响的行数
	 */
	Integer insert(User user);

	/**
	 * 更新用户密码
	 * @param uid 用户的id
	 * @param password 新密码
	 * @param modifiedUser 修改执行人
	 * @param modifiedTime 修改时间
	 * @return 受影响的行数
	 */
	Integer updatePassword(
      @Param("uid") Integer uid,
      @Param("password") String password,
      @Param("modifiedUser") String modifiedUser,
      @Param("modifiedTime") Date modifiedTime);
	
	/**
	 * 更新个人资料
	 * @param user 个人资料数据
	 * @return 受影响的行数
	 */
	Integer updateInfo(User user);
	
	/**
	 * 更新用户头像
	 * @param uid 用户的id
	 * @param avatar 头像的路径
	 * @param modifiedUser 修改执行人
	 * @param modifiedTime 修改时间
	 * @return 受影响的行数
	 */
	Integer updateAvatar(
      @Param("uid") Integer uid,
      @Param("avatar") String avatar,
      @Param("modifiedUser") String modifiedUser,
      @Param("modifiedTime") Date modifiedTime);
	
	/**
	 * 根据用户名查询用户数据
	 * @param username 用户名
	 * @return 匹配的用户数据，如果没有匹配的数据，则返回null
	 */
	User findByUsername(String username);
	
	/**
	 * 根据用户id查询用户数据
	 * @param uid 用户id
	 * @return 匹配的用户数据，如果没有匹配的数据，则返回null
	 */
	User findByUid(Integer uid);

}





