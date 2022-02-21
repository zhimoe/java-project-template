package zhimoe.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

/**
 * v1.0 fix me
 *
 * @author zhimoe
 * @version 1.0
 * @since 2022/2/19
 */
@Repository
public class StuRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> getAllStudents() {
        return jdbcTemplate.query("select * from stu order by create_time asc limit 10",
                (ResultSet rs, int rowNum) -> {
                    Student stu = new Student();
                    stu.setId(rs.getLong("id"));
                    stu.setName(rs.getString("name"));
                    stu.setCreateTime(rs.getString("create_time"));
                    return stu;
                });
    }

}
