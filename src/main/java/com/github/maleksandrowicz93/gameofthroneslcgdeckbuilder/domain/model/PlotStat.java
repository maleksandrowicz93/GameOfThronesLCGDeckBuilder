package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.model;

import lombok.*;

import javax.persistence.*;

@Embeddable
@Table(name = "plot_stats")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PlotStat {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int value;

}
