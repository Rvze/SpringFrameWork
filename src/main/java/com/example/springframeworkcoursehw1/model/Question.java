package com.example.springframeworkcoursehw1.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Question {
    private Long id;
    private String question;

}
