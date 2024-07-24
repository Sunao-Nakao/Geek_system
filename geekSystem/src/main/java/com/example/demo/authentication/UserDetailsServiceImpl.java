package com.example.demo.authentication;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.Repository.UsersRepository;

import lombok.RequiredArgsConstructor;


/**ユーザ情報生成 **/
@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{
	

	/**ユーザ情報テーブルrepository **/
	private final UsersRepository repository;
	
	/** ユーザ情報生成 **
	 * @param username Email
	 * @throws UsernameNotFoundException
	 */
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
		var users =repository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException(username));
		
		return User.withUsername(users.getEmail())
				.password(users.getPassword())
				.authorities(users.getPermissionId())
				.build();
	}

}