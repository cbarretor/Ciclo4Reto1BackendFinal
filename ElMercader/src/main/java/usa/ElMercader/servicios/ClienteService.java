/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usa.ElMercader.servicios;

import usa.ElMercader.modelo.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ElMercader.repositorios.ClienteRepository;

/**
 *
 * @author Camilo
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // FALTAN ALGUNOS METODOS DE VALIDACIÓN
    
    public List<Client> getAll() {
        return clienteRepository.getAll();
    }

    public Client getById(int id) {
        Optional<Client> client = clienteRepository.getById(id);
        return client.orElse(null);
    }

    public Client getByEmailAndPassword(String Email, String Password) {
        Optional<Client> client = clienteRepository.getByEmailAndPassword(Email, Password);
        if (client.isPresent()) {
            return client.get();
        } else {
            Client e = new Client();
            e.setEmail(Email);
            e.setPassword(Password);
            e.setName("NO DEFINIDO");
            return e;
        }
    }
    
    // Metodo para consulta especifica de email
    public boolean getByEmail(String Email) {
        Optional<Client> client = clienteRepository.getByEmail(Email);
        return client.isPresent();
    }    

    public Client save(Client client) {
        return clienteRepository.save(client);
    }

    public boolean delete(int id) {

        Boolean variable = clienteRepository.getById(id).map(client -> {
            clienteRepository.delete(client);
            return true;
        }).orElse(false);
        return variable;
    }

    public Client update(Client client) {
        if (client.getId() != null) {
            Optional<Client> consultado = clienteRepository.getById(client.getId());
            if (consultado.isPresent()) {
                if (client.getEmail() != null) {
                    consultado.get().setEmail(client.getEmail());
                }
                if (client.getPassword() != null) {
                    consultado.get().setPassword(client.getPassword());
                }
                return clienteRepository.save(consultado.get());
            }
        }
        return client;

    }
}
