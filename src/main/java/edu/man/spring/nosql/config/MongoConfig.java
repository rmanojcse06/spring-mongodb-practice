package edu.man.spring.nosql.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "edu.man.spring.nosql")
@EnableMongoRepositories(basePackages = "edu.man.spring.nosql.repository")
public class MongoConfig {

    @Value("${mongodb.host}")
    private String mongoHost;
    @Value("${mongodb.port}")
    private int mongoPort;
    @Value("${mongodb.database}")
    private String databaseName;

    @Bean
    public MongoClient mongoClient() {
        String uri = String.format("mongodb://%s:%d", host, port);
        return MongoClients.create(uri); // Driver 5.x friendly
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, databaseName);
    }

}
