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
public class RendimentoMensalDto {

    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double valorAtual;

    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double rendimentoMensal;

    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double inflacaoAcumulada;

    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double inflacaoMensal;

    String periodo;
}
