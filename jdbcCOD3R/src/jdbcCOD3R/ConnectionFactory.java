package jdbcCOD3R;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	public static Connection getConexao() {
		try {
			Properties prop = getProperties();
			String url = prop.getProperty("url");
			String usuario = prop.getProperty("usuario");
			String senha = prop.getProperty("senha");
			
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException | IOException e) {
			throw new RuntimeException(e);
		}
	}
	private static Properties getProperties() throws IOException {
		Properties prop = new Properties();
		String caminho = "/conexao.properties";
		prop.load(ConnectionFactory.class.getResourceAsStream(caminho));
		return prop;
	}
}
