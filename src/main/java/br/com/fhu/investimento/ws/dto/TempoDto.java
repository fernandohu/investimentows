package br.com.fhu.investimento.ws.dto;

import br.com.fhu.investimento.ws.adapter.ValorAdapter;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class TempoDto {
    @XmlElement(required=false)
    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double meses;
    
    @XmlElement(required=false)
    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double anos;

    public TempoDto() {

    }

    public TempoDto(Double meses, Double anos) {
        this.meses = meses;
        this.anos = anos;
    }
}
