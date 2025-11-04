package kr.yeotaeho.api.soccer.stadium.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "stadiums")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StadiumEntity {

    @Id private Long indexId;


    private String stadiumName;


    private String location;


    private Integer capacity;
}

