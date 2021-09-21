package br.com.zup;

public class ValeCombustivel extends BeneficioCartaoNovo implements IBeneficioCartãoNovo{

    @Override
    public void comprar(Double valor) {
        this.saldo -= valor;
        this.saldo -=100.00;
    }

    @Override
    public void mostrarSaldo() {

    }
}

