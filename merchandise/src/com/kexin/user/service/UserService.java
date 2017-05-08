package com.kexin.user.service;

import java.util.List;
import java.util.Map;

import com.kexin.user.entity.UserEntity;

public interface UserService {
	/**
	 * 按照登录查询用户名和密码
	 */
	public List<Map<String, String>> fontUserName(String username, String password) throws Exception;

	/**
	 * 按照用户名查询用户的ID （添加商品）
	 */
	public String getUserId(String loginName) throws Exception;

	/**
	 * 查询用户名
	 */
	public List<UserEntity> fondUser() throws Exception;

	/**
	 * 添加用户名
	 */
	public String addUserName(String userId, String loginName, String passWord) throws Exception;

	/**
	 * 根据Id查询用户信息用户名
	 */
	public List<Map<String, String>> getIdFondUser(String userId) throws Exception;

	/**
	 * 修改用户名
	 */
	public String updateUserName(String userId, String loginName, String passWord) throws Exception;

	/**
	 * 删除用户名
	 */
	public String DeleteUserName(String userId) throws Exception;
}
