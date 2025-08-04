package edu.man.spring.nosql.service;

import edu.man.spring.nosql.repository.FamilyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FamilyService {
    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public void printAllFamilyMembers() {
        log.info("Printing all family members:");
        familyRepository.findAll().forEach(f -> log.info("Family: {}", f));
    }

    public void printAverageAgeByGender() {
        log.info("Printing Average Age by Gender - Grouping:");
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("gender")
                        .avg("age").as("averageAge")
                        .count().as("count"),
                Aggregation.project("averageAge", "count").and("gender").previousOperation()
        );

        AggregationResults<Document> result = mongoTemplate.aggregate(
                aggregation,
                "family",
                Document.class
        );
        result.forEach(f -> log.info("Family : {}", f));
    }
}
