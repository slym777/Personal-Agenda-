package com.endava.project.controllers;

import com.endava.project.entities.Client;
import com.endava.project.entities.Contact;
import com.endava.project.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    
    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping("/hello")
    public String hello(Principal principal){
        return principal.getName();
    }

    @GetMapping("/myInfo")
    public Client myInfo(){
        return clientService.getMyInfo().get();
    }

    @GetMapping("/myContacts")
    public List<Client> mycontacts(){
        return clientService.getMyContacts();
    }

    @PostMapping("/addContact")
    public void addNewContact(@RequestBody Contact contact){
        clientService.addNewContact(contact);
    }

    @PostMapping("/deleteContact/{id}")
    public void deleteContact(@PathVariable int id){
        clientService.deleteContact(id);
    }
}
