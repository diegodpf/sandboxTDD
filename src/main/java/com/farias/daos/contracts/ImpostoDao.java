package com.farias.daos.contracts;

import com.farias.models.Cliente;
import com.farias.models.Imposto;
import com.farias.utils.Periodo;

import java.util.List;

public interface ImpostoDao extends Dao<Imposto> {

    List<Imposto> buscarPorPeriodo(Cliente cliente, Periodo periodo);

}
