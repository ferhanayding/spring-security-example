package com.reactspring.reactspring.auth;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.reactspring.reactspring.error.ApiError;
import com.reactspring.reactspring.shared.Views;
import com.reactspring.reactspring.user.User;
import com.reactspring.reactspring.user.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
public class AuthController {

//	burda giris yapacak kişilerin giris yaparken yazdıkları ısım ve password bilgilerini 
//	decode dan alarak onu burda donusturup repositoryde olup olmadıgına bakıp ona gore gırıs izni vericez 
//  requestheader ise bize bu decode yazısını vericek bunada giris yaptıgımızda f12 ye basıp netwurkten requestheader bolumundeki 
//	authorization bolumunden ulasabılırız

	@Autowired
	UserRepository userRepository;
	
	
	@PostMapping("/api/1.0/auth")
	@JsonView(Views.Base.class)
	// jsonview olayı suan icin makul ama ilerde cok can sıkar amacı ise passwordu gostermemek icin yaptıgımız bisey
	ResponseEntity<?> handleAuthentication(@RequestHeader(name = "Authorization" ) String authorization) {

			String base64encoded = authorization.split("Basic ")[1]; // burası basic fsdfsfsfsefes diye gelen yeri basic den sonrasını aldık
			String decoded = new String(Base64.getDecoder().decode(base64encoded)); // burda ise o aldıgımızı decode ettik yani user1:P4ssword yaptık
			String [] parts = decoded.split(":"); // : ile ilükiye ayırdımız decoder strtingini aldık
			String username = parts[0];
			User inDB = userRepository.findByUsername(username);
			
			return ResponseEntity.ok().build();
		}
	  
}
