package com.autobots.automanager.modelo;

import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.entidades.Telefone;

import java.util.List;

public class EnderecoSelecionador {

    public Endereco selecionar(List<Endereco> enderecos, long id) {
        Endereco selecionado = null;
        for (Endereco endereco : enderecos) {
            if (endereco.getId() == id) {
                selecionado = endereco;
            }
        }
        return selecionado;
    }

}
