package br.com.fhu.investimento.ws.dto.rendimento.depositoinicialcommensal;

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
@XmlType(namespace = "calcularRendimentoDepositoInicialComMensalCorrigidoResposta")
public class ResponseCorrigido {

    @XmlElement(required=true)
    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double valorAcumuladoCorrigidoInflacao;

    @XmlElement(required=true)
    @XmlJavaTypeAdapter(ValorAdapter.class)
    Double rendimentoReal;
}
