package ro.dragos.teste;

import java.util.List;

import ro.dragos.dao.DaoClientMySQL;
import ro.dragos.dao.DaoClientiExcel;
import ro.dragos.model.Client;

public class ProgramExport {

	public static void main(String[] args) {
		
//		DaoClientMySQL dao = new DaoClientMySQL();
//		List<Client> clientiDb = dao.findAll();
		
		DaoClientiExcel daoExcel = new DaoClientiExcel();
		List<Client> clientiExcel = daoExcel.findAll();
		
		for(Client c : clientiExcel){
			System.out.println("CLIENT: " + c);
		}
		
		// TODO: de inserat clientiExcel, unul cate unul, in baza de date -> clientiDb.save(...)
	}
	
}
