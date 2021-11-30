/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usa.ElMercader.repositorios.crud;

import usa.ElMercader.modelo.Client;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Camilo
 */
public interface ClienteCrudRepository extends CrudRepository<Client, Integer> {
    
    @Query(value = "Select e from Client e Where e.email = ?1 and e.password = ?2")
    public Optional<Client> findByEmailandPassword(String email, String password);
    
    //@Query(value = "Select e from Client e Where e.email = ?1)
    public Optional<Client> findByEmail(String email);
}
