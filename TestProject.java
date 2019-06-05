
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class TestProject {
	private final Connection connection;

	TestProject() throws Exception {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		// Without :memory the database will be persisted on filesystem (and the folder
		// named demo).
		this.connection = DriverManager.getConnection("jdbc:derby:memory:demo;create=true");
		// If using non-memory db, make sure to create tables only if database is new
		createTables();
	}

	private void createTables() throws Exception {
		this.connection.prepareStatement("" + "CREATE TABLE \"Car\"("
				+ "   \"id\"    INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
				+ "   \"name\"  VARCHAR(32)," + "   \"price\" INTEGER" + ")").execute();
	}

	public void doStuff() throws Exception {
		this.connection
				.prepareStatement(
						"" + "INSERT INTO \"Car\" " + "(\"name\", \"price\")" + "VALUES('Ford Nucleon', 100000)")
				.execute();

		PreparedStatement statement = this.connection.prepareStatement("" + "SELECT *" + "FROM \"Car\"");
		statement.execute();
		ResultSet resultSet = statement.getResultSet();

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			int price = resultSet.getInt("price");
			System.out.println(id + " " + name + " " + price);
		}

		resultSet.close();
	}

	public void dispose() throws Exception {
		this.connection.close();
	}
}
