package com.kexin.commodity.service;

import java.util.List;
import java.util.Map;

import com.kexin.commodity.dao.CommodityDao;
import com.kexin.commodity.dao.CommodityDaoImpl;
import com.kexin.commodity.entity.CommodityEntity;

public class CommodityServiceImpl implements CommodityService {
	/**
	 * 查询商品信息
	 */
	public List<CommodityEntity> fondCommodity(String loginname, String classify, String designation, String sort) throws Exception{
		// 实列化类
		CommodityDao commoditydao = new CommodityDaoImpl();
		List<CommodityEntity> list = commoditydao.fondCommodity(loginname, classify, designation, sort);
		return list;
	}

	/**
	 * 添加商品信息
	 */
	public String addCommodity(String commodityId, String commodityName, String commodityPrice, String commodityMuch,
			String commodityPeriod, String commodityYiedly, String categoryId, String userId) throws Exception{
		// 实列化类
		CommodityDao commoditydao = new CommodityDaoImpl();
		commoditydao.addCommodity(commodityId, commodityName, commodityPrice, commodityMuch, commodityPeriod,
				commodityYiedly, categoryId, userId);
		return commodityId;
	}

	/**
	 * 根据ID查询商品信息 （修改信息使用）
	 */
	public List<Map<String, String>> fondUpdateCommodity(String commodityId) throws Exception{
		// 实列化类
		CommodityDao commoditydao = new CommodityDaoImpl();
		List<Map<String, String>> list1 = commoditydao.fondUpdateCommodity(commodityId);
		return list1;
	}

	/**
	 * 修改商品信息
	 */
	public String updateCommodity(String commodityId, String commodityName, String commodityPrice, String commodityMuch,
			String commodityPeriod, String commodityYiedly, String categoryId) throws Exception{
		// 实列化类
		CommodityDao commoditydao = new CommodityDaoImpl();
		commoditydao.updateCommodity(commodityId, commodityName, commodityPrice, commodityMuch, commodityPeriod,
				commodityYiedly, categoryId);
		return commodityId;
	}

	/**
	 * 删除商品
	 */
	public String deleteCommodity(String commodityId) throws Exception{
		// 实列化类
		CommodityDao commoditydao = new CommodityDaoImpl();
		commoditydao.deleteCommodity(commodityId);
		return commodityId;
	}

	/**
	 * 用户商品总数信息
	 */
	public List<Map<String, String>> commoditySum(String username) throws Exception{
		// 实列化类
		CommodityDao commoditydao = new CommodityDaoImpl();
		List<Map<String, String>> list = commoditydao.commoditySum(username);
		return list;
	}

	/**
	 * 每天录入商品总数信息
	 */
	public List<Map<String, String>> daySumCommodity() throws Exception{
		// 实列化类
		CommodityDao commoditydao = new CommodityDaoImpl();
		List<Map<String, String>> list = commoditydao.daySumCommodity();
		return list;
	}

	/**
	 * 每个分类商品总数信息
	 */
	public List<Map<String, String>> classifySumCommodity() throws Exception{
		// 实列化类
		CommodityDao commoditydao = new CommodityDaoImpl();
		List<Map<String, String>> list = commoditydao.classifySumCommodity();
		return list;
	}
}
