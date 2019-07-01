package com.mission.store.entity;

import com.mission.store.entity.base.BaseEntity;

import javax.persistence.*;

/**
 * @author mission
 * @date 2019/06/30 9:14
 */

@Entity
@Table(name = "t_collection")
public class Collection extends BaseEntity {

  private static final long serialVersionUID = -2692377799099693032L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer cid;
  private Integer uid;
  private Long gid;

  public Integer getCid() {
    return cid;
  }

  public void setCid(Integer cid) {
    this.cid = cid;
  }

  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public Long getGid() {
    return gid;
  }

  public void setGid(Long gid) {
    this.gid = gid;
  }
}
