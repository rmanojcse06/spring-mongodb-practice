package edu.man.spring.nosql.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@lombok.Setter
@lombok.Getter
@lombok.ToString
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@Document("person")
public class Person {
    @Id
    private String id;
    private String name;
    private int age;
    private String email;
}
