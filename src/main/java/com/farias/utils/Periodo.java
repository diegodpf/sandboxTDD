package com.farias.utils;

import java.util.Date;

public class Periodo {

    private Date dataInicio;
    private Date dataFim;

    public Periodo() {}

    public Periodo(Date dataInicio, Date dataFim) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public void setPeriodoMesAno(Date dataReferencia) {
        dataInicio = DateUtil.inicioDoMes(dataReferencia);
        dataFim = DateUtil.fimDoMes(dataReferencia);
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
}
