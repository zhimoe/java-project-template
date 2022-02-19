package zhimoe.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * v1.0 fix me
 *
 * @author zhimoe
 * @version 1.0
 * @since 2022/2/19
 */
@RestController
@RequestMapping("/stu")
public class StuController {

	@Autowired
	private StuService stuService;

	@GetMapping("/students")
	public List<Student> getFlightsByYear(@Size(min = 4, max = 4) @RequestParam("year") int year) {
		return stuService.getAllStudents();
	}

}