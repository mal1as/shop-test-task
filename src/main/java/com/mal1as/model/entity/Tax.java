package com.mal1as.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tax")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tax {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code_pattern")
    private String codePattern;

    @Column(name = "country")
    private String country;

    @Column(name = "percent")
    private Integer percent;
}
