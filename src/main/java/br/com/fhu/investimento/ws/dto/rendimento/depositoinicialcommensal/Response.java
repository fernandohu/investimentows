package br.com.fhu.investimento.ws.dto.rendimento.depositoinicialcommensal;

import br.com.fhu.investimento.ws.adapter.ValorAdapter;
import br.com.fhu.investimento.ws.dto.RendimentoMensalDto;
import br.com.fhu.investimento.ws.dto.rendimento.depositoinicialcommensal.Request;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@XmlType(namespace = "calcularRendimentoDepositoInicialComMensalResposta")
public class Response {

    ResponseBruto bruto;

    ResponseCorrigido corrigido;

    @XmlElement(required=true)
    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double depositoInicial;

    @XmlElement(required=true)
    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double depositoMensal;

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

    Request originalRequest;

    List<RendimentoMensalDto> mes;

    public Response() {
        this.bruto = new ResponseBruto();
        this.corrigido = new ResponseCorrigido();
    }
}
