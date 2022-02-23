package com.vobi.bank.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vobi.bank.domain.Users;
import com.vobi.bank.dto.UserDTO;
import com.vobi.bank.mapper.UserMapper;
import com.vobi.bank.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	UserService userService; 
	
	@Autowired
	UserMapper userMapper;
	
	@GetMapping("/{userEmail}")
	public UserDTO findByName(@PathVariable("userEmail") String name) throws Exception {
		Users user = null;
		if(userService.findById(name).isPresent()==true) {
			user = userService.findById(name).get();
		}
		
		return userMapper.userToUserDTO(user);
	}
	
	@GetMapping
	public List<UserDTO> findAll() throws Exception{
		
		List<Users> users = userService.findAll();
		List<UserDTO> userDTO = userMapper.userListToUserDTOList(users);
		return userDTO;
	}

}
