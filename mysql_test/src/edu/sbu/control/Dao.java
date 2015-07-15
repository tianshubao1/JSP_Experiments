package edu.sbu.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Dao {
	private Connection conn;
	public Dao(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/insurance";
			conn = DriverManager.getConnection(url,"root","19901029b");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("fail to connect DB!");
		}
	}
	
	public boolean checkUsername(String username){
		if(conn != null){
			String sql = "select * from customer";
			try{
				Statement stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(sql);
				while(rs.next()){
					if(rs.getString("username").equals(username)){
						return true;
					}
				}
				return false;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean checkVin(String vin){
		if(conn != null){
			String sql = "select * from vehicle";
			try{
				Statement stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(sql);
				while(rs.next()){
					if(rs.getString("vin").equals(vin)){
						return true;
					}
				}
				return false;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public List<Customer> getAllCustomer(){
		List<Customer> list = new ArrayList<Customer>();
		if(conn != null){
			String sql = "select * from customer";
			try{
				Statement stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(sql);
				while(rs.next()){
					Customer customer = new Customer();
					customer.setFirstname(rs.getString("firstname"));
					customer.setLastname(rs.getString("lastname"));
					customer.setPolicyno(rs.getString("policyno"));
					customer.setPhoneno(rs.getString("phoneno"));
					customer.setEmail(rs.getString("email"));
					customer.setPolicyco(rs.getString("policyco"));
					customer.setAAA(rs.getString("AAA"));
					customer.setUsername(rs.getString("username"));
					list.add(customer);
				}
				return list;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public void deleteCustomer(String key){
		if(conn != null){
			String sql = "delete from customer where username = ?";
			try{
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, key);
				ps.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void deleteVehicle(String key){
		if(conn != null){
			String sql = "delete from vehicle where vin = ?";
			try{
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, key);
				ps.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void updateCustomer(Customer c){
		if(conn != null){
			String sql = "update customer set firstname = ?, lastname = ?, policyno = ?, phoneno = ?, email = ?, policyco = ?, AAA = ? where username = ?";
			try{
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, c.getFirstname());
				ps.setString(2, c.getLastname());
				ps.setString(3, c.getPolicyno());
				ps.setString(4, c.getPhoneno());
				ps.setString(5, c.getEmail());
				ps.setString(6, c.getPolicyco());
				ps.setString(7, c.getAAA());
				ps.setString(8, c.getUsername());
				ps.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void updateVehicle(Vehicle v){
		if(conn != null){
			String sql = "update vehicle set make = ?, model = ?, type = ?, yearofmake = ?, picture = ? where vin = ?";
			try{
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, v.getMake());
				ps.setString(2, v.getModel());
				ps.setString(3, v.getType());
				ps.setString(4, v.getYearofmake());
				ps.setString(5, v.getPciture());
				ps.setString(6, v.getVin());
				ps.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void createCustomer(Customer c){
		if(conn != null){
			String sql = "insert into customer values(?,?,?,?,?,?,?,?)";
			try{
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, c.getFirstname());
				ps.setString(2, c.getLastname());
				ps.setString(3, c.getPolicyno());
				ps.setString(4, c.getPhoneno());
				ps.setString(5, c.getEmail());
				ps.setString(6, c.getPolicyco());
				ps.setString(7, c.getAAA());
				ps.setString(8, c.getUsername());
				ps.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void createVehicle(Vehicle v){
		if(conn != null){
			String sql = "insert into vehicle values(?,?,?,?,?,?,?)";
			try{
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(3, v.getMake());
				ps.setString(4, v.getModel());
				ps.setString(5, v.getType());
				ps.setString(6, v.getYearofmake());
				ps.setString(7, v.getPciture());
				ps.setString(2, v.getVin());
				ps.setString(1, v.getUsername());
				ps.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public List<Vehicle> getAllVehicle(String username){
		List<Vehicle> list = new ArrayList<Vehicle>();
		if(conn != null){
			String sql = "select * from vehicle where username = ?";
			try{
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Vehicle v = new Vehicle();
					v.setUsername(rs.getString("username"));
					v.setVin(rs.getString("vin"));
					v.setMake(rs.getString("make"));
					v.setModel(rs.getString("model"));
					v.setType(rs.getString("type"));
					v.setYearofmake(rs.getString("yearofmake"));
					v.setPicture(rs.getString("picture"));
					list.add(v);
				}
				return list;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return list;
	}
	public void close(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
