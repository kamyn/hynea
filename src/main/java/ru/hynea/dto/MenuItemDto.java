package ru.hynea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemDto {
    private Long id;

    private String title;

    private Integer serveTime;

    private Integer weight;

    private Integer price;

    private String ingredients;

    private String imageName;
}
