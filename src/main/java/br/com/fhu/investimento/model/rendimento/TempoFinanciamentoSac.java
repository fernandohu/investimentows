package br.com.fhu.investimento.model.rendimento;

import br.com.fhu.investimento.ws.dto.MesFinanciamento;
import br.com.fhu.investimento.ws.dto.tempo.financiamento.RequestTempoFinanciamento;
import br.com.fhu.investimento.ws.dto.tempo.financiamento.ResponseTempoFinanciamento;

import java.util.ArrayList;

public class TempoFinanciamentoSac {
    public ResponseTempoFinanciamento calcular(RequestTempoFinanciamento financiamento) {

        Double taxaAmortizacao = financiamento.getValorFinanciado() / financiamento.getTempo().getMeses();
        ResponseTempoFinanciamento result = new ResponseTempoFinanciamento();

        result.setMes(new ArrayList<>());

        Double jurosMensal = financiamento.getJuros().getMensal();
        Double totalPago = 0.0d;
        Double saldoDevedor = 0.0d;
        for (int mesAtual = 1; mesAtual <= financiamento.getTempo().getMeses(); mesAtual++) {
            Double jurosSaldoDevedor = jurosMensal * (financiamento.getValorFinanciado() - totalPago);
            Double valorParcela = taxaAmortizacao + jurosSaldoDevedor;
            Double valorAbatido = financiamento.getAbatimento().getValorAbatimentoPorMes();

            totalPago += valorParcela;

            MesFinanciamento mesFinanciamento = new MesFinanciamento();
            mesFinanciamento.setMesAtual(mesAtual);
            mesFinanciamento.setValorParcela(valorParcela);
            mesFinanciamento.setSaldoDevedor(saldoDevedor);
            mesFinanciamento.setTotalPago(totalPago);
            mesFinanciamento.setValorAbatido(valorAbatido);

            result.getMes().add(mesFinanciamento);
        }

        return result;
    }
}
