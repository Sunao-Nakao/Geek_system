package com.example.demo.constant;

public class UrlConst {
	
	
	/** ログイン画面 **/
	public static final String LOGIN = "/geek/login";
	
	/** ユーザ登録画面 **/
	public static final String SIGNUP = "/geek/signup";
	
	/** トップ画面 **/
	public static final String TOP = "/geek/top";
	
	/** 商品管理TOP画面 **/
	public static final String PRODUCTS_TOP = "/geek/products";
	
	/** 商品管理TOP画面 **/
	public static final String USERS_TOP = "/geek/users";
	
	/** 認証不要画面 **/
	public static final String[] NO_AUTHENTICATION = {LOGIN, "/webjars/**"};

}
