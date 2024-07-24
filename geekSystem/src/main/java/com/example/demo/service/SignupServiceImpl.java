package com.example.demo.service;

import java.util.Optional;

import org.dozer.Mapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UsersRepository;
import com.example.demo.constant.Permissions;
import com.example.demo.entity.Users;
import com.example.demo.form.SignupForm;

import lombok.RequiredArgsConstructor;


/** ユーザー登録画面Service **/
@Service
@RequiredArgsConstructor
public class SignupServiceImpl implements SignupService {
	
	/** ユーザー情報テーブルDAO **/
	private final UsersRepository repository;
	
	/** Dozer Mapper **/
	private final Mapper mapper;
	
	/** PasswordEncoder **/
	private final PasswordEncoder passwordEncoder;
	
	
	/** ユーザー情報テーブル 新規登録 **
	 * {@inheritDoc}
	 * @param form 入力情報
	 * @return 登録情報(ユーザ情報Entity)、既に同じEmailで登録がある場合はEnpty
	 */
	@Override
	public Optional<Users> resistUsers(SignupForm form) {
		var usersExistedOpt = repository.findByEmail(form.getEmail());
		if (usersExistedOpt.isPresent()) {
			return Optional.empty();
		}
		
		var users = mapper.map(form, Users.class);
		var encodedPassword = passwordEncoder.encode(form.getPassword());
		users.setPassword(encodedPassword);
		users.setPermissionId(Permissions.ITEM_WATCHER.getPermissions());
		
		return Optional.of(repository.save(users));
	}
	
}