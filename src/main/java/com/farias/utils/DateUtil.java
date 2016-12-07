package com.farias.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private static Calendar criarCalendario(Date data) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        return calendar;
    }

    public static Date criarDataMesAno(int mes, int ano) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.MONTH, mes - 1);
        calendar.set(Calendar.YEAR, ano);
        return calendar.getTime();
    }

    public static Date criarDataMesAno(String anoMes) {
        String[] data = anoMes.split("-");
        return criarDataMesAno(new Integer(data[1]), new Integer(data[0]));
    }

    public static Date criarDataHora(int ano, int mes, int dia, int hora, int minuto, int segundo) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, ano);
        calendar.set(Calendar.MONTH, mes - 1);
        calendar.set(Calendar.DAY_OF_MONTH, dia);
        calendar.set(Calendar.HOUR_OF_DAY, hora);
        calendar.set(Calendar.MINUTE, minuto);
        calendar.set(Calendar.SECOND, segundo);
        return calendar.getTime();
    }

    public static Date inicioDoMes(Date data) {
        Calendar calendar = criarCalendario(data);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date fimDoMes(Date data) {
        Calendar calendar = criarCalendario(data);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public static Periodo criarPeriodoAnoMes(String anoMes) {
        Date dataReferencia = criarDataMesAno(anoMes);
        Periodo periodo = new Periodo();
        periodo.setPeriodoMesAno(dataReferencia);
        return periodo;
    }

}
