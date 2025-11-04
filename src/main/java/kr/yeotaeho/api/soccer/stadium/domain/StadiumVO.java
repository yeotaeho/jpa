package kr.yeotaeho.api.soccer.stadium.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // 기본 생성자 자동 생성
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자 자동 생성
public class StadiumVO {
    private Integer index;
    private String stadiumName;
    private String location;
    private Integer capacity;
}
