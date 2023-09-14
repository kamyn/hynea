package ru.hynea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BreakfastItemDto {
    private Long id;

    private String title;

    private Integer price;

    private String imageName;

    private HashMap<Long, String> menuItemsList;
}
