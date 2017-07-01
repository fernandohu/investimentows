package br.com.fhu.investimento.ws.adapter;

import br.com.fhu.investimento.ws.dto.TempoDto;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TempoAdapter extends XmlAdapter<TempoDto, TempoDto> {
    @Override
    public TempoDto unmarshal(TempoDto v) throws Exception {
        if (v.getMeses() != null && v.getMeses() > 0) {
            v.setAnos(v.getMeses() / 12);
        } else
        if (v.getAnos() != null && v.getAnos() > 0) {
            v.setMeses(v.getAnos() * 12);
        } else {
            v.setAnos(0.0d);
            v.setMeses(0.0d);
        }

        return v;
    }

    @Override
    public TempoDto marshal(TempoDto v) throws Exception {
        return v;
    }
}
