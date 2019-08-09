package com.endava.project.services;

import com.endava.project.entities.Client;
import com.endava.project.entities.Contact;
import com.endava.project.repositories.ClientRepository;
import com.endava.project.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;
    private ContactRepository contactsRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, ContactRepository contactsRepository){
        this.clientRepository = clientRepository;
        this.contactsRepository = contactsRepository;
    }

    public Optional<Client> getMyInfo(){
        return clientRepository.findClientByUsername(
                ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
    }

    public List<Client> getMyContacts(){
        List<Contact> contacts = contactsRepository.findContactsByUsername(
                ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        List<Client> clients = new ArrayList<>();
        contacts.forEach( p -> clients.add(clientRepository.findClientByUsername(p.getContact()).get()));

        return clients;
    }

    public void addNewContact(Contact contact){
        if(clientRepository.findClientByUsername(contact.getContact()).isPresent()) {
            contact.setUsername(((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
            contactsRepository.save(contact);
        } else {
            
        }
    }
}
