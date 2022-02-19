package zhimoe.clickhouse;

import com.clickhouse.client.config.ClickHouseDefaults;
import com.clickhouse.jdbc.ClickHouseDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.*;

/**
 * v1.0 fix me
 *
 * @author zhimoe
 * @version 1.0
 * @since 2022/2/5
 */
@Service
@Slf4j
public class ClickClient {

	@Autowired
	private ClickConfig config;

	public Connection getConn() throws SQLException {
		Properties properties = new Properties();
		properties.setProperty("client_name", "springboot");
		properties.setProperty(ClickHouseDefaults.USER.getKey(), config.getUsername());
		properties.setProperty(ClickHouseDefaults.PASSWORD.getKey(), config.getPassword());
		ClickHouseDataSource dataSource = new ClickHouseDataSource(config.getUrl(), properties);
		return dataSource.getConnection();
	}

	public List<Map> exeSql(String sql) throws SQLException {
		Connection connection = getConn();
		try {
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery(sql);
			ResultSetMetaData rsmd = results.getMetaData();
			List<Map> list = new ArrayList();
			while (results.next()) {
				Map row = new HashMap();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					row.put(rsmd.getColumnName(i), results.getString(rsmd.getColumnName(i)));
				}
				list.add(row);
			}
			return list;
		}
		catch (SQLException e) {
			log.error("ExeSql:{}", sql);
			e.printStackTrace();
		}
		return null;
	}

}
