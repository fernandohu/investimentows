package br.com.fhu.investimento.ws.dto;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class TempoDto {
    @XmlElement(required=false)
    Double meses;
    
    @XmlElement(required=false)
    Double anos;
}
