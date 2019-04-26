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
public class Icons {

    @Column(nullable = false)
    private boolean military;
    @Column(nullable = false)
    private boolean intrigue;
    @Column(nullable = false)
    private boolean power;

}
