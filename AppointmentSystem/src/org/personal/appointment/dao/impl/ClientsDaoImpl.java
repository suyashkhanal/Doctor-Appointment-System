package org.personal.appointment.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.personal.appointment.dao.ClientsDao;
import org.personal.appointment.model.Clients;
import static org.personal.appointment.connection.ConnectionFactory.getConnection;
import java.sql.Date;

public class ClientsDaoImpl implements ClientsDao {

    @Override
    public int save(Clients client) throws SQLException, ClassNotFoundException {
        String insertSQL = "insert into client_ ( name , age, doctor, date) values(?,?,?,?)";
        PreparedStatement prepareStatement = getConnection().prepareStatement(insertSQL);
        prepareStatement.setString(1, client.getName());
        prepareStatement.setInt(2, client.getAge());
        prepareStatement.setString(3, client.getDoctor());
        prepareStatement.setString(4, client.getDate());
        return prepareStatement.executeUpdate();
    }

    @Override
    public int update(Clients client, int id) throws SQLException, ClassNotFoundException {
        String updateSQL = "update client_ set name = ?, age = ?,"
                + " doctor = ?, date = ? where id = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(updateSQL);
        preparedStatement.setString(1, client.getName());
        preparedStatement.setInt(2, client.getAge());
        preparedStatement.setString(3, client.getDoctor());
        preparedStatement.setString(4, client.getDate());
        preparedStatement.setInt(5, client.getId());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int remove(int id) throws SQLException, ClassNotFoundException {
        String deleteSQL = "delete from client_ where id = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(deleteSQL);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }

    @Override
    public Clients findOne(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = getConnection()
                .prepareStatement("select *from client_ where id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Clients client = new Clients();
        while (resultSet.next()) {
            client.setId(resultSet.getInt("id"));
            client.setName(resultSet.getString("name"));
            client.setAge(resultSet.getInt("age"));
            client.setDoctor(resultSet.getString("doctor"));
            client.setDate(resultSet.getString("date"));
        }
        return client;
    }

    @Override
    public List<Clients> findAll() throws SQLException, ClassNotFoundException {
        List<Clients> clients = new ArrayList<>();
        PreparedStatement preparedStatement = getConnection()
                .prepareStatement("select *from client_");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Clients client = new Clients();
            client.setId(resultSet.getInt("id"));
            client.setName(resultSet.getString("name"));
            client.setAge(resultSet.getInt("age"));
            client.setDoctor(resultSet.getString("doctor"));
            client.setDate(resultSet.getString("date"));
            clients.add(client);
        }
        return clients;
    }

    @Override
    public List<Clients> search(String query) throws SQLException, ClassNotFoundException {
        List<Clients> clients = new ArrayList<>();
        PreparedStatement preparedStatement = getConnection().prepareStatement(
                "select *from client_ where name like concat ('%' ? '%')"
                + "or age like concat ('%' ? '%') "
                + "or doctor like concat ('%' ? '%') "
                + "or cast(id as char) like ('%' ? '%') "
                + "or cast(date as char) like ('%' ? '%')");
        preparedStatement.setString(1, query);
        preparedStatement.setString(2, query);
        preparedStatement.setString(3, query);
        preparedStatement.setString(4, query);
        preparedStatement.setString(5, query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Clients client = new Clients();
            client.setId(resultSet.getInt("id"));
            client.setName(resultSet.getString("name"));
            client.setAge(resultSet.getInt("age"));
            client.setDoctor(resultSet.getString("doctor"));
            client.setDate(resultSet.getString("date"));
            clients.add(client);
        }
        return clients;
    }
    
}

