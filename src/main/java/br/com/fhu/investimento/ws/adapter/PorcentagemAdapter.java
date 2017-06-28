package br.com.fhu.investimento.ws.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class PorcentagemAdapter extends XmlAdapter<Double, Double> {
    @Override
    public Double unmarshal(Double v) throws Exception {
        if (v > 1) {
            return v / 100;
        }

        return v;
    }

    @Override
    public Double marshal(Double v) throws Exception {
        return v;
    }
}
