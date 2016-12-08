package com.farias.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NotaFiscal {

    private BigDecimal valor;
    private Cliente cliente;
    private Anexo anexo;

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
}
