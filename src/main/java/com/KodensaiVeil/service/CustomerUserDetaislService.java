package com.KodensaiVeil.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.KodensaiVeil.model.USER_ROLE;
import com.KodensaiVeil.model.User;
import com.KodensaiVeil.repository.UserRepository;

@Service
public class CustomerUserDetaislService implements  UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		
		if(user != null) {
			throw new UsernameNotFoundException("User was not found with email" + username);
		}
		USER_ROLE role = user.getRole();
		if(role == null) role=USER_ROLE.ROLE_CUSTOMER;

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role.toString()));
		
		return null;
	}

}
