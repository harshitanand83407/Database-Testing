import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class jdbcconn {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		String host = "localhost";

		String port = "3306";

		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/demo", "root",
				"H@rshit01");

		Statement s = con.createStatement();

		ResultSet rs = s.executeQuery("select * from credentials where scenerio ='zerobalancecard' ");

		while (rs.next()) {
			System.setProperty("webdriver.chrome.driver", "C:/Users/hanand/chromedriver_win32 (2)/chromedriver.exe");

			WebDriver driver = new ChromeDriver();

			driver.get("https://login.salesforce.com");
			driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("username"));

			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("password"));
		}

	}

}
