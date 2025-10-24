package com.seuprojeto.app.repository;

import com.seuprojeto.app.model.Client;
import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    Client save(Client client);
    Optional<Client> findById(Long id);
    List<Client> findAll();
    void deleteById(Long id);
    void clear();
}
