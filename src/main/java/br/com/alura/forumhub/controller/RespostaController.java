package br.com.alura.forumhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forumhub.domain.respostas.DadosAtualizacaoResposta;
import br.com.alura.forumhub.domain.respostas.DadosDetailsResposta;
import br.com.alura.forumhub.domain.respostas.DadosListagemResposta;
import br.com.alura.forumhub.domain.respostas.DadosResposta;
import br.com.alura.forumhub.domain.respostas.Resposta;
import br.com.alura.forumhub.repository.RespostaRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/respostas")
public class RespostaController {

    @Autowired
    private RespostaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity Insert(@RequestBody @Valid DadosResposta dados, UriComponentsBuilder uriBuilder) {
       var reposta = new Resposta(dados);
       repository.save(reposta);

        var uri = uriBuilder.path("/respostas/{id}").buildAndExpand(reposta.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetailsResposta(reposta));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemResposta>> ListAll(@PageableDefault(size = 10, sort = { "dataresposta" }) Pageable paginacao) {
        var pageDados = repository.findAll(paginacao).map(DadosListagemResposta::new);
        return  ResponseEntity.ok(pageDados);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity Update(@RequestBody @Valid DadosAtualizacaoResposta dados) {
       var reposta = repository.getReferenceById(dados.id());
       reposta.atualizarResposta(dados);

       return ResponseEntity.ok(new DadosDetailsResposta(reposta));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity Delete(@PathVariable Integer id) {
       repository.deleteById(id);

       return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity details(@PathVariable Integer id) {
       var reposta = repository.getReferenceById(id);

       return ResponseEntity.ok(new DadosDetailsResposta(reposta));
   
    }

}