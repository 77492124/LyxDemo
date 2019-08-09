package com.woniu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.woniu.pojo.User;
import com.woniu.util.JdbcUtils;

public class UserDAO {
	Connection conn;
	PreparedStatement stat;
	ResultSet rs;
	public void update(String sql,Object[] objs){
		try {
			conn = JdbcUtils.getConn();
			stat = conn.prepareStatement(sql);
			for(int i=0;i<objs.length;i++){
				stat.setObject(i+1, objs[i]);
			}
			int rows = stat.executeUpdate();
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtils.getclose(rs, stat, conn);
		}
	}
	
	
	public void save(User user){
		String sql = "insert into tb_user values(?,?,?)";
		Object[] objs = {user.getUid(),user.getUname(),user.getUpwd()};
		update(sql,objs);
	}
	public void edit(User user){
		String sql = "update tb_user set uname=?,upwd=? where uid=?";
		Object[] objs = {user.getUname(),user.getUpwd(),user.getUid()};
		update(sql,objs);
	}
	public void delete(int uid){
		String sql = "delete from tb_user where uid=?";
		Object[] objs = {uid};
		update(sql,objs);
	}
	
	public User findOne(int uid){
		String sql = "select * from tb_user where uid=?";
		User User = null;
		try {
			conn = JdbcUtils.getConn();
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, uid);
			rs = stat.executeQuery();
			if(rs.next()){
				User = new User(rs.getInt(1),rs.getString(2),rs.getString(3));
			}
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtils.getclose(rs, stat, conn);
		}
		return User;
	}
	
	public List<User> findAll(){
		String sql = "select * from tb_user";
		List<User> Users = new ArrayList<User>();
		try {
			conn = JdbcUtils.getConn();
			PreparedStatement stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while(rs.next()){
				User User = new User(rs.getInt(1),rs.getString(2),rs.getString(3));
				Users.add(User);
			}
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtils.getclose(rs, stat, conn);
		}
		return Users;
	}


	public User login(User user) {
		String sql = "select * from tb_user where uname=? and upwd=?";
		User User = null;
		try {
			conn = JdbcUtils.getConn();
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, user.getUname());
			stat.setString(2, user.getUpwd());
			
			rs = stat.executeQuery();
			if(rs.next()){
				User = new User(rs.getInt(1),rs.getString(2),rs.getString(3));
			}
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtils.getclose(rs, stat, conn);
		}
		return User;
	}
}
