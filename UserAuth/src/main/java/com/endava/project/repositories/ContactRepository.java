package com.endava.project.repositories;

import com.endava.project.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    List<Contact> findContactsByUsername(String username);
}
