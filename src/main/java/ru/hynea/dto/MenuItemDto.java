package ru.hynea.dto;

import lombok.*;

@Data
@Builder
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
