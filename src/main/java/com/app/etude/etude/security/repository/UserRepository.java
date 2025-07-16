package com.app.etude.etude.security.repository;

import java.util.List;
import java.util.Optional;
import com.app.etude.etude.security.models.User; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;



import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
	   boolean existsByEmail(String email);
	   Optional<User>  findByEmail(String email);
	   @Modifying
	   @Transactional
	   @Query("update User u set u.password = ?2 where u.email = ?1 ")
	  void updatePassword(String email, String password);
	   /*  @Query("select u from User u where u.role = ?1 ")
	   List<User> listusersByRole(Role role);*/
	   
	} 

