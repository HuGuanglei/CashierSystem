/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netbeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author che8435464
 */
public class DbManager {
	/**
	 * 数据库连接驱动包名
	 */
	public static final String driver = "com.mysql.jdbc.Driver";
	/**
	 * 数据库地址和库名
	 */
	public static final String url = "jdbc:mysql://localhost:3306/Database";
	/**
	 * 数据库用户名
	 */
	public static final String user = "root";
	/**
	 * 数据库密码
	 */
	public static final String password = "2147483647";

	/**
	 * 保存商品信息
	 * 
	 * @param goods
	 *            商品信息实体
	 * @return
	 * @throws Exception
	 */
	public static int save(Goods goods) {
		Connection conn = null;
		Statement statement = null;
		try {
			// 加载驱动程序
			Class.forName(driver).newInstance();
			// getConnection()方法，连接MySQL数据库！！
			conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
			}
			// 创建statement类对象，用来执行SQL语句！！
			statement = conn.createStatement();
			// 要执行的SQL语句
			String sql = "insert into Goods(Name,Price,Quantity,Sale) values ('" + goods.getName() + "','"
					+ goods.getPrice() + "','" + goods.getQuantity() + "','" + goods.getSale() + "')";

			// 执行插入操作
			int i = statement.executeUpdate(sql);
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {//关闭数据库连接
			try {
				if (statement != null)
					statement.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
        
        /**
	 * 更新商品信息
	 * 
	 * @param goods
	 *            商品信息实体
	 * @return
	 * @throws Exception
	 */
	public static int update(Goods goods) {
		Connection conn = null;
		Statement statement = null;
		try {
			// 加载驱动程序
			Class.forName(driver).newInstance();
			// getConnection()方法，连接MySQL数据库！！
			conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
			}
			// 创建statement类对象，用来执行SQL语句！！
			statement = conn.createStatement();
			// 要执行的SQL语句
			String sql = "update Goods set Quantity = Quantity - " + goods.getQuantity() + ",Sale = Sale +"
					+ goods.getSale() + " where ID=" + goods.getId() + "";

			// 执行插入操作
			int i = statement.executeUpdate(sql);
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {//关闭数据库连接
			try {
				if (statement != null)
					statement.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
	
	/**
	 * 查询所有商品信息
         * @param name : 商品名称，为null或空查出全部
	 * @return
	 */
	public static List<Goods> getAllGoods(String name){
		Connection conn = null;
		Statement statement = null;
		try {
			// 加载驱动程序
			Class.forName(driver).newInstance();
			// getConnection()方法，连接MySQL数据库！！
			conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
			}
			// 创建statement类对象，用来执行SQL语句！！
			statement = conn.createStatement();
			// 要执行的SQL语句
			String sqlg = "select * from Goods";
			if(name !=null && !"".equals(name.trim())){
                            sqlg += " where Name = '" + name.trim() +  "'";
                        }
                        System.out.println(sqlg);

			// 执行查询操作
			ResultSet res = statement.executeQuery(sqlg);
			List<Goods> list = new ArrayList<>();
			while (res.next()) {
				//将查询出来的数据放入list数组
				Goods goods = new Goods();
				goods.setName(res.getString("Name"));
				goods.setId(res.getInt("ID"));
				goods.setPrice(res.getFloat("Price"));
				goods.setQuantity(res.getInt("Quantity"));
				goods.setSale(res.getInt("Sale"));
				list.add(goods);
			}
			res.close();
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {//关闭数据库连接
			try {
				if (statement != null)
					statement.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
        
        /**
	 * 删除商品信息
	 * 
	 * @param goods
	 *            商品信息实体
	 * @return
	 * @throws Exception
	 */
	public static int delete(int id) {
		Connection conn = null;
		Statement statement = null;
		try {
			// 加载驱动程序
			Class.forName(driver).newInstance();
			// getConnection()方法，连接MySQL数据库！！
			conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
			}
			// 创建statement类对象，用来执行SQL语句！！
			statement = conn.createStatement();
			// 要执行的SQL语句
			String sql = "delete from Goods where ID = '" + id + "'";

			// 执行删除操作
			int i = statement.executeUpdate(sql);
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {//关闭数据库连接
			try {
				if (statement != null)
					statement.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
        
        
        /**
	 * 查询所有交易流水
	 * @return
	 */
	public static List<String> getAllTransFlow(){
		Connection conn = null;
		Statement statement = null;
		try {
			// 加载驱动程序
			Class.forName(driver).newInstance();
			// getConnection()方法，连接MySQL数据库！！
			conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
			}
			// 创建statement类对象，用来执行SQL语句！！
			statement = conn.createStatement();
			// 要执行的SQL语句
			String sqlg = "select * from transflow";
			
                        System.out.println(sqlg);

			// 执行查询操作
			ResultSet res = statement.executeQuery(sqlg);
			List<String> list = new ArrayList<>();
			while (res.next()) {
				//将查询出来的数据放入list数组
				TransFlow transFlow = new TransFlow();
				transFlow.setProName(res.getString("proname"));
				transFlow.setId(res.getInt("id"));
				transFlow.setAmt(res.getFloat("amt"));
				transFlow.setBal(res.getInt("bal"));
				transFlow.setTransDate(res.getDate("transDate"));
				list.add(transFlow.toString());
			}
			res.close();
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {//关闭数据库连接
			try {
				if (statement != null)
					statement.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
        
        /**
	 * 保存交易信息
	 * 
	 * @param transFlow
	 *            交易信息实体
	 * @return
	 * @throws Exception
	 */
	public static int save(TransFlow transFlow) {
		Connection conn = null;
		Statement statement = null;
		try {
			// 加载驱动程序
			Class.forName(driver).newInstance();
			// getConnection()方法，连接MySQL数据库！！
			conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
			}
			// 创建statement类对象，用来执行SQL语句！！
			statement = conn.createStatement();
			// 要执行的SQL语句
			String sql = "insert into transflow(proname,amt,bal,transDate) values ('"
					+ transFlow.getProName() + "','" + transFlow.getAmt()+ "','" + transFlow.getBal()+ "','" + transFlow.getTransDate() + "')";

			// 执行插入操作
			int i = statement.executeUpdate(sql);
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {//关闭数据库连接
			try {
				if (statement != null)
					statement.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
