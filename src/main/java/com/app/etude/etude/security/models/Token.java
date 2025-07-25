package com.app.etude.etude.security.models;

import com.app.etude.etude.models.TokenType;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token {


 @Id
 @GeneratedValue
 public Integer id;


 @Column(unique = true,length = 500)
 public String token;


 @Enumerated(EnumType.STRING)
 @Builder.Default
 public TokenType tokenType = TokenType.BEARER;


 public boolean revoked;


 public boolean expired;


 @ManyToOne(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
 @JoinColumn(name = "user_id" )
 public User user;
}

