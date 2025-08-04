package edu.man.spring.nosql.repository;

import edu.man.spring.nosql.models.FamilyMember;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FamilyRepository extends MongoRepository<FamilyMember,String> {
}
