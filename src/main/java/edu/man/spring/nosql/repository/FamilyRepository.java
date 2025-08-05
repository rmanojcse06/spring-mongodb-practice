package edu.man.spring.nosql.repository;

import edu.man.spring.nosql.models.FamilyMember;
import edu.man.spring.nosql.models.ItemGroup;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FamilyRepository extends MongoRepository<FamilyMember, String> {
    @Aggregation(pipeline = {
            "{ '$unwind': { 'path': '$item' } }",
            "{ '$match': { 'item.qty2': { '$gt': 15 } } }",
            "{ '$group': { '_id': '$_id', 'item': { '$push': '$item' } } }",
            "{ '$project': { 'item': 1, '_id': 0 } }"
    })
    List<ItemGroup> itemsGroupedByPerson();
}
