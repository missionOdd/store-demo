package com.mission.store.entity;

import com.mission.store.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 收货地址的实体类
 */
@Getter
@Setter
@Entity
@Table(name = "t_address")
public class Address extends BaseEntity {

	private static final long serialVersionUID = 8491523504331195543L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer aid;
	private Integer uid;
	private String name;
	private String province;
	private String city;
	private String area;
	private String district;
	private String zip;
	private String address;
	private String phone;
	private String tel;
	private String tag;
	private Integer isDefault;
}
