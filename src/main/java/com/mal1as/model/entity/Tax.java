package com.mal1as.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tax")
@Getter
@Setter
public class Tax {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code_pattern")
    private String codePattern;

    @Column(name = "percent")
    private Integer percent;
}
