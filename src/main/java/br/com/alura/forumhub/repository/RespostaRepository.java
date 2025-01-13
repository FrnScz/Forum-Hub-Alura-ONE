package br.com.alura.forumhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.alura.forumhub.domain.respostas.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Integer> {

}