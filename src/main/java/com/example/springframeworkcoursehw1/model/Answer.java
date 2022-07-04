package com.example.springframeworkcoursehw1.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Answer {
    private Long id;
    private Boolean answer;
    private String ans;
}
