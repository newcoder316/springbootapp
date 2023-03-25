package com.springboot.taku.takuapp.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.taku.takuapp.dao.UserDao;
import com.springboot.taku.takuapp.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	  
	  @Autowired
	  private JdbcTemplate jdbcTemplate;
	  
	  @Override
	  public void save(User user) {
	    String sql = "INSERT INTO userinfo (username, password, ) VALUES (?, ?)";
	    jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
	  }
	  
	}
