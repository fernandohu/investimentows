package br.com.fhu.investimento.ws.dto.tempo.financiamento;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.fhu.investimento.ws.adapter.ValorAdapter;
import br.com.fhu.investimento.ws.dto.AbatimentoDto;
import br.com.fhu.investimento.ws.dto.JurosDto;
import br.com.fhu.investimento.ws.dto.TempoDto;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class RequestTempoFinanciamento {
    @XmlElement(required=true)
    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double valorFinanciado;
   
    TempoDto tempo;
    
    JurosDto juros;
  
    AbatimentoDto abatimento;
}
