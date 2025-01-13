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

import br.com.alura.forumhub.domain.topicos.DadosAtualizacaoTopico;
import br.com.alura.forumhub.domain.topicos.DadosDetailsTopico;
import br.com.alura.forumhub.domain.topicos.DadosListagemTopico;
import br.com.alura.forumhub.domain.topicos.DadosTopico;
import br.com.alura.forumhub.domain.topicos.Topico;
import br.com.alura.forumhub.repository.TopicoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity Insert(@RequestBody @Valid DadosTopico dados, UriComponentsBuilder uriBuilder) {
       var topico = new Topico(dados);
       repository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetailsTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> ListAll(@PageableDefault(size = 10, sort = { "datatopico" }) Pageable paginacao) {
        var pageDados = repository.findAll(paginacao).map(DadosListagemTopico::new);
        return  ResponseEntity.ok(pageDados);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity Update(@RequestBody @Valid DadosAtualizacaoTopico dados) {
       var topico = repository.getReferenceById(dados.id());
       topico.atualizarTopico(dados);

       return ResponseEntity.ok(new DadosDetailsTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity Delete(@PathVariable Integer id) {
       repository.deleteById(id);

       return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity details(@PathVariable Integer id) {
       var topico = repository.getReferenceById(id);

       return ResponseEntity.ok(new DadosDetailsTopico(topico));
   
    }

}