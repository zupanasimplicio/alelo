package br.com.zup;

public class ValeRefeicao extends BeneficioCartaoNovo implements IBeneficioCartãoNovo{

    @Override
    public void comprar(Double valor) {
        this.saldo -= valor;
        this.saldo += valor * 0.02; // Estou voltando 2 % de cashback para o meu saldo
    }

    @Override
    public void mostrarSaldo() {

    }
}

