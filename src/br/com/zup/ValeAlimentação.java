package br.com.zup;

public class  ValeAlimentação extends BeneficioCartaoNovo implements IBeneficioCartãoNovo{

    @Override
    public void comprar(Double valor) {
        this.saldo -= valor;
        this.saldo += valor * 0.03; // Estou voltando 0.3 % de cashback para o meu saldo
    }

    @Override
    public void mostrarSaldo() {
    }
}






