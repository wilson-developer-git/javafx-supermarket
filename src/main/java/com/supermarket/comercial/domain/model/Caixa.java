package com.supermarket.comercial.domain.model;

import com.supermarket.comercial.domain.model.enums.StatusCaixa;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Caixa {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataAbertura;

    private LocalDateTime dataFechamento;

    @Enumerated(EnumType.STRING)
    private StatusCaixa statusCaixa;

    private Double fundoDeTroco;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDateTime dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public StatusCaixa getStatusCaixa() {
        return statusCaixa;
    }

    public void setStatusCaixa(StatusCaixa statusCaixa) {
        this.statusCaixa = statusCaixa;
    }

    public Double getFundoDeTroco() {
        return fundoDeTroco;
    }

    public void setFundoDeTroco(Double fundoDeTroco) {
        this.fundoDeTroco = fundoDeTroco;
    }
}
