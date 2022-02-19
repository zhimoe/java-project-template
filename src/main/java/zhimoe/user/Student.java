package zhimoe.user;

import lombok.Data;
import lombok.ToString;

/**
 * v1.0 fix me
 *
 * @author zhimoe
 * @version 1.0
 * @since 2022/2/19
 */
@Data
@ToString
public class Student {

	private Long id;

	private String name;

	private String createTime;

	// {create_time=2021-08-19 14:21:30, name=tank, id=1}
	// {create_time=2021-08-19 14:22:30, name=john, id=2}

}
