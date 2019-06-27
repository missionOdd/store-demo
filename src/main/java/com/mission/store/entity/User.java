package com.mission.store.entity;

import com.mission.store.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 用户 持久类
 * @author mission
 * @date 2019/06/24 9:38
 */
@Getter
@Setter
@Entity
@Table(name = "t_user")
public class User extends BaseEntity {

  /**
   * 用户编号
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer uid;

  /**
   * 用户名
   */
  @Column(columnDefinition = "varchar(20) unique not null comment \'用户名\'")
  private String username;

  /**
   * 密码
   */
  @Column(columnDefinition = "char(32) not null")
  private String password;

  /**
   * 密码盐
   */
  @Column(columnDefinition = "char(36) not null")
  private String salt;

  /**
   * 性别
   */
  private Integer gender;

  /**
   * 邮箱
   */
  private String email;

  /**
   * 电话
   */
  private String phone;

  /**
   * 头像
   */
  private String avatar;
}
