package edu.man.spring.nosql.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
public class Item {
    private List<String> colors;
    private List<Integer> price;

    @Field("qty2")
    private Integer qty2;
}
