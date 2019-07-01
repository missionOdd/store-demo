package com.mission.store.entity;

import javax.persistence.*;

/**
 * @author mission
 * @date 2019/06/27 8:57
 */

@Entity
@Table(name = "t_order_item_sub")
public class OderItemSub {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Integer orderItemId;

  private String image;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getOrderItemId() {
    return orderItemId;
  }

  public void setOrderItemId(Integer orderItemId) {
    this.orderItemId = orderItemId;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
}
