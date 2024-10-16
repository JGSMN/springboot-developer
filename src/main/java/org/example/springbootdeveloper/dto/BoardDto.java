package org.example.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDto {
    private Long id;
    private String writer;
    private String title;
    private String content;
    private String category;
}
