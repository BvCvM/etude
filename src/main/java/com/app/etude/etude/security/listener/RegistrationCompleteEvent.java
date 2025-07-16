package com.app.etude.etude.security.listener;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import lombok.Setter;
import com.app.etude.etude.security.models.User;




@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {
   private User user;
   private String applicationUrl;


   public RegistrationCompleteEvent(User user, String applicationUrl) {
       super(user);
       this.user = user;
       this.applicationUrl = applicationUrl;
   }
}

