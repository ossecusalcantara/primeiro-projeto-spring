package br.com.senac.api.controller;

import br.com.senac.api.dto.ClientesRequest;
import br.com.senac.api.dto.ClientesResponse;
import br.com.senac.api.entidades.Clientes;
import br.com.senac.api.mappers.ClientesMapper;
import br.com.senac.api.repositorios.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClientesRepository clientesRepository;

    @GetMapping("/")
    @CrossOrigin
    public ResponseEntity<List<ClientesResponse>> carregarClientes() {
        List<Clientes> retorno = clientesRepository.findAll();

        List<ClientesResponse> out = retorno.stream().map(ClientesMapper :: clientesToClientesResponse).toList();

        return ResponseEntity.ok().body(out);
    }

    @PostMapping("/")
    @CrossOrigin
    public ResponseEntity<ClientesResponse> criarCliente(@RequestBody ClientesRequest cliente) {
        Clientes retorno = clientesRepository.save(ClientesMapper.clientesResquestToClientes(cliente));

        return ResponseEntity.status(HttpStatus.CREATED).body(ClientesMapper.clientesToClientesResponse(retorno));
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clientesRepository.deleteById(id);
        
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<ClientesResponse> atualizarCliente(@PathVariable Long id, @RequestBody ClientesRequest cliente) {
        Clientes retorno = clientesRepository.findById(id).map(record -> {
            record.setNome(cliente.getNome());
            record.setSobrenome(cliente.getSobrenome());
            record.setDataNascimento(cliente.getDataNascimento());
            record.setEmail(cliente.getEmail());
            record.setTelefone(cliente.getTelefone());
            return clientesRepository.save(record);
        }).get();

        ClientesResponse out = ClientesMapper.clientesToClientesResponse(retorno);
        return ResponseEntity.ok(out);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public  ResponseEntity<ClientesResponse> carregarClienteById(@PathVariable Long id) {
        Clientes retorno = clientesRepository.findById(id).get();

        ClientesResponse out = ClientesMapper.clientesToClientesResponse(retorno);
        return ResponseEntity.ok().body(out);
    }

    @GetMapping("/{nome}/buscar")
    public ResponseEntity<List<ClientesResponse>> carregarClientesByNome(@PathVariable String nome) {
        List<Clientes> retorno = clientesRepository.findByNome(nome);

        List<ClientesResponse> out = retorno.stream().map(ClientesMapper :: clientesToClientesResponse).toList();
        return ResponseEntity.ok(out);
    }

}
