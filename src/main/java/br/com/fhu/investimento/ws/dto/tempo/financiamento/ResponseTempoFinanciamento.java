package br.com.fhu.investimento.ws.dto.tempo.financiamento;

import java.util.List;

import br.com.fhu.investimento.ws.dto.MesFinanciamento;
import br.com.fhu.investimento.ws.dto.TempoDto;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class ResponseTempoFinanciamento {
    TempoDto tempoParaQuitar;
    
    Double amortizacao;
    
    RequestTempoFinanciamento originalRequest;
    
    List<MesFinanciamento> mes;
}
