package kr.yeotaeho.api.soccer.player.repositroy;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import kr.yeotaeho.api.common.domain.Messenger;
import kr.yeotaeho.api.soccer.player.domain.PlayerDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PlayerRepository {

    public Messenger saveAll(List<PlayerDTO> playerDTO, Model model) {
        System.out.println("========================================");
        System.out.println("Repository: " + playerDTO.size() + "개의 선수 데이터 저장 완료");
        System.out.println("========================================\n");

        for (int i = 0; i < playerDTO.size(); i++) {
            PlayerDTO player = playerDTO.get(i);

            System.out.println("--- 선수 데이터 " + (i + 1) + " ---");
            System.out.println("선수ID: " + player.getPlayer_id());
            System.out.println("선수명: " + player.getPlayer_name());
            System.out.println("영문명: " + player.getE_player_name());
            System.out.println("별명: " + player.getNickname());
            System.out.println("입단년도: " + player.getJoin_yyyy());
            System.out.println("포지션: " + player.getPosition());
            System.out.println("등번호: " + player.getBack_no());
            System.out.println("국적: " + player.getNation());
            System.out.println("생년월일: " + player.getBirth_date());
            System.out.println("키: " + player.getHeight());
            System.out.println("몸무게: " + player.getWeight());
            System.out.println("팀ID: " + player.getTeam_id());
            System.out.println();
        }

        System.out.println("========================================");
        System.out.println("출력 완료");
        System.out.println("========================================\n");

        Messenger messenger = Messenger.builder()
                .code(200)
                .message(playerDTO.size() + "개의 선수 데이터가 저장되었습니다.")
                .data(playerDTO)
                .build();
        model.addAttribute("messenger", messenger);
        model.addAttribute("playerDTO", playerDTO);
        return messenger;
    }

    public Messenger update(PlayerDTO playerDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public Messenger delete(PlayerDTO playerDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public Messenger findById(PlayerDTO playerDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    public Messenger findAll(List<PlayerDTO> playerDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}
