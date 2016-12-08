package com.farias.models;

import java.math.BigDecimal;

public class Anexo extends Entidade implements TipoImposto {

    public Anexo(String nome, BigDecimal aliquota) {
        this.nome = nome;
        this.aliquota = aliquota;
    }

    private String nome;
    private BigDecimal aliquota;

    public String getNome() {
        return nome;
    }

    public BigDecimal getAliquota() {
        return aliquota;
    }
}
