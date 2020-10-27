package RestAssured;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class para_api {
	@Test
	public void f() throws IOException {
		Response response;
		String filepath = "C:\\Users\\NAVEEN GOWDA\\Desktop\\genders.xlsx";
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook wbook = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wbook.getSheet("Sheet1");
		int rows = sheet1.getLastRowNum() - sheet1.getFirstRowNum();

		for (int i = 1; i <= rows; i++) {

			String name = sheet1.getRow(i).getCell(0).getStringCellValue();
			response = RestAssured.get("https://api.genderize.io/?name=" + name + "");
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is :" + responseBody);
		}
		wbook.close();
	}

}
