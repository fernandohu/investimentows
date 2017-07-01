package br.com.fhu.investimento.model.rendimento;

import br.com.fhu.investimento.ws.dto.AbatimentoDto;
import br.com.fhu.investimento.ws.dto.Parcela;
import br.com.fhu.investimento.ws.dto.TempoDto;
import br.com.fhu.investimento.ws.dto.tempo.financiamento.RequestTempoFinanciamento;
import br.com.fhu.investimento.ws.dto.tempo.financiamento.ResponseTempoFinanciamento;

public class TempoFinanciamentoSac {
    public ResponseTempoFinanciamento calcular(RequestTempoFinanciamento financiamento) {
        ResponseTempoFinanciamento result = new ResponseTempoFinanciamento();

        Double valorFinanciado = financiamento.getValorFinanciado();
        Double totalMeses = financiamento.getTempo().getMeses();
        Double totalPagoComJuros = 0.0d;
        Double totalPagoSemJuros = 0.0d;
        Double totalAbatido = 0.0d;
        for (int mesAtual = 1; mesAtual <= totalMeses; mesAtual++) {
            if (valorFinanciado - totalPagoSemJuros <= 0) {
                totalMeses = (double) mesAtual;
                break;
            }

            Double taxaAmortizacao = (valorFinanciado - totalAbatido) / totalMeses;

            double valorParcela = this.calcularValorParcela(
                valorFinanciado, totalPagoSemJuros, financiamento.getJuros().getMensal(), taxaAmortizacao);

            double abatimento = calcularAbatimento(financiamento.getAbatimento(), mesAtual);

            double juros = calcularJuros(valorFinanciado, totalPagoSemJuros, financiamento.getJuros().getMensal());

            totalPagoComJuros += valorParcela + abatimento;
            totalPagoSemJuros += taxaAmortizacao + abatimento;
            totalAbatido += abatimento;

            Parcela parcela = new Parcela(mesAtual);
            parcela.setValorParcela(valorParcela);
            parcela.getAcumulado().setTotalPago(totalPagoSemJuros);
            parcela.setValorAbatido(abatimento);
            parcela.setSaldoDevedor(0.0d);
            parcela.getAcumulado().setTotalPagoComJuros(totalPagoComJuros);
            parcela.setJuros(juros);
            parcela.getAcumulado().setTotalJurosPago(parcela.getAcumulado().getTotalPagoComJuros() - parcela.getAcumulado().getTotalPago());
            parcela.setAmortizacao(taxaAmortizacao);
            parcela.setSaldoDevedor((totalMeses - mesAtual) * taxaAmortizacao);

            result.getParcela().add(parcela);
        }

        result.setOriginalRequest(financiamento);
        result.setAmortizacao(financiamento.getValorFinanciado() / financiamento.getTempo().getMeses());
        result.setTempoParaQuitar(new TempoDto(totalMeses, totalMeses / 12));

        return result;
    }

    private double calcularValorParcela(double valorFinanciado, double totalPago, double jurosMensal, double taxaAmortizacao) {
        Double jurosSaldoDevedor = calcularJuros(valorFinanciado, totalPago, jurosMensal);
        Double valorParcela = taxaAmortizacao + jurosSaldoDevedor;

        return valorParcela;
    }

    private double calcularJuros(double valorFinanciado, double totalPago, double jurosMensal) {
        return jurosMensal * (valorFinanciado - totalPago);
    }

    private Double calcularAbatimento(AbatimentoDto abatimento, int mesAtual) {
        Double valorParaAbater = abatimento.getValorAbatimentoPorMes();

        if (mesAtual % 12 == 0) {
            valorParaAbater += abatimento.getValorAbatimentoPorAno();
        }

        if (mesAtual % 24 == 0) {
            valorParaAbater += abatimento.getValorAbatimentoFgtsACadaDoisAnos();
        }

        return valorParaAbater;
    }
}