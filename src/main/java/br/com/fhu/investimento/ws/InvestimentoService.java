package br.com.fhu.investimento.ws;

import br.com.fhu.investimento.model.rendimento.DepositoInicialComMensal;
import br.com.fhu.investimento.model.rendimento.DepositoUnico;
import br.com.fhu.investimento.model.rendimento.TempoFinanciamentoSac;
import br.com.fhu.investimento.ws.dto.rendimento.depositounico.Request;
import br.com.fhu.investimento.ws.dto.rendimento.depositounico.Response;
import br.com.fhu.investimento.ws.dto.tempo.financiamento.RequestTempoFinanciamento;
import br.com.fhu.investimento.ws.dto.tempo.financiamento.ResponseTempoFinanciamento;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.ResponseWrapper;

@WebService
public class InvestimentoService {

    @WebMethod()
    @ResponseWrapper(localName = "calcularRendimentoDepositoUnicoResposta")
    @WebResult(name = "Resultado")
    public Response calcularRendimentoDepositoUnico(@WebParam(name="investimento") Request investimento) {
        System.out.println("Chamando calcularRendimentoDepositoUnico");

        return new DepositoUnico().calcular(investimento);
    }

    @WebMethod()
    @ResponseWrapper(localName = "calcularRendimentoDepositoInicialComMensalResposta")
    @WebResult(name = "Resultado")
    public br.com.fhu.investimento.ws.dto.rendimento.depositoinicialcommensal.Response calcularRendimentoDepositoInicialComMensal(@WebParam(name="investimento") br.com.fhu.investimento.ws.dto.rendimento.depositoinicialcommensal.Request investimento) {
        System.out.println("Chamando calcularRendimentoDepositoInicialComMensal");

        return new DepositoInicialComMensal().calcular(investimento);
    }

    @WebMethod()
    @ResponseWrapper(localName = "calcularTempoFinanciamentoSACResposta")
    @WebResult(name = "Resultado")
    public ResponseTempoFinanciamento calcularTempoFinanciamentoSAC(@WebParam(name="financiamento") @XmlElement(required=true,nillable=false) RequestTempoFinanciamento financiamento) {
        System.out.println("Chamando calcularTempoFinanciamentoSAC");

        return new TempoFinanciamentoSac().calcular(financiamento);
    }
}
