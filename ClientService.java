package com.seuprojeto.app.service;

import com.seuprojeto.app.model.Client;
import com.seuprojeto.app.repository.ClientRepository;
import java.util.List;
import java.util.Optional;

public class ClientService {
    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public Client createClient(String name, String email) {
        validateName(name);
        validateEmail(email);
        Client client = new Client(null, name.trim(), email.trim());
        return repository.save(client);
    }

    public Client updateClient(Long id, String name, String email) {
        if (!repository.findById(id).isPresent()) {
            throw new IllegalArgumentException("Cliente não encontrado para id: " + id);
        }
        validateName(name);
        validateEmail(email);
        Client client = new Client(id, name.trim(), email.trim());
        return repository.save(client);
    }

    public List<Client> listClients() {
        return repository.findAll();
    }

    public Optional<Client> getClient(Long id) {
        return repository.findById(id);
    }

    public void deleteClient(Long id) {
        repository.deleteById(id);
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
    }

    private void validateEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
    }
}
