package br.com.fhu.investimento.ws.dto;

import br.com.fhu.investimento.ws.adapter.ValorAdapter;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Parcela {
    Integer parcela;

    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double amortizacao;

    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double juros;

    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double valorParcela;

    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double valorAbatido;

    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double saldoDevedor;

    ParcelaAcumulado acumulado;

    public Parcela() {
        acumulado = new ParcelaAcumulado();
    }

    public Parcela(int mes) {
        this.parcela = mes;
        this.acumulado = new ParcelaAcumulado();
    }
}
