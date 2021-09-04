package com.reactspring.reactspring.user;

import javax.validation.ConstraintValidator;

import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;



public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername,String>{
// constraintvalidation ı burdaki false kısımdaki message gondermesi icin uniqueusername classına bagladık
//	username in kullanılıp kullanılmadıgını kontrol ediyoruz
	@Autowired
	UserRepository userRepository;
	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {

		User user = userRepository.findByUsername(username);
		if(user != null) {
			return false;
		}
		
		return 	true;
	}
	

}
