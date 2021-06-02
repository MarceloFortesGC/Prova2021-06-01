package prova.tarefas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prova.tarefas.entity.Cliente;
import prova.tarefas.entity.Tarefa;
import prova.tarefas.repository.ClienteRepository;
import prova.tarefas.repository.TarefaRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TarefaRepository tarefaRepository;

    //  LISTANDO TODOS OS CLIENTES
    public List<Cliente> findAllClientes(){
        return clienteRepository.findAll();
    }

    //  POSTANDO  CLIENTE
    public String saveCliente(Cliente cliente){
        clienteRepository.save(cliente);
        return "Cliente criado com sucesso";
    }

    //  ATUALIZANDO CLIENTE
    public Cliente updateCliente(Long id, Cliente cliente){
        return clienteRepository.findById(id).map(updatedCliente -> {
            updatedCliente.setNome(cliente.getNome());
            
            //  ATUALIZAÇÃO DAS TAREFAS
            for(Tarefa tarefa: cliente.getTarefa()){
                Tarefa novaTarefa = tarefaRepository.findById(tarefa.getId()).get();
                novaTarefa.setCliente(updatedCliente);
                tarefaRepository.save(novaTarefa);
            }
            //  FIM DA ATUALIZAÇÃO DAS TAREFAS
            return clienteRepository.save(updatedCliente);
        }).orElseGet(() -> {
            cliente.setId(id);
            return clienteRepository.save(cliente);
        });
    }


    //  DELETANDO CLIENTE
    public String deleteCliente(Long id){
        clienteRepository.deleteById(id);
        return "Cliente deletado com sucesso";
    }
}
