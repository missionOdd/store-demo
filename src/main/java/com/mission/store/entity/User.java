package com.mission.store.entity;

import com.mission.store.entity.base.BaseEntity;

import javax.persistence.*;

/**
 * 用户 持久类
 * @author mission
 * @date 2019/06/24 9:38
 */

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


  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public Integer getGender() {
    return gender;
  }

  public void setGender(Integer gender) {
    this.gender = gender;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }
}
