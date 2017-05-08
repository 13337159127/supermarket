package com.kexin.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kexin.classify.dao.ClassifyDao;
import com.kexin.classify.dao.ClassifyDaoImpl;
import com.kexin.user.entity.UserEntity;

public class UserDaoImpl implements UserDao {
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
	 * 登录查询用户名和密码
	 */
	public List<Map<String, String>> fontUserName(String username, String password) throws Exception {
		// 定义一个集合list
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			UserDao userdao = new UserDaoImpl();
			Statement statement = userdao.getStatement();
			String sql = "select * from user where loginName='" + username + "' and passWord='" + password + "'";
			System.out.println(sql);
			ResultSet re = statement.executeQuery(sql);
			while (re.next()) {
				String loginName = re.getString("loginName");
				String passWord = re.getString("passWord");
				// 定义一个集合map
				Map<String, String> map = new HashMap<String, String>();
				map.put("username", loginName);
				map.put("password", passWord);
				list.add(map);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return list;
	}

	/**
	 * 按照用户名查询用户的ID （添加商品）
	 */
	public String getUserId(String loginName) throws Exception {
		try {
			UserDao userdao = new UserDaoImpl();
			Statement statement = userdao.getStatement();
			String sql = "select userId from user where loginName='" + loginName + "'";
			System.out.println(sql);
			ResultSet re = statement.executeQuery(sql);
			String userId = "";
			while (re.next()) {
				userId = re.getString("userId");
			}
			return userId;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	/**
	 * 查询用户名
	 */
	public List<UserEntity> fondUser() throws Exception {
		// 创建一个list
		List<UserEntity> list = new ArrayList<UserEntity>();
		try {
			// 实列化类 创建对象
			UserDao userdao = new UserDaoImpl();
			Statement statement = userdao.getStatement();
			String sql = "select * from user";
			System.out.println(sql);
			ResultSet re = statement.executeQuery(sql);
			while (re.next()) {
				String userId = re.getString("userId");
				String loginName = re.getString("loginName");
				String passWord = re.getString("passWord");
				UserEntity userentity = new UserEntity();
				userentity.setUserId(userId);
				userentity.setPassWord(passWord);
				userentity.setLoginName(loginName);
				list.add(userentity);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return list;
	}

	/**
	 * 添加用户名
	 */
	public String addUserName(String userId, String loginName, String passWord) throws Exception {
		try {
			// 实列化类 创建对象
			ClassifyDao classifydao = new ClassifyDaoImpl();
			Statement statement = classifydao.getStatement();
			String sql = "insert into user(userId,loginName,passWord) values('" + userId + "','" + loginName + "','"
					+ passWord + "')";
			System.out.println(sql);
			statement.executeUpdate(sql);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return userId;
	}

	/**
	 * 根据Id查询用户信息用户名
	 */
	public List<Map<String, String>> getIdFondUser(String userId) throws Exception {
		// 创建一个list
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			// 实列化类 创建对象
			ClassifyDao classifydao = new ClassifyDaoImpl();
			Statement statement = classifydao.getStatement();
			String sql = "select * from user where userId='" + userId + "'";
			System.out.println(sql);
			ResultSet re = statement.executeQuery(sql);
			while (re.next()) {
				String loginName = re.getString("loginName");
				String passWord = re.getString("passWord");
				Map<String, String> map = new HashMap<String, String>();
				map.put("loginName", loginName);
				map.put("passWord", passWord);
				map.put("userId", userId);
				list.add(map);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return list;
	}

	/**
	 * 修改用户名
	 */
	public String updateUserName(String userId, String loginName, String passWord) throws Exception {
		try {
			// 实列化类 创建对象
			ClassifyDao classifydao = new ClassifyDaoImpl();
			Statement statement = classifydao.getStatement();
			String sql = "update user set loginName='" + loginName + "',passWord='" + passWord + "' where userId='"
					+ userId + "'";
			System.out.println(sql);
			statement.executeUpdate(sql);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return userId;
	}

	/**
	 * 删除用户名
	 */
	public String DeleteUserName(String userId) throws Exception {
		try {
			// 实列化类 创建对象
			ClassifyDao classifydao = new ClassifyDaoImpl();
			Statement statement = classifydao.getStatement();
			String sql = "delete from user where userId='" + userId + "'";
			System.out.println(sql);
			statement.executeUpdate(sql);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return userId;
	}
}
