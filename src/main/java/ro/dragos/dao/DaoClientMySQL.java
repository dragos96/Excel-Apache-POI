package ro.dragos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ro.dragos.dao.spec.IDao;
import ro.dragos.model.Client;

public class DaoClientMySQL implements IDao<Client> {

	public List<Client> findAll() {

		List<Client> allClients = new ArrayList<>();

		try {
			Connection con = ConnectionProvider.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM clienti");
			while (rs.next()) {
				Client client = new Client();
				client.setId(rs.getInt("id"));
				client.setEmail(rs.getString("client_email"));
				client.setName(rs.getString("client_name"));
				// TODO: work with date
				allClients.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allClients;
	}

	@Override
	public void save(Client obj) {
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO clienti(id, client_name, client_email) VALUES (?, ?, ?)");
			stmt.setInt(1, obj.getId());
			stmt.setString(2, obj.getName());
			stmt.setString(3, obj.getEmail());
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// pentru toate coloanele care nu sunt unique!
	public List<Client> findByName(String name) {
		List<Client> allClients = new ArrayList<>();

		try {
			Connection con = ConnectionProvider.getConnection();
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery("SELECT * FROM clienti WHERE client_name = '" + name + "'");
			
			// PreparedStatement = Avoid SQL Injection
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM clienti WHERE client_name = ?");
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Client client = new Client();
				client.setId(rs.getInt("id"));
				client.setEmail(rs.getString("client_email"));
				client.setName(rs.getString("client_name"));
				// TODO: work with date
				allClients.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allClients;
	}

	public List<Client> findByEmail(String email) {
		// TODO: please implement cu prepared statement
		List<Client> allClients = new ArrayList<>();
		try{
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM clienti WHERE client_email = ?");
			stmt.setString(1,email);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Client client = new Client();
				client.setId(rs.getInt("id"));
				client.setName(rs.getString("client_name"));
				client.setEmail(rs.getString("client_email"));
				allClients.add(client);
				
				
			}
			
		} catch(SQLException e ){
			e.printStackTrace();
		}
		return allClients;
	}

}
