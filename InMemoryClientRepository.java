package com.seuprojeto.app.repository;

import com.seuprojeto.app.model.Client;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryClientRepository implements ClientRepository {
    private final Map<Long, Client> storage = new HashMap<>();
    private final AtomicLong idGen = new AtomicLong(0);

    @Override
    public Client save(Client client) {
        if (client.getId() == null) {
            client.setId(idGen.incrementAndGet());
        }
        storage.put(client.getId(), new Client(client.getId(), client.getName(), client.getEmail()));
        return client;
    }

    @Override
    public Optional<Client> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Client> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }

    @Override
    public void clear() {
        storage.clear();
        idGen.set(0);
    }
}
