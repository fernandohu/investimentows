package br.com.fhu.investimento.ws.dto.rendimento.depositoinicialcommensal;

import br.com.fhu.investimento.ws.adapter.PorcentagemAdapter;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@XmlType(namespace = "calcularRendimentoDepositoInicialComMensalResposta")
public class Request {

    @XmlElement(required=true)
    Double depositoInicial;

    @XmlElement(required=true)
    Double depositoMensal;

    @XmlElement(required=false)
    Integer anos;

    @XmlElement(required=false)
    Integer meses;

    @XmlElement(required=false)
    @XmlJavaTypeAdapter(PorcentagemAdapter.class)
    Double porcentagemRendimento;

    @XmlElement(required=false)
    @XmlJavaTypeAdapter(PorcentagemAdapter.class)
    Double porcentagemInflacao;
}
