package com.kexin.commodity.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kexin.commodity.entity.CommodityEntity;

public class CommodityDaoImpl implements CommodityDao {
	/**
	 * 会话工厂 方法被调用
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
	 * 查询商品信息
	 */
	public List<CommodityEntity> fondCommodity(String loginname, String classify, String designation, String sort)
			throws Exception {
		// 定义一个集合list
		List<CommodityEntity> list = new ArrayList<CommodityEntity>();
		try {
			CommodityDao commoditydao = new CommodityDaoImpl();
			Statement statement = commoditydao.getStatement();
			String sql = "select commodityId,commodityName,commodityPrice,commodityMuch,commodityPeriod,commodityYiedly,category,loginName,entryTime FROM commodity,user,classify WHERE commodity.categoryId=classify.categoryId AND commodity.userId=user.userId and loginName='"
					+ loginname + "'";
			if (classify != null && !"".equals(classify)) {
				sql = sql + " and category='" + classify + "'";
			}
			if (designation != null && !"".equals(designation)) {
				sql = sql + " and commodityName='" + designation + "'";
			}
			if (sort != null && !"".equals(sort)) {
				sql = sql + " order by " + sort + " asc";
			}
			System.out.println(sql);
			ResultSet re = statement.executeQuery(sql);
			while (re.next()) {
				String commodityId = re.getString("commodityId");
				String commodityName = re.getString("commodityName");
				String commodityPrice = re.getString("commodityPrice");
				String commodityMuch = re.getString("commodityMuch");
				String commodityPeriod = re.getString("commodityPeriod");
				String commodityYiedly = re.getString("commodityYiedly");
				String category = re.getString("category");
				String loginName = re.getString("loginName");
				Date entryTime = re.getTimestamp("entryTime");
				// 实例 化实体类
				CommodityEntity commodityentity = new CommodityEntity();
				commodityentity.setCommodityId(commodityId);
				commodityentity.setCommodityName(commodityName);
				commodityentity.setCommodityPrice(commodityPrice);
				commodityentity.setCommodityMuch(commodityMuch);
				commodityentity.setCommodityPeriod(commodityPeriod);
				commodityentity.setCommodityYiedly(commodityYiedly);
				commodityentity.setCategory(category);
				commodityentity.setloginName(loginName);
				commodityentity.setEntryTime(entryTime);
				list.add(commodityentity);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return list;
	}

	/**
	 * 添加商品信息
	 */
	public String addCommodity(String commodityId, String commodityName, String commodityPrice, String commodityMuch,
			String commodityPeriod, String commodityYiedly, String categoryId, String userId) throws Exception {
		// 获取系统日期和时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			CommodityDao commoditydao = new CommodityDaoImpl();
			Statement statement = commoditydao.getStatement();
			String sql = "insert into commodity(commodityId,commodityName,commodityPrice,commodityMuch,commodityPeriod,commodityYiedly,categoryId,userId,entryTime) values('"
					+ commodityId + "','" + commodityName + "','" + commodityPrice + "','" + commodityMuch + "','"
					+ commodityPeriod + "','" + commodityYiedly + "','" + categoryId + "','" + userId + "','"
					+ sdf.format(new Date()) + "')";
			System.out.println(sql);
			statement.executeUpdate(sql);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return commodityId;
	}

	/**
	 * 根据ID查询商品信息 （修改信息使用）
	 */
	public List<Map<String, String>> fondUpdateCommodity(String commodityId) throws Exception {
		List<Map<String, String>> list1 = new ArrayList<Map<String, String>>();
		try {
			CommodityDao commoditydao = new CommodityDaoImpl();
			Statement statement = commoditydao.getStatement();
			String sql = "select * from commodity where commodityId='" + commodityId + "'";
			System.out.println(sql);
			ResultSet re = statement.executeQuery(sql);
			while (re.next()) {
				String commodityName = re.getString("commodityName");
				String commodityPrice = re.getString("commodityPrice");
				String commodityMuch = re.getString("commodityMuch");
				String commodityPeriod = re.getString("commodityPeriod");
				String commodityYiedly = re.getString("commodityYiedly");
				String categoryId = re.getString("categoryId");
				// 定义一个集合map
				Map<String, String> map = new HashMap<String, String>();
				map.put("commodityId", commodityId);
				map.put("commodityName", commodityName);
				map.put("commodityPrice", commodityPrice);
				map.put("commodityMuch", commodityMuch);
				map.put("commodityPeriod", commodityPeriod);
				map.put("commodityYiedly", commodityYiedly);
				map.put("categoryId", categoryId);
				list1.add(map);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return list1;
	}

	/**
	 * 修改商品信息
	 */
	public String updateCommodity(String commodityId, String commodityName, String commodityPrice, String commodityMuch,
			String commodityPeriod, String commodityYiedly, String categoryId) throws Exception {
		try {
			CommodityDao commoditydao = new CommodityDaoImpl();
			Statement statement = commoditydao.getStatement();
			String sql = "update commodity set commodityName='" + commodityName + "',commodityPrice='" + commodityPrice
					+ "',commodityMuch='" + commodityMuch + "',commodityPeriod='" + commodityPeriod
					+ "',commodityYiedly='" + commodityYiedly + "',categoryId='" + categoryId + "' where commodityId='"
					+ commodityId + "'";
			System.out.println(sql);
			statement.executeUpdate(sql);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return commodityId;
	}

	/**
	 * 删除商品信息
	 */
	public String deleteCommodity(String commodityId) throws Exception {
		try {
			CommodityDao commoditydao = new CommodityDaoImpl();
			Statement statement = commoditydao.getStatement();
			String sql = "delete from commodity where commodityId='" + commodityId + "'";
			System.out.println(sql);
			statement.executeUpdate(sql);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return commodityId;
	}

	/**
	 * 用户商品总数信息
	 */
	public List<Map<String, String>> commoditySum(String username) throws Exception {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			CommodityDao commoditydao = new CommodityDaoImpl();
			Statement statement = commoditydao.getStatement();
			String sql = "select count(*) as sum from commodity,user where commodity.userId=user.userId and loginName='"
					+ username + "'";
			System.out.println(sql);
			ResultSet re = statement.executeQuery(sql);
			while (re.next()) {
				String sum = re.getString("sum");
				Map<String, String> map = new HashMap<String, String>();
				map.put("sum", sum);
				list.add(map);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return list;
	}

	/**
	 * 每天录入商品总数信息
	 */
	public List<Map<String, String>> daySumCommodity() throws Exception {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			CommodityDao commoditydao = new CommodityDaoImpl();
			Statement statement = commoditydao.getStatement();
			String sql = "select DATE_FORMAT(entryTime,'%Y-%m-%d') as date,count(*) as num from commodity GROUP BY  DATE_FORMAT(entryTime,'%Y-%m-%d')";
			System.out.println(sql);
			ResultSet re = statement.executeQuery(sql);
			while (re.next()) {
				String date = re.getString("date");
				String num = re.getString("num");
				Map<String, String> map = new HashMap<String, String>();
				map.put("num", num);
				map.put("date", date);
				list.add(map);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return list;
	}

	/**
	 * 每个分类商品总数信息
	 */
	public List<Map<String, String>> classifySumCommodity() throws Exception {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			CommodityDao commoditydao = new CommodityDaoImpl();
			Statement statement = commoditydao.getStatement();
			String sql = "select category as sort,COUNT(*) as sum from commodity,classify WHERE commodity.categoryId=classify.categoryId GROUP BY category;";
			System.out.println(sql);
			ResultSet re = statement.executeQuery(sql);
			while (re.next()) {
				String sort = re.getString("sort");
				String sum = re.getString("sum");
				Map<String, String> map = new HashMap<String, String>();
				map.put("sort", sort);
				map.put("sum", sum);
				list.add(map);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return list;
	}
}
