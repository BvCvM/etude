package com.app.etude.etude.security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service //indiquer que la classe est service
public class JwtService {


 //@Value("${application.security.jwt.secret-key}") //injection
 private String secretKey="404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970"; //cle pour signer le token 
// @Value("${application.security.jwt.expiration}")
 private long jwtExpiration=864000000; //date d'expiration dans 10j
 
// @Value("${application.security.jwt.refresh-token.expiration}")
 private long refreshExpiration=604800000; //acctualiser 

//pour recuperer les emails ou l'utilisateur depuis le token
 public String extractUsername(String token) { 
   return extractClaim(token, Claims::getSubject);
 }

//permet de recuperer peut n'import token
 public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
   final Claims claims = extractAllClaims(token);
   return claimsResolver.apply(claims);
 }

//permet de generer le token
 public String generateToken(UserDetails userDetails) {
   return generateToken(new HashMap<>(), userDetails); //generer l'actualisation de token 
 }


 public String generateToken(
     Map<String, Object> extraClaims,
     UserDetails userDetails
 ) {
   return buildToken(extraClaims, userDetails, jwtExpiration); 
 }


 public String generateRefreshToken(
     UserDetails userDetails
 ) {
   return buildToken(new HashMap<>(), userDetails, refreshExpiration);
 }

//constuction de token 
 private String buildToken(
         Map<String, Object> extraClaims,
         UserDetails userDetails,
         long expiration
 ) {
   return Jwts
           .builder()
           .setClaims(extraClaims)
           .claim("authorities", userDetails.getAuthorities())
           .setSubject(userDetails.getUsername())
           .setIssuedAt(new Date(System.currentTimeMillis()))
           .setExpiration(new Date(System.currentTimeMillis() + expiration))
           .signWith(getSignInKey(), SignatureAlgorithm.HS256)
           .compact();
 }


 public boolean isTokenValid(String token, UserDetails userDetails) {
   final String username = extractUsername(token);
   return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
 }


 private boolean isTokenExpired(String token) {
   return extractExpiration(token).before(new Date());
 }


 private Date extractExpiration(String token) {
   return extractClaim(token, Claims::getExpiration);
 }


 private Claims extractAllClaims(String token) {
   return Jwts
       .parserBuilder()
       .setSigningKey(getSignInKey())
       .build()
       .parseClaimsJws(token)
       .getBody();
 }


 private Key getSignInKey() {//fornier la cle de de la signature 
   byte[] keyBytes = Decoders.BASE64.decode(secretKey);
   return Keys.hmacShaKeyFor(keyBytes);//verfication que le token n est pas experer 
 }
}

