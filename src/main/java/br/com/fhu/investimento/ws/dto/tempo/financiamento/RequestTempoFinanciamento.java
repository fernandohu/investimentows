package br.com.fhu.investimento.ws.dto.tempo.financiamento;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.fhu.investimento.ws.adapter.JurosAdapter;
import br.com.fhu.investimento.ws.adapter.TempoAdapter;
import br.com.fhu.investimento.ws.adapter.ValorAdapter;
import br.com.fhu.investimento.ws.dto.*;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@XmlType(namespace = "calcularTempoFinanciamento")
public class RequestTempoFinanciamento {
    @XmlElement(required=true)
    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double valorFinanciado;

    @XmlElement(required=true)
    @XmlJavaTypeAdapter(TempoAdapter.class)
    TempoDto tempo;

    @XmlElement(required=true)
    @XmlJavaTypeAdapter(JurosAdapter.class)
    JurosDto juros;

    @XmlElement(required=true)
    AbatimentoDto abatimento;

    @XmlElement(required=false, name="inflacaoEsperada")
    InflacaoDto inflacao;

    @XmlElement(required=false, name="correcaoMonetariaEsperada")
    CorrecaoMonetariaDto TR;
}
