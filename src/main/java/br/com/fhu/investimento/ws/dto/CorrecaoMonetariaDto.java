package br.com.fhu.investimento.ws.dto;

import br.com.fhu.investimento.ws.adapter.PorcentagemAdapter;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class CorrecaoMonetariaDto {
    @XmlElement(required=false)
    @XmlJavaTypeAdapter(PorcentagemAdapter.class)
    Double anual;

    @XmlElement(required=false)
    @XmlJavaTypeAdapter(PorcentagemAdapter.class)
    Double mensal;

    public CorrecaoMonetariaDto() {

    }
}
