package com.example.demo.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignupForm {
	
	@NotBlank(message = "店舗名は必須項目です。")
	private String storeId;
	
	@NotBlank(message = "姓は必須項目です。")
	private String firstName;
	
	@NotBlank(message = "名は必須項目です。")
	private String lastName;
	
	@NotBlank(message = "メールアドレスは必須項目です。")
	@Email
	private String email;
	
	@Length(min = 6, max = 20)
	@NotBlank(message = "パスワードは必須項目です。")
	private String password;
	
	@NotBlank(message = "電話番号は必須項目です。")
	private String phone;
	
	@NotBlank(message = "役職は必須項目です。")
	private String roleId;
	
	@NotBlank(message = "権限は必須項目です。")
	private String permissionId;
	

}
