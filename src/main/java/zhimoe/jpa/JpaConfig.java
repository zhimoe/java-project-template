package zhimoe.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * v1.0 fix me
 *
 * @author zhimoe
 * @version 1.0
 * @since 2022/2/21
 */

@Configuration
@EntityScan(basePackages = "zhimoe.jpa.entity")
@EnableJpaRepositories(
        basePackages = "zhimoe.jpa.repo",
        entityManagerFactoryRef = "thirdEntityManagerFactoryBean"
)
public class JpaConfig {



    @Autowired
    private DataSource dataSource;

    //jpa其他参数配置
    @Autowired
    private JpaProperties jpaProperties;

    //实体管理工厂builder
    @Autowired
    private EntityManagerFactoryBuilder factoryBuilder;

    /**
     * 配置第二个实体管理工厂的bean
     *
     * @return
     */
    @Bean(name = "thirdEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        return factoryBuilder.dataSource(dataSource)
                .properties(getVendorProperties())
                .packages("zhimoe.jpa")
                .persistenceUnit("thirdPersistenceUnit")
                .build();
    }

    @Autowired
    private HibernateProperties hibernateProperties;

    private Map<String, Object> getVendorProperties() {
        Map<String, String> properties = jpaProperties.getProperties();
        // 为了解决分页查询时的错误
        // 因为使用的是clicakhouse数据库，但是没有clickhouse数据库的方言，但是进行分页查询时候，就需要设置一个方言
        // 又因为MySQLDialect的方言差不多，于是就设置了MySQLDialect
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        return hibernateProperties.determineHibernateProperties(
                properties, new HibernateSettings());
    }

    /**
     * EntityManager不过解释，用过jpa的应该都了解
     *
     * @return
     */
    @Bean(name = "thirdEntityManager")
    public EntityManager entityManager() {
        return entityManagerFactoryBean().getObject().createEntityManager();
    }
}