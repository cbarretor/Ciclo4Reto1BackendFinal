/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usa.ElMercader.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import usa.ElMercader.modelo.Client;
import usa.ElMercader.servicios.ClienteService;

/**
 *
 * @author Camilo
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class ClienteController {
    
    // FALTAN METODOS ADICIONALES

    @Autowired
    private ClienteService service;

    // CONSULTA GET ALL
    @GetMapping("/all")
    private List<Client> getAll() {
        return service.getAll();
    }

    // CONSULTA EMAIL-PASSWORD
    @GetMapping("/{email}/{password}")
    private Client getByEmail(@PathVariable("email") String email, @PathVariable("password") String password) {
        return service.getByEmailAndPassword(email, password);
    }
    
    // CONSULTA EMAIL
    @GetMapping("/{email}")
    private boolean getByEmail(@PathVariable("email") String email) {
        return service.getByEmail(email);
    }  
    
    // CONSULTA PASSWORD
    //@GetMapping("/{password}")
    //private Client getByPassword(@PathVariable("email") String email, @PathVariable("password") String password) {
        //return service.getByEmailAndPassword(email, password);
    //}    

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client) {
        return service.save(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client) {
        return service.update(client);
    }

}

