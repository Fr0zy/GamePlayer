package com.example.gameplayer.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long score;

    @OneToOne
    @JoinColumn(name = "users_id")
    private Users users;

    public Score(Long score, Users users) {
        this.score = score;
        this.users = users;
    }

    public Score() {
    }
}
