package kr.yeotaeho.api.soccer.schedule.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import kr.yeotaeho.api.soccer.stadium.domain.Stadium;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "schedules")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Schedule {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String scheDate;        
    private String gubun;         
    private String hometeamId;   
    private String awayteamId;   
    private Integer homeScore;    
    private Integer awayScore;     
    
    @ManyToOne
    @JoinColumn(name = "stadiumId")
    private Stadium stadium;


}
