package kr.yeotaeho.api.soccer.player.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Getter, Setter, toString, equals, hashCode 메서드 자동 생성
@NoArgsConstructor // 기본 생성자 자동 생성
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자 자동 생성

public class PlayerDTO {

    private Long id;
    private String player_id;
    private String player_name;
    private String e_player_name;
    private String nickname;
    private String join_yyyy;
    private String position;
    private Integer back_no;
    private String nation;
    private String birth_date;
    private String solar;
    private Integer height;
    private Integer weight;
    private String team_id;

}
