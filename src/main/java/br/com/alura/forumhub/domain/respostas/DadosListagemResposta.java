package br.com.alura.forumhub.domain.respostas;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosListagemResposta(
        @NotNull  
        Integer id,
        @NotBlank String mensagem,
        @NotNull Integer titulo, 
        @NotBlank String dataresposta,
        @NotBlank String autor,
        @NotBlank String resposta) {

        public DadosListagemResposta(Resposta resposta){
          this(resposta.getId(),resposta.getMensagem(),resposta.getTitulo(),resposta.getDataresposta(),resposta.getAutor(),resposta.getResposta());
        }
}
