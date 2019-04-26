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
public class PlotStats {

    @Column(nullable = false)
    private Integer income;
    @Column(nullable = false)
    private Integer initiative;
    @Column(nullable = false)
    private Integer claim;
    @Column(nullable = false)
    private Integer reserve;

}
