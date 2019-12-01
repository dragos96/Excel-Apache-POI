package ro.dragos.teste;

import java.util.List;
import java.util.Scanner;

import ro.dragos.dao.DaoClientMySQL;
import ro.dragos.model.Client;

public class TestDaoClient {

	
	public static void main(String[] args) {
		
		DaoClientMySQL dao = new DaoClientMySQL();
		// String name = "ion";
		
		
		Client client = new Client(43, "Billy", "bill2@gmail.com", null);
//		Client client = new Client(33, "Billy", "bill@gmail.com' drop table clienti; -- ", null);
		dao.save(client);
		
		String name = null;
		System.out.print("Please insert name to search by: ");
		Scanner scan = new Scanner(System.in);
		name = scan.nextLine();
		
		
		System.out.println("---clienti gasiti---");
		List<Client> clienti = dao.findByName(name);
		
		
		
		for(Client cl : clienti){
			System.out.println(cl);
		}
		
	}
	
}
