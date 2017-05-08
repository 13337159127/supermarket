package com.kexin.classify.service;

import java.util.List;
import java.util.Map;

import com.kexin.classify.dao.ClassifyDao;
import com.kexin.classify.dao.ClassifyDaoImpl;
import com.kexin.classify.entity.ClassifyEntity;

public class ClassifyServiceImpl implements ClassifyService {
	/**
	 * 查询分类 添加 修改商品
	 */
	public List<Map<String, String>> getClassify() throws Exception {
		// 实列化类
		ClassifyDao classifydao = new ClassifyDaoImpl();
		List<Map<String, String>> list = classifydao.getClassify();
		return list;
	}

	/**
	 * 查询商品的分类
	 */
	public List<ClassifyEntity> fondClassify() throws Exception {
		// 实列化类
		ClassifyDao classifydao = new ClassifyDaoImpl();
		List<ClassifyEntity> list = classifydao.fondClassify();
		return list;
	}

	/**
	 * 添加商品的分类
	 */
	public String addClassify(String category, String categoryId) throws Exception {
		// 实列化类
		ClassifyDao classifydao = new ClassifyDaoImpl();
		classifydao.addClassify(category, categoryId);
		return category;
	}

	/**
	 * 根据ID修改商品的分类
	 */
	public List<Map<String, String>> getIdUpdateClassify(String categoryid) throws Exception {
		// 实列化类
		ClassifyDao classifydao = new ClassifyDaoImpl();
		List<Map<String, String>> list = classifydao.getIdUpdateClassify(categoryid);
		return list;
	}

	/**
	 * 修改商品的分类
	 */
	public String updateClassify(String category, String categoryId) throws Exception {
		// 实列化类
		ClassifyDao classifydao = new ClassifyDaoImpl();
		classifydao.updateClassify(category, categoryId);
		return category;
	}

	/**
	 * 删除商品的分类
	 */
	public String deleteClassify(String categoryId) throws Exception {
		// 实列化类
		ClassifyDao classifydao = new ClassifyDaoImpl();
		classifydao.deleteClassify(categoryId);
		return categoryId;
	}
}
