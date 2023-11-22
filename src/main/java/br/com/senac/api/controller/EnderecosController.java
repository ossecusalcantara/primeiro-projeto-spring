package br.com.senac.api.controller;

import br.com.senac.api.entidades.Clientes;
import br.com.senac.api.entidades.Enderecos;
import br.com.senac.api.repositorios.EnderecosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/enderecos")
public class EnderecosController {

    @Autowired
    private EnderecosRepository enderecosRepository;

    @GetMapping("/")
    @CrossOrigin
    public ResponseEntity<List<Enderecos>> carregarEnderecos() {
        List<Enderecos> retorn = enderecosRepository.findAll();

        return ResponseEntity.ok().body(retorn);
    }

    @PostMapping("/")
    @CrossOrigin
    public ResponseEntity<Enderecos> criarEndereco(@RequestBody Enderecos endereco) {
        Enderecos retorno = enderecosRepository.save(endereco);

        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Enderecos> deleteEndereco(@PathVariable Long id) {
        enderecosRepository.deleteById(id);

        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Enderecos> atualizarEndereco(@PathVariable Long id, @RequestBody Enderecos endereco) {
        Enderecos retorno = enderecosRepository.findById(id).map(record -> {
            record.setLogradouro(endereco.getLogradouro());
            record.setBairro(endereco.getBairro());
            record.setCidade(endereco.getCidade());
            record.setEstado(endereco.getEstado());
            return enderecosRepository.save(record);
        }).get();

        return ResponseEntity.ok(retorno);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Enderecos> carregarEndereco(@PathVariable Long id) {
        Enderecos retorno = enderecosRepository.findById(id).get();
        return ResponseEntity.ok().body(retorno);
    }

}
