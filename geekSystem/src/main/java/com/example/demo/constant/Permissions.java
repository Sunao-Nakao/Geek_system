package com.example.demo.constant;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Permissions {
	
	/** 商品情報の確認が可能 **/
	UNKOWN("", "登録内容が不正"),
	
	/** 商品情報の確認が可能 **/
	ITEM_WATCHER("1", "商品情報の確認が可能"),
	
	/** 商品情報の確認、更新が可能 **/
	ITEM_MANAGER("2", "商品情報の確認、更新が可能"),
	
	/** 商品情報の確認、更新、全ユーザの情報管理が可能 **/
	ITEM_AND_USER_MANAGER("3", "商品情報の確認、更新、全ユーザ情報の管理が可能");
	
	private String code;
	
	private String displayValue;
	
	public static Permissions from(String code) {
		return Arrays.stream(Permissions.values())
				.filter(Permissions -> Permissions.getCode().equals(code))
				.findFirst()
				.orElse(UNKOWN);
	}

}