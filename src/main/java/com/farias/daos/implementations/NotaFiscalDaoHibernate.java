package com.farias.daos.implementations;

import com.farias.daos.contracts.NotaFiscalDao;
import com.farias.models.Cliente;
import com.farias.models.NotaFiscal;
import com.farias.utils.Periodo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NotaFiscalDaoHibernate extends DaoHibernate<NotaFiscal> implements NotaFiscalDao {
    public List<NotaFiscal> buscarPorPeriodo(Cliente cliente, Periodo periodo) {
        return null;
    }
}
