package zhimoe.jpa.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * v1.0 fix me
 *
 * @author zhimoe
 * @version 1.0
 * @since 2022/2/19
 */
@Entity
@Table(name = "stu")
@Data
public class Student {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "create_time")
    private String createTime;

    // {create_time=2021-08-19 14:21:30, name=tank, id=1}
    // {create_time=2021-08-19 14:22:30, name=john, id=2}

}
