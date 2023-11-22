package br.com.senac.api.dto;

import java.time.LocalDate;
import java.util.List;

public class ClientesRequest {

    private String nome;

    private LocalDate dataNascimento;

    private String sobrenome;

    private String email;

    private String telefone;

    private List<EnderecosRequest> enderecos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<EnderecosRequest> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecosRequest> enderecos) {
        this.enderecos = enderecos;
    }
}
