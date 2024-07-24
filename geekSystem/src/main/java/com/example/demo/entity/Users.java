package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class Users {
	
	private String id; //データベースで自動生成
	
	@Column(name = "store_id")
	private String storeId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Id
	private String email;
	
	private String password;
	
	private String phone;
	
	@Column(name = "role_id")
	private String roleId;
	
	@Column(name = "permission_id")
	private String permissionId;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

}