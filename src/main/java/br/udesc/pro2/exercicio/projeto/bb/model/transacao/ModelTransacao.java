package br.udesc.pro2.exercicio.projeto.bb.model.transacao;

import br.udesc.pro2.exercicio.projeto.bb.model.conta.IConta;
import br.udesc.pro2.exercicio.projeto.bb.model.conta.ModelConta;
import br.udesc.pro2.exercicio.projeto.bb.service.transacao.bo.ModelTransacaoBo;

public class ModelTransacao {

    private IConta contaDestino;

    private IConta contaOrigem;

    private double valor;

    public IConta getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(IConta contaDestino) {
        this.contaDestino = contaDestino;
    }

    public IConta getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(IConta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public static final class Builder {

        ModelTransacao entity;

        private Builder(ModelTransacao entity) {
            this.entity = entity;
        }

        public static Builder create() {
            return new Builder(new ModelTransacao());
        }

        public Builder contaOrigem(IConta contaOrigem) {
            this.entity.setContaOrigem(contaOrigem);
            return this;
        }

        public Builder contaDestino(IConta contaDestino) {
            this.entity.setContaDestino(contaDestino);
            return this;
        }

        public Builder valor(double valor) {
            this.entity.setValor(valor);
            return this;
        }

        public ModelTransacao build() {
            return entity;
        }

    }


}
