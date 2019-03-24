package study.basecamp.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Number {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number")
    private int number;

}
