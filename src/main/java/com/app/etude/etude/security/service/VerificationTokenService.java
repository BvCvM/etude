package com.app.etude.etude.security.service;

import org.springframework.http.ResponseEntity;

import com.app.etude.etude.security.models.Response;
import com.app.etude.etude.security.models.User;
import com.app.etude.etude.security.models.VerificationToken;




public interface VerificationTokenService {
	
   void saveUserVerificationToken(User user, String token);
   String validateToken(String token);
   ResponseEntity<Response> verifyEmail(String token);
   VerificationToken generateNewVerificationToken(String oldToken);
}
