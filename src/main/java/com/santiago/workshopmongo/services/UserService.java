package com.santiago.workshopmongo.services;

import java.util.List;

import com.santiago.workshopmongo.domain.User;
import com.santiago.workshopmongo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}
}
