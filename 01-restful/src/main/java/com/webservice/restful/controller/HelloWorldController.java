package com.webservice.restful.controller;

import com.webservice.restful.model.HelloWorldBean;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/message")
    public String getMessage() {
        return "Hello World!";
    }

    @GetMapping("/message/{name}")
    public String getMessageWithName(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/bean/{message}")
    public HelloWorldBean getMessageBean(@PathVariable String message) {
        return new HelloWorldBean(message);
    }

    @GetMapping("/message-i18n")
    public String getMessageInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",
                null,
                "Default Message",
                locale);
    }

}
