package ro.dragos.teste;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		
		Date acum = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String formatare = sdf.format(acum);
		System.out.println("FORMATARE: " + formatare);
		
	}
	
}
