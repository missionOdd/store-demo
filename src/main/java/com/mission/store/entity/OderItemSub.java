package com.mission.store.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author mission
 * @date 2019/06/27 8:57
 */
@Getter
@Setter
@Entity
@Table(name = "t_order_item_sub")
public class OderItemSub {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Integer orderItemId;

  private String image;
}
