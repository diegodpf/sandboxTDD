package com.farias.daos.implementations;

import com.farias.daos.contracts.ImpostoDao;
import com.farias.models.Cliente;
import com.farias.models.Imposto;
import com.farias.utils.Periodo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImpostoDaoHibernate extends DaoHibernate<Imposto> implements ImpostoDao {

    public List<Imposto> buscarPorPeriodo(Cliente cliente, Periodo periodo) {
        return null;
    }
}
