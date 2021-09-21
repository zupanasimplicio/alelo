package br.com.zup;

public class EstabelecimentoComercial {
    private String nome;
    private Integer indentificador;
    private String tipo;
    private String estado;

    public EstabelecimentoComercial(String nome, Integer indentificador, String tipo,String estado){
        this.nome = nome;
        this.indentificador = indentificador;
        this.tipo = tipo;
        this.estado= estado;
    }

}
