package br.com.fhu.investimento;

import br.com.fhu.investimento.ws.InvestimentoService;

import javax.xml.ws.Endpoint;

public class App {
    public static void main(String[] args) {
        InvestimentoService service = new InvestimentoService();
        String url = "http://localhost:8081/investimentows";

        System.out.println("Serviço rodando " + url);

        Endpoint.publish(url, service);
    }
}
