package com.springboot.taku.takuapp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.taku.takuapp.daoImpl.UserDaoImpl;
import com.springboot.taku.takuapp.entity.User;
import com.springboot.taku.takuapp.serviceIf.UserService;
import java.sql.*;
@Service
//public class UserServiceImpl implements UserService {
//  
//  @Autowired
//  private UserDaoImpl userDaoImpl;
// 
//@Override
//public void registerUser(User user) throws Exception {
//  if (userDaoImpl.findUserByUsername(user.getUsername()) != null) {
//    throw new Exception("Username already exists!");
//  }
//  userDao.save(user);
//}



public class UserServiceImpl implements UserService {

@Autowired
private UserDaoImpl userDaoImpl;

  // 保存用户信息的方法
	@Override
	public void registerUser(User user)  {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
      // 加载MySQL JDBC驱动
      Class.forName("com.mysql.jdbc.Driver");

      // 建立数据库连接
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");

      // 创建SQL语句
      String sql = "INSERT INTO userinfo (username, password ) VALUES (?, ?)";
      ps = conn.prepareStatement(sql);
      ps.setString(1, user.getUsername());
      ps.setString(2, user.getPassword());
   
      // 执行SQL语句
      int rows = ps.executeUpdate();
      if (rows > 0) {
        // 如果插入成功，则返回保存后的用户信息
        return;
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // 关闭数据库连接
      try {
        if (rs != null) rs.close();
        if (ps != null) ps.close();
        if (conn != null) conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    
  }
}



