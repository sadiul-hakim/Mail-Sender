package org.mailsender.controller;

import org.mailsender.pojo.Mail;
import org.mailsender.service.MailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/mail/v1")
public class MailController {
    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/send")
    public ResponseEntity<?> send(@RequestParam String toMail, @RequestBody Mail mail){
        var send = mailService.send(toMail,mail);
        return ResponseEntity.ok(Collections.singletonMap("message",STR."Mail is sent successfully : \{send}"));
    }
}
