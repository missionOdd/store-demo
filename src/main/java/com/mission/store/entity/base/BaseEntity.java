package com.mission.store.entity.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类继承类
 * @author mission
 * @date 2019/6/6 14:19
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners(EntityListener.class)
@Access(AccessType.FIELD)
public abstract class BaseEntity<T> implements Serializable {


  private static final long serialVersionUID = 1L;


  @Column(length = 20)
  private String createdUser;

  /**
   * 创建时间
   */
  @DateTimeFormat(pattern = "yyyy--MM-dd hh:mm:ss")
  @Column(columnDefinition = "datetime not null default CURRENT_TIMESTAMP",nullable = false)
  private Date createdTime;


  @Column(length = 20)
  private String modifiedUser;

  /**
   * 修改时间
   */
  @DateTimeFormat(pattern = "yyyy--MM-dd hh:mm:ss")
  @Column(columnDefinition = "datetime default  CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP ")
  private Date modifiedTime;

  /**
   * 逻辑删除 (0-非删除 1-已删除)
   */
  @JsonIgnore
  @Column(name = "is_delete",columnDefinition = "tinyint(1) default 0",nullable = false)
  private Integer isDelete;

  /**
   * 版本号
   */
  @Version
  @Column(columnDefinition = "bigint(16) default 0",nullable = false)
  private Long version;

  public  Integer getIsDelete() {
    return isDelete;
  }

  public  void setIsDelete(Integer isDelete) {
    this.isDelete = isDelete;
  }
}