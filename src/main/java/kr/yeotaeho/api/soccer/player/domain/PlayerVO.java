package kr.yeotaeho.api.soccer.player.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // 기본 생성자 자동 생성
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자 자동 생성
public class PlayerVO {
    private Long id;
    private String name;
    private String position;
    private Integer number;
    private String team;
}
