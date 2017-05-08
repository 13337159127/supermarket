package com.kexin.classify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kexin.classify.entity.ClassifyEntity;

public class ClassifyDaoImpl implements ClassifyDao {
	/**
	 * 会话工厂 实现方法被共享 调用
	 */
	public Statement getStatement() {
		// 定义变量
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/commoditymessage?"
					+ "user=root&password=1234&useUnicode=true&characterEncoding=UTF8";
			Connection conn = DriverManager.getConnection(url);
			statement = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statement;
	}

	/**
	 * 查询分类 （添加 修改商品）
	 */
	public List<Map<String, String>> getClassify() throws Exception {
		// 创建一个list
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			// 实列化类 创建对象
			ClassifyDao classifydao = new ClassifyDaoImpl();
			Statement statement = classifydao.getStatement();
			String sql = "select * from classify";
			System.out.println(sql);
			ResultSet re = statement.executeQuery(sql);
			while (re.next()) {
				String categoryId = re.getString("categoryId");
				String category = re.getString("category");
				Map<String, String> map = new HashMap<String, String>();
				map.put("categoryId", categoryId);
				map.put("category", category);
				list.add(map);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return list;
	}

	/**
	 * 查询商品的分类
	 */
	public List<ClassifyEntity> fondClassify() throws Exception {
		// 创建一个list
		List<ClassifyEntity> list = new ArrayList<ClassifyEntity>();
		try {
			// 实列化类 创建对象
			ClassifyDao classifydao = new ClassifyDaoImpl();
			Statement statement = classifydao.getStatement();
			String sql = "select * from classify";
			System.out.println(sql);
			ResultSet re = statement.executeQuery(sql);
			while (re.next()) {
				String categoryId = re.getString("categoryId");
				String category = re.getString("category");
				ClassifyEntity classifyentity = new ClassifyEntity();
				classifyentity.setCategoryId(categoryId);
				classifyentity.setCategory(category);
				list.add(classifyentity);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return list;
	}

	/**
	 * 添加商品的分类
	 */
	public String addClassify(String category, String categoryId) throws Exception {
		try {
			// 实列化类 创建对象
			ClassifyDao classifydao = new ClassifyDaoImpl();
			Statement statement = classifydao.getStatement();
			String sql = "insert into classify(categoryId,category) values('" + categoryId + "','" + category + "')";
			System.out.println(sql);
			statement.executeUpdate(sql);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return category;
	}

	/**
	 * 根据ID修改商品的分类
	 */
	public List<Map<String, String>> getIdUpdateClassify(String categoryid) throws Exception {
		// 创建一个list
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			// 实列化类 创建对象
			ClassifyDao classifydao = new ClassifyDaoImpl();
			Statement statement = classifydao.getStatement();
			String sql = "select * from classify where categoryId='" + categoryid + "'";
			System.out.println(sql);
			ResultSet re = statement.executeQuery(sql);
			while (re.next()) {
				String categoryId = re.getString("categoryId");
				String category = re.getString("category");
				Map<String, String> map = new HashMap<String, String>();
				map.put("categoryId", categoryId);
				map.put("category", category);
				list.add(map);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return list;
	}

	/**
	 * 修改商品的分类
	 */
	public String updateClassify(String category, String categoryId) throws Exception {
		try {
			// 实列化类 创建对象
			ClassifyDao classifydao = new ClassifyDaoImpl();
			Statement statement = classifydao.getStatement();
			String sql = "update classify set category='" + category + "' where categoryId='" + categoryId + "'";
			System.out.println(sql);
			statement.executeUpdate(sql);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return category;
	}

	/**
	 * 删除商品的分类
	 */
	public String deleteClassify(String categoryId) throws Exception {
		try {
			// 实列化类 创建对象
			ClassifyDao classifydao = new ClassifyDaoImpl();
			Statement statement = classifydao.getStatement();
			String sql = "delete from classify where categoryId='" + categoryId + "'";
			System.out.println(sql);
			statement.executeUpdate(sql);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return categoryId;
	}
}
