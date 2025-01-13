package br.com.alura.forumhub.domain.topicos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosListagemTopico(

        @NotNull  
        Integer id,
        @NotBlank String titulo,
        @NotBlank String mensagem,
        @NotBlank String datatopico,
        @NotBlank String statustopico,
        @NotBlank String autor,
        @NotNull Integer curso) {

        public DadosListagemTopico(Topico topico){
          this(topico.getId(),topico.getTitulo(),topico.getMensagem(),topico.getDatatopico(),topico.getStatustopico(),topico.getAutor(),topico.getCurso());
        }

}
