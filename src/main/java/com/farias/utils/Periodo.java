package com.farias.utils;

import java.util.Date;

public class Periodo {

    private Date inicio;
    private Date fim;

    public Periodo() {}

    public Periodo(Date inicio, Date fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    public void setPeriodoMesAno(Date dataReferencia) {
        inicio = DateUtil.inicioDoMes(dataReferencia);
        fim = DateUtil.fimDoMes(dataReferencia);
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }
}
