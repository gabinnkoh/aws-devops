package net.cj.edu.aws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //controller와 response 방식이 다름. 데이터를 리턴할 때 (controller는 페이지(html)를 리턴할 떄)
public class MainController {

	@GetMapping("/") //@requestMapping(value="/", method=requestmethod.GET)이랑 똑같음
	public String home() {
		return "<h1>aws-devops finished</h1>"; //string을 넘기는 것이다
	}
	
	@GetMapping("/date")
	public String date() throws ClassNotFoundException {
		Class.forName("org.postgresql.Driver");

		String connurl = "jdbc:postgresql://aws-devops-db2.cniixrjqazcz.ap-northeast-2.rds.amazonaws.com:5432/postgres";
		String user = "postgres";
		String password = "12345678";
		String result = "NO_DATA";

		try (Connection connection = DriverManager.getConnection(connurl, user, password);) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT now() AS date");

			while (rs.next()) {
				result = rs.getString("date");
			}
			rs.close();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}
