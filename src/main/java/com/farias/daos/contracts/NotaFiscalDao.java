package com.farias.daos.contracts;

import com.farias.models.Cliente;
import com.farias.models.NotaFiscal;
import com.farias.utils.Periodo;

import java.util.List;

public interface NotaFiscalDao extends Dao<NotaFiscal> {

    List<NotaFiscal> buscarPorPeriodo(Cliente cliente, Periodo periodo);

}
