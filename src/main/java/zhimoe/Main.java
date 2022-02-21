package zhimoe;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import zhimoe.clickhouse.ClickClient;
import zhimoe.jpa.entity.Student;
import zhimoe.jpa.repo.StuJpaRepo;
import zhimoe.user.StuService;

import java.util.List;
import java.util.Map;

/**
 * v1.0 fix me
 *
 * @author zhimoe
 * @since 2022.1.22
 */
@Slf4j
@SpringBootApplication
public class Main implements ApplicationRunner {

    @Autowired
    private ClickClient clickClient;

    @Autowired
    private StuService stuService;

    @Autowired
    private StuJpaRepo repo;

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

        System.out.println("### use jpa");
        List<Student> students = (List<Student>) repo.findAll();
        System.out.println("###" + students);

    }

}

