package edu.man.spring.nosql.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Slf4j
@Configuration
@PropertySource("classpath:mongodb.properties")
@ComponentScan(basePackages = "edu.man.spring.nosql")
@EnableMongoRepositories(basePackages = "edu.man.spring.nosql.repository")
public class MongoConfig {

    @Value("${edu.nosql.mongodb.host}")
    private String mongoHost;
    @Value("${edu.nosql.mongodb.port}")
    private int mongoPort;
    @Value("${edu.nosql.mongodb.database}")
    private String databaseName;
    @Value("${edu.nosql.mongodb.username}")
    private String username;
    @Value("${edu.nosql.mongodb.password}")
    private String password;

    @Bean
    public MongoClient mongoClient() {
        String uri = String.format("mongodb://%s:%s@%s:%d", username, password, mongoHost, mongoPort);
        log.info("Connecting to MongoDB at URI: {}", uri);
        return MongoClients.create(uri); // Driver 5.x friendly
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, databaseName);
    }

}
