package com.endava.project.repositories;

import com.endava.project.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Optional<Client> findClientByUsername(String username);
    Optional<Client> findClientById(int id);
}
