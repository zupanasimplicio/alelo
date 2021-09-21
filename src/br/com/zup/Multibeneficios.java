package br.com.zup;

public class Multibeneficios extends BeneficioCartaoNovo implements IBeneficioCartãoNovo{

    @Override
    public void comprar(Double valor) {
        this.saldo -= valor;
        this.saldo += valor * 0.4; // Estou voltando 0.4 % de cashback para o meu saldo
    }

    @Override
    public void mostrarSaldo() {
    }
}

