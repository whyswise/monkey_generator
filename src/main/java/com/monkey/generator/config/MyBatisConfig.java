package com.monkey.generator.config;
 
import javax.sql.DataSource;
 
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//마이바티스 설정 파일
@Configuration
//@MapperScan(basePackages = "com.monkey.generator.service")
public class MyBatisConfig {
    
//    @Bean
//    public SqlSessionFactory sqlSessionFactory (DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
//        
//        sqlSessionFactory.setDataSource(dataSource);
//        sqlSessionFactory.setTypeAliasesPackage("com.bankcheck.mortgage.model");
//        
//        return sqlSessionFactory.getObject();
//    }
//    
//    @Bean
//    public SqlSessionTemplate sqlSession (SqlSessionFactory sqlSessionFactory) {
//        
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
}
