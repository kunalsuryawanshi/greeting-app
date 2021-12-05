package com.bridgelabz.greetingapp.controller;
/**
 * Purpose To Simulate with Greeting App
 *
 * @author Kunal Suryawasnhi
 * @version 2.6.0
 * @since 05-12-2021
 */

import com.bridgelabz.greetingapp.dto.GreetingDto;
import com.bridgelabz.greetingapp.dto.UserDto;
import com.bridgelabz.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingAppController {
    private static final String template = "Hello %s!";

    @Autowired
    private GreetingService greetingService;

    @RequestMapping(value = {"", "/"})
    @ResponseBody
    public String home() {
        return "Hello World!";
    }

    //http://localhost:8080/greeting?firstName=Kunal&lastName=Suryawanshi
    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "firstName", defaultValue = "") String firstName,
                           @RequestParam(value = "lastName", defaultValue = "") String lastName) {
        if (firstName == null && lastName == null) {
            home();
        }
        return String.format(template, firstName + " " + lastName);
    }

    //http://localhost:8080/add-greeting
    @PostMapping("/add-greeting")
    public String addGreeting(@RequestBody UserDto user) {
        String message = String.format(template, user.getFirstName() + " " + user.getLastName());
        GreetingDto greetingDto = new GreetingDto();
        greetingDto.setMessage(message);
        return greetingService.addMessage(greetingDto);
    }

    //http://localhost:8080/findBy/1
    @GetMapping("/findBy/{id}")
    public Object findGreeting(@PathVariable(value = "id") int id) {
        return greetingService.findMessageById(id);
    }

    //http://localhost:8080/get-all
    @GetMapping("/get-all")
    public Object getAllMessages() {
        return greetingService.getAllMessages();
    }

    //http://localhost:8080/update-message/3
    @PutMapping("/update-message/{id}")
    public Object updateMessage(@PathVariable(value = "id") int id, @RequestBody GreetingDto greetingDto) {
        return greetingService.updateMessage(id, greetingDto);
    }

    //http://localhost:8080/delete-message/2
    @DeleteMapping("/delete-message/{id}")
    public Object deleteMessage(@PathVariable(value = "id") int id) {
        return greetingService.deleteMessage(id);
    }
}
