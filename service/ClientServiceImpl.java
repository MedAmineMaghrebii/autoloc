package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Client;
import tn.esprit.autoloc.repository.IClientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ServiceI<Client> {

    private final IClientRepository clientRepository;

    @Override
    public List<Client> retrieveAll() {
        log.info("Récupération de tous les clients");
        return clientRepository.findAll();
    }

    @Override
    public Client retrieveById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client introuvable : id=" + id));
    }

    @Override
    public Client add(Client entity) {
        return clientRepository.save(entity);
    }

    @Override
    public Client update(Client entity) {

        return clientRepository.save(entity);
    }

    @Override
    public void remove(Long id) {

        clientRepository.deleteById(id);
    }
}