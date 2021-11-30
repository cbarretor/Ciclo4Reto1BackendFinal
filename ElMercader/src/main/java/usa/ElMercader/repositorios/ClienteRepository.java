/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usa.ElMercader.repositorios;

import usa.ElMercader.modelo.Client;
import usa.ElMercader.repositorios.crud.ClienteCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Camilo
 */
@Repository
public class ClienteRepository {
    
    @Autowired
    private ClienteCrudRepository repo;
    
    public List<Client> getAll(){
        return (List<Client>) repo.findAll();
    }

    public Optional<Client> getByEmailAndPassword(String email, String password){
        return repo.findByEmailandPassword(email, password);
    }
    
    // Metodo para consulta de email puntual
    public Optional<Client> getByEmail(String email){
        return repo.findByEmail(email);
    }    

    public Optional<Client> getById(int id){
        return repo.findById(id);
    }
    
    public Client save(Client client){
        return repo.save(client);
    }
    
    public void delete(Client client){
        repo.delete(client);
    }
    
}
