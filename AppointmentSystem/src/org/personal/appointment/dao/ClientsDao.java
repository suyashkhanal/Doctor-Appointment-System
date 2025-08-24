package org.personal.appointment.dao;

import java.sql.SQLException;
import java.util.List;
import org.personal.appointment.model.Clients;

public interface ClientsDao {

    int save(Clients client) throws SQLException, ClassNotFoundException;

    int update(Clients client, int id) throws SQLException, ClassNotFoundException;

    int remove(int id) throws SQLException, ClassNotFoundException;

    Clients findOne(int id) throws SQLException, ClassNotFoundException;

    List<Clients> findAll() throws SQLException, ClassNotFoundException;

    List<Clients> search(String query) throws SQLException, ClassNotFoundException;
}
