package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.model;

import lombok.*;

import javax.persistence.*;

@Embeddable
@Table(name = "icons")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Icon {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private boolean isOwned;

}
