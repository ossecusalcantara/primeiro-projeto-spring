package br.com.senac.api.mappers;

import br.com.senac.api.dto.ClientesRequest;
import br.com.senac.api.dto.ClientesResponse;
import br.com.senac.api.dto.EnderecoResponse;
import br.com.senac.api.entidades.Clientes;
import br.com.senac.api.entidades.Enderecos;

import java.util.ArrayList;
import java.util.List;

public class ClientesMapper {

    public static Clientes clientesResquestToClientes(ClientesRequest clientesRequest) {
        Clientes out = new Clientes();

        out.setNome(clientesRequest.getNome());
        out.setSobrenome(clientesRequest.getSobrenome());
        out.setEmail(clientesRequest.getEmail());
        out.setTelefone(clientesRequest.getTelefone());
        out.setDataNascimento(clientesRequest.getDataNascimento());

        List<Enderecos> enderecosList = clientesRequest.getEnderecos().stream().map(EnderecosMapper :: enderecosRequestToEndereco).toList();
        out.setEnderecos(enderecosList);

        return out;
    }

    public static ClientesResponse clientesToClientesResponse(Clientes clientes) {
        ClientesResponse out = new ClientesResponse();

        out.setNome(clientes.getNome());
        out.setSobrenome(clientes.getSobrenome());
        out.setEmail(clientes.getEmail());
        out.setTelefone(clientes.getTelefone());
        out.setDataNascimento(clientes.getDataNascimento());

        List<EnderecoResponse> enderecosResponseList = clientes.getEnderecos().stream().map(EnderecosMapper :: enderecosToEnderecosResponse).toList();
        out.setEnderecos(enderecosResponseList);

        return out;
    }
}
