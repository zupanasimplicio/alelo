package br.com.zup;

public enum  TiposDeCartaoBeneficio {

    VA {
        @Override
        public BeneficioCartaoNovo fabricar() {
            return new ValeAlimentação();
        }
    },
    VR {
        @Override
        public BeneficioCartaoNovo fabricar() {
            return new ValeRefeicao();
        }
    },
    VT {
        @Override
        public BeneficioCartaoNovo fabricar() {
            return new ValeCombustivel();
        }
    },

    MULTIBENEFICIOS {
        @Override
        public BeneficioCartaoNovo fabricar() {
             return MULTIBENEFICIOS.fabricar();
        }
    };

    abstract BeneficioCartaoNovo fabricar (); {

    }

}













