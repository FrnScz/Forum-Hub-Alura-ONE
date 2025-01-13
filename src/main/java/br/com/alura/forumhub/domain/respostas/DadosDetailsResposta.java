package br.com.alura.forumhub.domain.respostas;

public record DadosDetailsResposta(
        Integer id,
        String mensagem,
        Integer titulo,
        String dataresposta,
        String autor,
        String resposta) {

    public DadosDetailsResposta(Resposta resp){
          this(resp.getId(),resp.getMensagem(),resp.getTitulo(),resp.getDataresposta(),resp.getAutor(),resp.getResposta());
        }

}
