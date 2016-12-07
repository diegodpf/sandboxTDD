package com.farias.services.contracts;

import com.farias.daos.contracts.ImpostoDao;
import com.farias.models.Cliente;
import com.farias.models.Imposto;
import com.farias.utils.Periodo;

import java.util.List;

public interface ImpostoService {

    void setDao(ImpostoDao dao);
    void calcularImpostos(Cliente cliente, String anoMes);
    List<Imposto> buscarImpostos(Cliente cliente, Periodo periodo);

}
