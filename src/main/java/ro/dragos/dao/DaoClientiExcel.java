package ro.dragos.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ro.dragos.dao.spec.IDao;
import ro.dragos.model.Client;

public class DaoClientiExcel implements IDao<Client> {

	private static final String FILE_NAME = "C:\\development\\date-mock\\Clienti.xlsx";

	@Override
	public List<Client> findAll() {
		List<Client> allClientsFromExcelSpreadsheet = new ArrayList<>();
		try {

			FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();

				Cell currentCell = cellIterator.next();
				Integer clientId = (int) currentCell.getNumericCellValue();
				currentCell = cellIterator.next();
				String name = currentCell.getStringCellValue();
				currentCell = cellIterator.next();
				String email = currentCell.getStringCellValue();

				Client client = new Client(clientId, name, email, null);
				allClientsFromExcelSpreadsheet.add(client);
				// while (cellIterator.hasNext()) {
				//
				// Cell currentCell = cellIterator.next();
				// //getCellTypeEnum shown as deprecated for version 3.15
				// //getCellTypeEnum ill be renamed to getCellType starting from
				// version 4.0
				// if (currentCell.getCellType() == Cell.CELL_TYPE_STRING) {
				// System.out.print(currentCell.getStringCellValue() + "--");
				// } else if (currentCell.getCellType() ==
				// Cell.CELL_TYPE_NUMERIC) {
				// System.out.print(currentCell.getNumericCellValue() + "--");
				// }
				//
				// }
				System.out.println();

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allClientsFromExcelSpreadsheet;
	}

	@Override
	public void save(Client obj) {

		try {
			FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			System.out.println(datatypeSheet.getLastRowNum());
			int rowToInsert = datatypeSheet.getLastRowNum() + 1;
			Row row = datatypeSheet.createRow(rowToInsert);

			Cell cellId = row.createCell(0);
			Cell cellName = row.createCell(1);
			Cell cellEmail = row.createCell(2);
			Cell cellDateJoined = row.createCell(3);
			cellId.setCellValue(obj.getId());
			cellName.setCellValue(obj.getName());
			cellEmail.setCellValue(obj.getEmail());
			
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			cellDateJoined.setCellValue(sdf.format(obj.getDateJoined()));
			
			FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
