package com.vobi.bank.dto;


import javax.validation.constraints.NotNull;

//import com.vobi.bank.domain.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	@NotNull
	@Email(message = "El correo electronico no esta bien escrito")
	private String userEmail;

	//@NotNull
	//private UserType userType;

	@NotNull
	private Integer ustyId;

	@NotNull
	private String enable;

	@NotNull
	private String name;
	
	private String token;

}
