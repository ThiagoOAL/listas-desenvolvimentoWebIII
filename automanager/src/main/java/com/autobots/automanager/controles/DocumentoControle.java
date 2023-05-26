package com.autobots.automanager.controles;

import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.modelo.DocumentoAtualizador;
import com.autobots.automanager.modelo.DocumentoSelecionador;
import com.autobots.automanager.repositorios.DocumentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documento")
public class DocumentoControle {

    @Autowired
    private DocumentoRepositorio repositorio;

    @Autowired
    private DocumentoSelecionador selecionador;

    @GetMapping("/documentos")
    public List<Documento> buscarDocumentos(){
        List<Documento> documentos = repositorio.findAll();
        return documentos;
    }

    @GetMapping("/documento/{id}")
    public Documento buscarDocumentoPorId(@PathVariable Long id){
        List<Documento> documento = repositorio.findAll();
        return selecionador.selecionar(documento, id);
    }

    @PostMapping("/documento")
    public void cadastrarDocumento(@RequestBody Documento documento) {
        repositorio.save(documento);
    }


    @PutMapping("/atualizar")
    public void atualizarDocumento(@RequestBody Documento atualizacao) {
        Documento documento = repositorio.getById(atualizacao.getId());
        DocumentoAtualizador atualizador = new DocumentoAtualizador();
        atualizador.atualizar(documento, atualizacao);
        repositorio.save(documento);
    }

    @DeleteMapping("/excluir")
    public void excluirDocumento(@RequestBody Documento exclusao) {
        Documento documento = repositorio.getById(exclusao.getId());
        repositorio.delete(documento);
    }
}
