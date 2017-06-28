package br.com.fhu.investimento.ws.dto.rendimento.depositounico;

import br.com.fhu.investimento.ws.adapter.ValorAdapter;
import br.com.fhu.investimento.ws.dto.RendimentoMensalDto;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@XmlType(namespace = "calcularRendimentoDepositoUnicoResposta")
public class Response {

    @XmlElement(required=true)
    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double depositoInicial;

    @XmlElement(required=true)
    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double valorAcumulado;

    @XmlElement(required=true)
    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double inflacaoAcumulada;

    @XmlElement(required=true)
    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double valorAcumuladoMenosInflacaoAcumulada;

    @XmlElement(required=true)
    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double valorAcumuladoCorrigidoInflacao;

    @XmlElement(required=true)
    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double rendimentoReal;

    @XmlElement(required=false)
    Integer anos;

    @XmlElement(required=false)
    Integer meses;

    @XmlElement(required=false)
    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double porcentagemRendimentoAnual;

    @XmlElement(required=false)
    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double porcentagemRendimentoMensal;

    @XmlElement(required=false)
    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double porcentagemInflacaoAnual;

    @XmlElement(required=false)
    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double porcentagemInflacaoMensal;

    List<RendimentoMensalDto> mes;
}
