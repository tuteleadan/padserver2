package com.proiectpad2.controller;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.proiectpad2.domain.Comanda;
import com.proiectpad2.domain.User;
import com.proiectpad2.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;
import com.proiectpad2.domain.Comanda;
import com.proiectpad2.domain.Product;

import javax.mail.MessagingException;


import static org.springframework.web.bind.annotation.RequestMethod.POST;
//import java.util.List;


@CrossOrigin(origins = "https://padserver1.herokuapp.com")
@RestController
public class RegistrationController {

    @Autowired
    private NotificationService notificationService;

    @RequestMapping(value="/comenzi", method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void recComanda(@RequestBody Comanda cc) {

        User user = new User();
        user.setHtmlText(cc);
        user.setEmailAddress(cc.getUserEmail());


        if (user.getText() != null) {

        try {
            notificationService.sendHtmlNotification(user);
        }catch(MailException | MessagingException e){}

        }
    }


}