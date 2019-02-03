package com.itechart.crp.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.boot.autoconfigure.jmx.ParentAwareNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.export.annotation.AnnotationJmxAttributeSource;
import org.springframework.jmx.export.naming.ObjectNamingStrategy;
import org.springframework.jmx.support.RegistrationPolicy;

import javax.sql.DataSource;
import java.util.UUID;

@Configuration
@EnableMBeanExport(registration= RegistrationPolicy.IGNORE_EXISTING)
public class AppConfig extends HikariConfig {

//    @Bean
//    public DataSource dataSource() {
//        HikariDataSource dataSource = new HikariDataSource(this);
//        dataSource.setPoolName("dataSource_" + UUID.randomUUID().toString());
//        return dataSource;
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(value = ObjectNamingStrategy.class, search = SearchStrategy.CURRENT)
//    public ParentAwareNamingStrategy objectNamingStrategy() {
//        ParentAwareNamingStrategy namingStrategy = new ParentAwareNamingStrategy(new AnnotationJmxAttributeSource());
//        namingStrategy.setDefaultDomain("domain_" + UUID.randomUUID().toString());
//        return namingStrategy;
//    }

}
