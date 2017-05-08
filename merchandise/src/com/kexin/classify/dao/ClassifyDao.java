package com.kexin.classify.dao;

import java.sql.Statement;
import java.util.List;
import java.util.Map;

import com.kexin.classify.entity.ClassifyEntity;

public interface ClassifyDao {
	/**
	 * 会话工厂 实现方法被共享 调用
	 */
	public Statement getStatement();

	/**
	 * 查询分类 (添加 修改商品)
	 */
	public List<Map<String, String>> getClassify() throws Exception;

	/**
	 * 查询商品的分类
	 */
	public List<ClassifyEntity> fondClassify() throws Exception;

	/**
	 * 添加商品的分类
	 */
	public String addClassify(String category, String categoryId) throws Exception;

	/**
	 * 根据ID修改商品的分类
	 */
	public List<Map<String, String>> getIdUpdateClassify(String categoryid) throws Exception;

	/**
	 * 修改商品的分类
	 */
	public String updateClassify(String category, String categoryId) throws Exception;

	/**
	 * 删除商品的分类
	 */
	public String deleteClassify(String categoryId) throws Exception;

}
