package com.mission.store.entity;

import com.mission.store.entity.base.BaseEntity;

import javax.persistence.*;

/**
 * 订单商品的实体类
 */
@Entity
@Table(name = "t_order_item")
public class OrderItem extends BaseEntity {

	private static final long serialVersionUID = -3906850018555473314L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer oid;
	private Long gid;
	private String title;
	private String image;
	private Long price;
	private Integer num;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Long getGid() {
		return gid;
	}

	public void setGid(Long gid) {
		this.gid = gid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}
