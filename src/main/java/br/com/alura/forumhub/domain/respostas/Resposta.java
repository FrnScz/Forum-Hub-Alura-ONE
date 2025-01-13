package br.com.alura.forumhub.domain.respostas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "respostas")
@Entity(name = "Resposta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
   
    private String mensagem;
    private Integer titulo;
    private String dataresposta;
    private String autor;
    private String resposta;

    public Resposta(DadosResposta dados){
        this.mensagem = dados.mensagem();
        this.titulo = dados.titulo();
        this.dataresposta = dados.dataresposta();
        this.autor = dados.autor();
        this.resposta = dados.resposta();
    }

    public void atualizarResposta(DadosAtualizacaoResposta dados){
        
        if(dados.mensagem() != null){
         this.mensagem = dados.mensagem();
        }
        
        this.dataresposta = dados.dataresposta();
        this.titulo = dados.titulo();
        this.autor = dados.autor(); 
        this.resposta = dados.resposta();
              
    }


}
