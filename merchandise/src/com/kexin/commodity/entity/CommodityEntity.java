package com.kexin.commodity.entity;

import java.util.Date;

/**
 * 商品信息
 * 
 * @author lenovo
 *
 */
public class CommodityEntity {
	// 商品的id
	private String commodityId;
	// 商品的名字
	private String commodityName;
	// 商品价格
	private String commodityPrice;
	// 商品的数量
	private String commodityMuch;
	// 商品的保质期
	private String commodityPeriod;
	// 商品的生产地
	private String commodityYiedly;
	// 商品的分类
	private String category;
	// 用户名
	private String loginName;
	// 创建时间
	private Date entryTime;

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getCommodityPrice() {
		return commodityPrice;
	}

	public void setCommodityPrice(String commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	public String getCommodityMuch() {
		return commodityMuch;
	}

	public void setCommodityMuch(String commodityMuch) {
		this.commodityMuch = commodityMuch;
	}

	public String getCommodityPeriod() {
		return commodityPeriod;
	}

	public void setCommodityPeriod(String commodityPeriod) {
		this.commodityPeriod = commodityPeriod;
	}

	public String getCommodityYiedly() {
		return commodityYiedly;
	}

	public void setCommodityYiedly(String commodityYiedly) {
		this.commodityYiedly = commodityYiedly;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getloginName() {
		return loginName;
	}

	public void setloginName(String loginName) {
		this.loginName = loginName;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

}
