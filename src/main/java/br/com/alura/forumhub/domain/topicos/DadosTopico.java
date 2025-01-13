package br.com.alura.forumhub.domain.topicos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosTopico(
    Integer id, 

    @NotBlank
    String titulo, 
    @NotBlank
    String mensagem, 
    @NotBlank
    String datatopico, 
    @NotBlank
    String statustopico,
    @NotBlank 
    String autor,
    
    @NotNull
    Integer curso, 
    @NotBlank
    String respostas) {

}
