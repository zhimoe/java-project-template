package zhimoe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zhimoe.clickhouse.ClickClient;
import zhimoe.user.StuService;

import java.util.List;
import java.util.Map;

/**
 * v1.0 fix me
 *
 * @author zhimoe
 * @since 2022.1.22
 */
@SpringBootApplication
public class Main implements ApplicationRunner {

	@Autowired
	private ClickClient clickClient;

	@Autowired
	private StuService stuService;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		System.out.println("###hello spring boot");
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		String sql = "select * from stu order by create_time asc limit 10";
		List<Map> result = clickClient.exeSql(sql);
		result.stream().forEach(System.out::println);

		System.out.println("### use the jdbc");
		System.out.println(stuService.getAllStudents());
	}

}