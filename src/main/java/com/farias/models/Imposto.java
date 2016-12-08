package com.farias.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

public class Imposto extends Entidade {

    private List<NotaFiscal> notasFiscais;
    private Cliente cliente;
    private BigDecimal valor;
    private String tipo;
    private Date dataReferencia;

    public List<NotaFiscal> getNotasFiscais() {
        return notasFiscais;
    }

    public void setNotasFiscais(List<NotaFiscal> notasFiscais) {
        this.notasFiscais = notasFiscais;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValor() {
        return valor.setScale(2, RoundingMode.HALF_EVEN);
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDataReferencia() {
        return dataReferencia;
    }

    public void setDataReferencia(Date dataReferencia) {
        this.dataReferencia = dataReferencia;
    }
}
