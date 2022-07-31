package com.alkemy.disney.controller;

import com.alkemy.disney.models.Username;
import com.alkemy.disney.services.UsernameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping()
public class UsernameController {

    @Autowired
    private UsernameService usernameService;

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/listUser")
    private List<Username> getListUser() { return usernameService.getListUsername();}

    @GetMapping("/{id}")
    private Username geIdtUser(@PathVariable Long id){return usernameService.getUser(id);}


    //Register Username
    @PostMapping("/auth/register")
    private ResponseEntity<Object> register(@RequestParam String firstName, @RequestParam String lastName,

                                            @RequestParam String email, @RequestParam String password) throws MessagingException, UnsupportedEncodingException {

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()){

            return new ResponseEntity<>("To complete", HttpStatus.FORBIDDEN);
        }

        if (password.length() >=6){
            return new ResponseEntity<>("up to six characters", HttpStatus.FORBIDDEN);
        }

        Username newUsername = new Username(firstName, lastName, email, password);
        usernameService.saveUser(newUsername);
        sendVerificationEmail(newUsername);

        return new ResponseEntity<>("", HttpStatus.CREATED);
    }


    private void sendVerificationEmail(Username username)
            throws MessagingException, UnsupportedEncodingException {
        String toAddress = username.getEmail();
        String fromAddress = "motorideer@gmail.com";
        String senderName = "MotoRiderTeam";
        String subject = "Please verify your registration";
        String content = "<h2 style=\"color:black;\">Hi [[name]]!</h2>"
                + "<p style=\"color:black;\"> Please click the link below to verify your registration: </p>"
                +"<img src=\"https://assets.turbologo.com/blog/es/2019/08/19133135/disney-logo-castle.jpg\" alt=\"ImgRegister\" width=\"400\" height=\"250\"/> <br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\" style=\"color:#ff5e14;\">VERIFY YOUR ACCOUNT</a></h3>"
                + "<div style=\"display:flex;gap: 0.4rem;\"> <p style=\"color:black;\"> Thank you, </p> <p style=\"color:rgb(232, 91, 26);font-weight: bold;\"> Carolina, Gomez. </p> </div> "
                ;

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", username.getFirstName());


        helper.setText(content, true);
        mailSender.send(message);
    }

}
