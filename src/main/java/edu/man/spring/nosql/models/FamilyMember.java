package edu.man.spring.nosql.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "family")
public class FamilyMember {
    @Id
    private String id;

    private String name;
    private String relation;
    private String gender;
    private Integer age;
    private Integer sibling;
    private Integer children;
    private Integer score;

    private List<String> colors;
    private List<Integer> vals;

    private Item item;

    private String genderFull;
    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date updatedDate;
}
