package br.com.alura.forumhub.domain.topicos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
   
    private String titulo;
    private String mensagem;
    private String datatopico;
    private String statustopico;
    private String autor;
    private Integer curso;
    private String respostas;

    public Topico(DadosTopico dados){
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.datatopico = dados.datatopico();
        this.statustopico = dados.statustopico();
        this.autor = dados.autor();
        this.curso = dados.curso();
        this.respostas = dados.respostas();
    }

    public void atualizarTopico(DadosAtualizacaoTopico dados){
        this.titulo = dados.titulo();
        
        if(dados.mensagem() != null){
         this.mensagem = dados.mensagem();
        }
        
        this.datatopico = dados.datatopico();
        this.statustopico = dados.statustopico();
        this.autor = dados.autor();        
    }


}
