package edu.sbu.control;

public class Vehicle {
	private String username;
	private String vin;
	private String make;
	private String model;
	private String type;
	private String yearofmake;
	private String picture;
	
	public void setUsername(String input){
		this.username = input;
	}
	public String getUsername(){
		return this.username;
	}
	
	public void setVin(String input){
		this.vin = input;
	}
	public String getVin(){
		return this.vin;
	}
	
	public void setMake(String input){
		this.make = input;
	}
	public String getMake(){
		return this.make;
	}
	
	public void setModel(String input){
		this.model = input;
	}
	public String getModel(){
		return this.model;
	}
	
	public void setType(String input){
		this.type = input;
	}
	public String getType(){
		return this.type;
	}
	
	public void setYearofmake(String input){
		this.yearofmake = input;
	}
	public String getYearofmake(){
		return this.yearofmake;
	}
	
	public void setPicture(String input){
		this.picture = input;
	}
	public String getPciture(){
		return this.picture;
	}
}

