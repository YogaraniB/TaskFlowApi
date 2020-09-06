package com.tvm.taskflowAngular.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.tvm.taskflowAngular.model.Address;
import com.tvm.taskflowAngular.model.Client;

public class ExcelHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "Id", "Client Name", "City", "State", "Pincode", "First Name", "Last Name", "GroupName",
			"Email", "Mobile", "Created At Date" };
	static String SHEET = "Clients";

	public static boolean hasExcelFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	@SuppressWarnings("deprecation")
	public static List<Client> excelToClients(InputStream is) {
		try {
			Workbook workbook = new XSSFWorkbook(is);

			Sheet sheet = workbook.getSheet(SHEET);
			Iterator<Row> rows = sheet.iterator();

			List<Client> Clients = new ArrayList<Client>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();

				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();
				Address ad = new Address();
				Client Client = new Client();

				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();
					try {

						switch (cellIdx) {
						case 0:
							Client.setClientid((int) currentCell.getNumericCellValue());
							break;

						case 1:
							Client.setClientName(currentCell.getStringCellValue());
							break;

						case 2:
							ad.setCity(currentCell.getStringCellValue());
							break;

						case 3:
							ad.setState(currentCell.getStringCellValue());
							break;

						case 4:
							ad.setPincode((int) currentCell.getNumericCellValue());
							Client.setAddress(ad);
							System.out.println(ad + "cvg" + Client);
							break;

						case 5:
							Client.setFirstName(currentCell.getStringCellValue());
							break;

						case 6:
							Client.setLastName(currentCell.getStringCellValue());
							break;

						case 7:
							Client.setGroupName(currentCell.getStringCellValue());
							break;

						case 8:
							Client.setEmail(currentCell.getStringCellValue());
							break;

						case 9:
							Client.setMobile((int) currentCell.getNumericCellValue());
							break;

						case 10:
//    	Date today=currentCell.getDateCellValue();
//    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
//        String strDate= formatter.format(today);
							String s = currentCell.getStringCellValue();
							Date formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s);//convert s to this format
//        Date date1=new SimpleDateFormat().parse(s);  
//        System.out.println(s+"\t"+date1);  
							// String formattedDate =
							// today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
								Client.setCreatedAt(formatter);
							break;

						default:
							break;
						}
					} catch (Exception e) {
						e.getStackTrace();
						System.out.println(cellIdx + e.getLocalizedMessage() + " " + e.getMessage());

					}

					cellIdx++;
				}

				Clients.add(Client);
				Clients.forEach(m -> System.out.println(m));
			}

			workbook.close();

			return Clients;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	public static ByteArrayInputStream ClientsToExcel(List<Client> ClientsList) {

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet sheet = workbook.createSheet(SHEET);

			// Header
			Row headerRow = sheet.createRow(0);

			for (int col = 0; col < HEADERs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(HEADERs[col]);
			}

			int rowIdx = 1;
			for (Client clientTemp : ClientsList) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(clientTemp.getClientid());
				row.createCell(1).setCellValue(clientTemp.getClientName());
				row.createCell(2).setCellValue(clientTemp.getAddress().getCity());
				row.createCell(3).setCellValue(clientTemp.getAddress().getState());
				row.createCell(4).setCellValue(clientTemp.getAddress().getPincode());
				row.createCell(5).setCellValue(clientTemp.getFirstName());
				row.createCell(6).setCellValue(clientTemp.getLastName());
				row.createCell(7).setCellValue(clientTemp.getGroupName());
				row.createCell(8).setCellValue(clientTemp.getEmail());
				row.createCell(9).setCellValue(clientTemp.getMobile());
				row.createCell(10).setCellValue(clientTemp.getCreatedAt().toString());
			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		}
	}
}