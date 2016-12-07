package com.farias.daos.implementations;

import com.farias.daos.contracts.ClienteDao;
import com.farias.models.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDaoHibernate extends DaoHibernate<Cliente> implements ClienteDao {
}
