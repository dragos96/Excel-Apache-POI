package ro.dragos.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import ro.dragos.dao.DaoClientiExcel;
import ro.dragos.model.Client;

public class ProgramTestSaveExcel {

	public static void main(String[] args) {
		
		DaoClientiExcel dao = new DaoClientiExcel();
		
		Date date = new Date();
		
		
		final String sir = "Hello";
//		sir += " world"; // modificare instanta
		// sir = new String("Hello world"); // in space java instantiaza un nou string cand folosim +=
		
		final StringBuilder sb = new StringBuilder("Hello");
		sb.append(" world");
		sb.append("salut boss");
		String rezultat = sb.toString();
		
		// for
		//   sir += "ceva";
		
		System.out.println(rezultat);
		
//		sir = new String("Salut boss"); // modificare instanta
		System.out.println(sir);
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2018);
		cal.set(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 17);
		System.out.println(cal.getTime());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dataAcum = "2019-10-12";
		try {
			Date dataAcumDate = sdf.parse(dataAcum);
			System.out.println("SDF Date is: " + dataAcumDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("Date is: " + date);
		
		Client client = new Client(133, "jimmy2", "jim@gmail.com", cal.getTime()); 
		
		dao.save(client);
	}
	
}
