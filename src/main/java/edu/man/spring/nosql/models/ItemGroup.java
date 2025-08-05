package edu.man.spring.nosql.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Getter
@NoArgsConstructor
public class ItemGroup {
    private List<Item> item;
}
