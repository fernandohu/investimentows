package br.com.fhu.investimento.ws.adapter;

import br.com.fhu.investimento.ws.dto.JurosDto;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class JurosAdapter extends XmlAdapter<JurosDto, JurosDto> {
    @Override
    public JurosDto unmarshal(JurosDto v) throws Exception {
        if (v.getMensal() != null && v.getMensal() > 0) {
            v.setAnual(v.getMensal() * 12);
        } else
        if (v.getAnual() != null && v.getAnual() > 0) {
            v.setMensal(v.getAnual() / 12);
        } else {
            v.setAnual(0.0d);
            v.setMensal(0.0d);
        }

        return v;
    }

    @Override
    public JurosDto marshal(JurosDto v) throws Exception {
        return v;
    }
}
