package com.app.etude.etude.security.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.etude.etude.security.models.Role;
import com.app.etude.etude.security.models.Token;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name="user")
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="vehicule_type")
public class User implements UserDetails {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   @Column(length = 20)
   private String firstName;
   @Column(length = 20)
   private String lastName;
   @Column(unique = true)
   private String email;
   @Column
   private String password;
   @Column

   private String adress;
   @Column
   private String phone;

    @Builder.Default
    private boolean enabled = false;
	 @ManyToMany(fetch =FetchType.EAGER)
	   private List<Role> roles;
	  @OneToMany(mappedBy ="user",cascade = CascadeType.ALL)

	     private List<Token> tokens;
      @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	    private VerificationToken verificationToken;
	@Override
	   public Collection<? extends GrantedAuthority> getAuthorities() {
	       return this.roles
	               .stream()
	               .map(role -> new SimpleGrantedAuthority(role.getName()))
	               .collect(Collectors.toList());
	   }

    
  
  


   


   @Override
   public String getPassword() {
      return password;
   }


   @Override
   public String getUsername() {
      return email;
   }


   @Override //annotation pour redefinir la methode (de la part d une classe ou interface )
   public boolean isAccountNonExpired() { //return oui si le compte exist toujours 
      return true;
   }


   @Override
   public boolean isAccountNonLocked() {
      return true;
   }


   @Override
   public boolean isCredentialsNonExpired() { // return oui si le mot de passe toujours valide
      return true;
   }


   @Override
   public boolean isEnabled() { // return oui si le compte est toujours active 
      return enabled;
   }


}
