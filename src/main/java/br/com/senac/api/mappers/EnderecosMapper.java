package br.com.senac.api.mappers;

import br.com.senac.api.dto.EnderecoResponse;
import br.com.senac.api.dto.EnderecosRequest;
import br.com.senac.api.entidades.Enderecos;

public class EnderecosMapper {

    public static Enderecos enderecosRequestToEndereco(EnderecosRequest enderecosRequest) {
        Enderecos out = new Enderecos();

        out.setId(enderecosRequest.getId());
        out.setLogradouro(enderecosRequest.getLogradouro());
        out.setCidade(enderecosRequest.getCidade());
        out.setEstado(enderecosRequest.getEstado());

        return out;
    }

    public static EnderecoResponse enderecosToEnderecosResponse (Enderecos enderecos) {
        EnderecoResponse out = new EnderecoResponse();

        out.setId(enderecos.getId());
        out.setLogradouro(enderecos.getLogradouro());
        out.setCidade(enderecos.getCidade());
        out.setEstado(enderecos.getEstado());

        return out;
    }
}
