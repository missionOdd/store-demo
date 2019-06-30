package com.mission.store.entity;

import com.mission.store.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author mission
 * @date 2019/06/30 9:14
 */
@Getter
@Setter
@Entity
@Table(name = "t_collection")
public class Collection extends BaseEntity {

  private static final long serialVersionUID = -2692377799099693032L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer cid;
  private Integer uid;
  private Long gid;

}
