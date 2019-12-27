package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jdbc.core.convert.BasicJdbcConverter;
import org.springframework.data.jdbc.core.convert.DataAccessStrategy;
import org.springframework.data.jdbc.core.convert.DefaultDataAccessStrategy;
import org.springframework.data.jdbc.core.convert.JdbcConverter;
import org.springframework.data.jdbc.core.convert.SqlGeneratorSource;
import org.springframework.data.jdbc.core.mapping.JdbcMappingContext;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.support.JdbcRepositoryFactory;
import org.springframework.data.relational.core.mapping.NamingStrategy;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.example.demo.data.VoucherRepository;

@Configuration
public class H2TestProfileJdbcConfig extends AbstractJdbcConfiguration {
    @Bean
    NamedParameterJdbcOperations operations() {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().generateUniqueName(true).setType(EmbeddedDatabaseType.H2).addScript("create-voucher-test-schema.sql").build();
//        return DataSourceBuilder.create().driverClassName("org.h2.Driver").url("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1").username("sa").password("").build();
    }

    @Bean
    JdbcRepositoryFactory repositoryFactory() {
        final JdbcMappingContext mappingContext = new JdbcMappingContext(NamingStrategy.INSTANCE);
        final ApplicationEventPublisher publisher = new AnnotationConfigApplicationContext();
        final JdbcConverter converter = new BasicJdbcConverter(mappingContext, null);
        final DataAccessStrategy dataAccessStrategy = new DefaultDataAccessStrategy(new SqlGeneratorSource(mappingContext), mappingContext, converter, operations());
        return new JdbcRepositoryFactory(dataAccessStrategy, mappingContext, converter, publisher, operations());
    }

    @Bean
    VoucherRepository voucherRepository() {
        return repositoryFactory().getRepository(VoucherRepository.class);
    }
}
