package com.kexin.user.service;

import java.util.List;
import java.util.Map;

import com.kexin.user.dao.UserDao;
import com.kexin.user.dao.UserDaoImpl;
import com.kexin.user.entity.UserEntity;

public class UserServiceImpl implements UserService {
	/**
	 * 查询用户名和密码
	 */
	public List<Map<String, String>> fontUserName(String username, String password) throws Exception {
		// 实列化类 创建对象
		UserDao userdao = new UserDaoImpl();
		List<Map<String, String>> list = userdao.fontUserName(username, password);
		return list;
	}

	/**
	 * 按照用户名查询用户的ID （添加商品）
	 */
	public String getUserId(String loginName) throws Exception {
		// 实列化类 创建对象
		UserDao userdao = new UserDaoImpl();
		String userId = userdao.getUserId(loginName);
		return userId;
	}

	/**
	 * 查询用户名
	 */
	public List<UserEntity> fondUser() throws Exception {
		// 实列化类 创建对象
		UserDao userdao = new UserDaoImpl();
		List<UserEntity> list = userdao.fondUser();
		return list;
	}

	/**
	 * 添加用户名
	 */
	public String addUserName(String userId, String loginName, String passWord) throws Exception {
		// 实列化类 创建对象
		UserDao userdao = new UserDaoImpl();
		userdao.addUserName(userId, loginName, passWord);
		return userId;
	}

	/**
	 * 根据Id查询用户信息用户名
	 */
	public List<Map<String, String>> getIdFondUser(String userId) throws Exception {
		// 实列化类 创建对象
		UserDao userdao = new UserDaoImpl();
		List<Map<String, String>> list = userdao.getIdFondUser(userId);
		return list;
	}

	/**
	 * 修改用户名
	 */
	public String updateUserName(String userId, String loginName, String passWord) throws Exception {
		// 实列化类 创建对象
		UserDao userdao = new UserDaoImpl();
		userdao.updateUserName(userId, loginName, passWord);
		return userId;
	}

	/**
	 * 删除用户名
	 */
	public String DeleteUserName(String userId) throws Exception {
		// 实列化类 创建对象
		UserDao userdao = new UserDaoImpl();
		userdao.DeleteUserName(userId);
		return userId;
	}
}