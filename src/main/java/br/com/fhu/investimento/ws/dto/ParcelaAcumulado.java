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
public class ParcelaAcumulado {

    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double totalPago;

    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double totalJurosPago;

    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double totalPagoComJuros;

    public ParcelaAcumulado() {

    }
}
