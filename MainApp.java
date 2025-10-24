package com.seuprojeto.app.app;

import com.seuprojeto.app.model.Client;
import com.seuprojeto.app.repository.InMemoryClientRepository;
import com.seuprojeto.app.service.ClientService;

public class MainApp {
    public static void main(String[] args) {
        InMemoryClientRepository repo = new InMemoryClientRepository();
        ClientService service = new ClientService(repo);

        System.out.println("=== Teste de Cadastro de Clientes ===");

        // Criar clientes
        Client c1 = service.createClient("Ana Silva", "ana@example.com");
        Client c2 = service.createClient("João Souza", "joao@example.com");

        System.out.println("\nClientes cadastrados:");
        service.listClients().forEach(System.out::println);

        // Atualizar cliente
        service.updateClient(c1.getId(), "Ana Maria", "ana.maria@example.com");
        System.out.println("\nDepois da atualização:");
        service.listClients().forEach(System.out::println);

        // Buscar por ID
        System.out.println("\nBusca por ID 2:");
        service.getClient(2L).ifPresent(System.out::println);

        // Excluir cliente
        service.deleteClient(c2.getId());
        System.out.println("\nDepois de excluir João:");
        service.listClients().forEach(System.out::println);
    }
}
