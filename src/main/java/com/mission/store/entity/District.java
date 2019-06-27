package com.mission.store.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 省/市/区数据的实体类
 */

@Entity
@Table(name = "t_district")
public class District implements Serializable {

	private static final long serialVersionUID = -2777570570541589252L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String parent;
	private String code;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "District [id=" + id + ", parent=" + parent + ", code=" + code + ", name=" + name + "]";
	}

}
