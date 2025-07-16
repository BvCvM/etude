package com.app.etude.etude.security.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.etude.etude.dto.Agentadministratifdto;
import com.app.etude.etude.dto.Elevedto;
import com.app.etude.etude.dto.Parentdto;
import com.app.etude.etude.dto.Professeurdto;
import com.app.etude.etude.security.models.Response;
import com.app.etude.etude.security.service.UserService;

import java.io.IOException;
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
  private final AuthenticationService service;
  private final UserService userService;
  @PostMapping("/register")
  public ResponseEntity<Response> register(
          @RequestBody @Valid RegisterRequest userRequest,
          HttpServletRequest request
  )  {
    return service.register(userRequest,request);
  }
  @PostMapping("/registerelve")
  public ResponseEntity<Response> registerelve(
          @RequestBody @Valid Elevedto userRequest,
          HttpServletRequest request
  )  {
    return service.register(userRequest,request);
  }
  
  @PostMapping("/registerprofesseur")
  public ResponseEntity<Response> registerprofesseur(
          @RequestBody @Valid Professeurdto userRequest,
          HttpServletRequest request
  )  {
    return service.register(userRequest,request);
  }
  
  @PostMapping("/registerparent")
  public ResponseEntity<Response> registerparent(
          @RequestBody @Valid Parentdto userRequest,
          HttpServletRequest request
  )  {
    return service.register(userRequest,request);
  }
  
  @PostMapping("/registeradmin")
  public ResponseEntity<Response> registeradmin(
          @RequestBody @Valid Agentadministratifdto userRequest,
          HttpServletRequest request
  )  {
    return service.register(userRequest,request);
  }
  
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }
  @PostMapping("/refresh-token")
  public void refreshToken(
      HttpServletRequest request,
      HttpServletResponse response
  ) throws IOException {
    service.refreshToken(request, response);
  }

  /*@GetMapping("/listvendeurs")
  public List<UserDto> getlistvendeurs(ModeleRole role) {
      return  userService.listvendeur(role);
  }*/
  
  

}
