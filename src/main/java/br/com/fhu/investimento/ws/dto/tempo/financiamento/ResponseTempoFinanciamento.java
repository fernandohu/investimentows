package br.com.fhu.investimento.ws.dto.tempo.financiamento;

import java.util.ArrayList;
import java.util.List;

import br.com.fhu.investimento.ws.adapter.ValorAdapter;
import br.com.fhu.investimento.ws.dto.Parcela;
import br.com.fhu.investimento.ws.dto.TempoDto;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@XmlType(namespace = "calcularTempoFinanciamentoResposta")
public class ResponseTempoFinanciamento {
    TempoDto tempoParaQuitar;

    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double amortizacao;

    List<Parcela> parcela;

    RequestTempoFinanciamento originalRequest;

    public ResponseTempoFinanciamento() {
        parcela = new ArrayList<>();
    }
}
