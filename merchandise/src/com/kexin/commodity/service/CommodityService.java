package com.kexin.commodity.service;

import java.util.List;
import java.util.Map;

import com.kexin.commodity.entity.CommodityEntity;

public interface CommodityService {
	/**
	 * 查询商品信息
	 */
	public List<CommodityEntity> fondCommodity(String loginname, String classify, String designation, String sort)
			throws Exception;

	/**
	 * 添加商品信息
	 */
	public String addCommodity(String commodityId, String commodityName, String commodityPrice, String commodityMuch,
			String commodityPeriod, String commodityYiedly, String categoryId, String userId) throws Exception;

	/**
	 * 根据ID查询商品信息 （修改信息使用）
	 */
	public List<Map<String, String>> fondUpdateCommodity(String commodityId) throws Exception;

	/**
	 * 修改商品信息
	 */
	public String updateCommodity(String commodityId, String commodityName, String commodityPrice, String commodityMuch,
			String commodityPeriod, String commodityYiedly, String categoryId) throws Exception;

	/**
	 * 删除商品信息
	 */
	public String deleteCommodity(String commodityId) throws Exception;

	/**
	 * 用户商品总数信息
	 */
	public List<Map<String, String>> commoditySum(String username) throws Exception;

	/**
	 * 每天录入商品总数信息
	 */
	public List<Map<String, String>> daySumCommodity() throws Exception;

	/**
	 * 每个分类商品总数信息
	 */
	public List<Map<String, String>> classifySumCommodity() throws Exception;
}
