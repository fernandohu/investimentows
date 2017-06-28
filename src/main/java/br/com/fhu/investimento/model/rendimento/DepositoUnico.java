package br.com.fhu.investimento.model.rendimento;

import br.com.fhu.investimento.ws.dto.RendimentoMensalDto;
import br.com.fhu.investimento.ws.dto.rendimento.depositounico.Request;
import br.com.fhu.investimento.ws.dto.rendimento.depositounico.Response;

import java.util.ArrayList;
import java.util.List;

public class DepositoUnico {
    public Response calcular(Request investimento) {
        double meses = 0;
        double inflacao = 0;
        double rendimento = 0;

        if (investimento.getAnos() != null && investimento.getAnos() > 0) {
            meses = investimento.getAnos() * 12;
            inflacao = investimento.getPorcentagemInflacao() / 12 + 1;
            rendimento = investimento.getPorcentagemRendimento() / 12 + 1;
        }

        if (investimento.getMeses() != null && investimento.getMeses() > 0) {
            meses = investimento.getMeses();
            inflacao = investimento.getPorcentagemInflacao() + 1;
            rendimento = investimento.getPorcentagemRendimento() + 1;
        }

        Response result = new Response();
        List<RendimentoMensalDto> rendimentoMensal = new ArrayList<>();
        result.setMes(rendimentoMensal);

        double rendimentoAcumulado = investimento.getDepositoInicial();
        double rendimentoInflacao = investimento.getDepositoInicial();
        for (int mes = 1; mes <= meses; mes++) {
            RendimentoMensalDto rendimentoMensalDto = new RendimentoMensalDto();
            rendimentoMensalDto.setPeriodo(Integer.toString(mes));
            rendimentoMensalDto.setRendimentoMensal(rendimentoAcumulado * rendimento - rendimentoAcumulado);
            rendimentoMensalDto.setValorAtual(rendimentoAcumulado * rendimento);

            rendimentoMensalDto.setInflacaoAcumulada(rendimentoInflacao * inflacao);
            rendimentoMensalDto.setInflacaoMensal(rendimentoInflacao * inflacao - rendimentoInflacao);


            rendimentoMensal.add(rendimentoMensalDto);

            rendimentoAcumulado = rendimentoAcumulado * rendimento;
            rendimentoInflacao = rendimentoInflacao * inflacao;
        }

        result.setDepositoInicial(investimento.getDepositoInicial());
        result.setValorAcumulado(rendimentoAcumulado);
        result.setInflacaoAcumulada(rendimentoInflacao);
        result.setValorAcumuladoMenosInflacaoAcumulada(rendimentoAcumulado - rendimentoInflacao);

        double coeficienteValorizacao = rendimentoAcumulado / rendimentoInflacao;
        result.setValorAcumuladoCorrigidoInflacao(investimento.getDepositoInicial() * coeficienteValorizacao);

        result.setRendimentoReal(result.getValorAcumuladoCorrigidoInflacao() - result.getDepositoInicial());

        result.setPorcentagemInflacaoAnual((inflacao - 1) * 12 * 100);
        result.setPorcentagemInflacaoMensal((inflacao - 1) * 100);
        result.setPorcentagemRendimentoAnual((rendimento - 1) * 100);
        result.setPorcentagemRendimentoMensal((rendimento - 1) * 12 * 100);
        result.setAnos(Double.valueOf(meses / 12).intValue());

        return result;
    }
}
