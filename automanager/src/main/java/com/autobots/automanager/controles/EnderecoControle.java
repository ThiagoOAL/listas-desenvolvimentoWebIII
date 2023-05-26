package com.autobots.automanager.controles;

import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.modelo.EnderecoAtualizador;
import com.autobots.automanager.modelo.EnderecoSelecionador;
import com.autobots.automanager.repositorios.EnderecoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Endereco")
public class EnderecoControle{
    @Autowired
    private EnderecoRepositorio repositorio;

    @Autowired
    private EnderecoSelecionador selecionador;

    @GetMapping("/enderecos")
    public List<Endereco> buscarEnderecos(){
        List<Endereco> enderecos = repositorio.findAll();
        return enderecos;
    }

    @GetMapping("/endereco/{id}")
    public Endereco buscarEnderecoPorId(@PathVariable Long id){
        List<Endereco> endereco = repositorio.findAll();
        return selecionador.selecionar(endereco, id);
    }

    @PostMapping("/endereco")
    public void cadastrarEndereco(@RequestBody Endereco endereco) {
        repositorio.save(endereco);
    }


    @PutMapping("/endereco")
    public void atualizarTelefone(@RequestBody Endereco atualizacao) {
        Endereco endereco = repositorio.getById(atualizacao.getId());
        EnderecoAtualizador atualizador = new EnderecoAtualizador();
        atualizador.atualizar(endereco, atualizacao);
        repositorio.save(endereco);
    }

    @DeleteMapping("/excluir")
    public void excluirDocumento(@RequestBody Endereco exclusao) {
        Endereco endereco = repositorio.getById(exclusao.getId());
        repositorio.delete(endereco);
    }
}
