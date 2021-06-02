package prova.tarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import prova.tarefas.entity.Cliente;
import prova.tarefas.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    //  ENCONTRANDO TODOS OS CLIENTES
    @GetMapping("/")
    public List<Cliente>findAllClientes(){
        return clienteService.findAllClientes();
    }

    //  POSTANDO CLIENTE
    @PostMapping("/")
    public Cliente novoCliente(@RequestBody Cliente cliente){
        clienteService.saveCliente(cliente);
        return cliente;
    }

    //  ATUALIZANDO CLIENTE
    @PutMapping("/{id}")
    public Cliente updatCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        return clienteService.updateCliente(id, cliente);
    }

    //  DELETANDO CLIENTE
    @DeleteMapping("/{id}")
    public String deleteCliente(@PathVariable Long id){
        return clienteService.deleteCliente(id);
    }
}
