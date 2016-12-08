package com.farias.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class NotaFiscal extends Entidade {

    private BigDecimal valor;
    private Cliente cliente;
    private Anexo anexo;

    @Column(nullable = false, columnDefinition = "DATE")
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "Brazil/East")
    private Date dataEmissao;

    public BigDecimal getValor() {
        return valor.setScale(2, RoundingMode.HALF_EVEN);
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Anexo getAnexo() {
        return anexo;
    }

    public void setAnexo(Anexo anexo) {
        this.anexo = anexo;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }
}
