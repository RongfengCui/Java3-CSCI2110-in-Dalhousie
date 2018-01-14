package com.cui.csci2110.lab4;

public class Test1{
	public static void main(String[] args){
try{
//加载MySql的驱动类
Class.forName("com.mysql.jdbc.Driver") ;
}catch(ClassNotFoundException e){
System.out.println("找不到驱动程序类，加载驱动失败！");
e.printStackTrace() ;
}
}}