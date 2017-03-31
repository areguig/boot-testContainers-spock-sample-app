package io.areguig.sample.config;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.conf.StatementType;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by akli on 31/03/2017.
 */
@Configuration
public class AppConfig {
    @Primary
    @Bean(destroyMethod = "close")
    @ConfigurationProperties(prefix = "datasource.sample")
    public DataSource getDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public DSLContext getDSLContext(DataSource dataSource) {
        Settings settings = new Settings().withStatementType(StatementType.STATIC_STATEMENT);
        return new DefaultDSLContext(new DefaultConfiguration().derive(SQLDialect.POSTGRES_9_5)
                .derive(dataSource).derive(settings));
    }
}
