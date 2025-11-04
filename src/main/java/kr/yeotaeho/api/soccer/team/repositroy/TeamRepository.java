package kr.yeotaeho.api.soccer.team.repositroy;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import kr.yeotaeho.api.common.domain.Messenger;
import kr.yeotaeho.api.soccer.team.domain.TeamDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TeamRepository {

    public Messenger saveAll(List<TeamDTO> teamDTO, Model model) {
        System.out.println("========================================");
        System.out.println("Repository: " + teamDTO.size() + "개의 팀 데이터 저장 완료");
        System.out.println("========================================\n");

        for (int i = 0; i < teamDTO.size(); i++) {
            TeamDTO team = teamDTO.get(i);

            System.out.println("--- 팀 데이터 " + (i + 1) + " ---");
            System.out.println("인덱스: " + team.getIndex());
            System.out.println("팀 이름: " + team.getTeamName());
            System.out.println("창단 연도: " + team.getFoundedYear());
            System.out.println("홈 경기장: " + team.getHomeStadium());
            System.out.println();
        }

        System.out.println("========================================");
        System.out.println("출력 완료");
        System.out.println("========================================\n");

        Messenger messenger = Messenger.builder()
                .code(200)
                .message(teamDTO.size() + "개의 팀 데이터가 저장되었습니다.")
                .data(teamDTO)
                .build();
        model.addAttribute("messenger", messenger);
        model.addAttribute("teamDTO", teamDTO);
        return messenger;
    }

    public Messenger update(TeamDTO teamDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public Messenger delete(TeamDTO teamDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public Messenger findById(TeamDTO teamDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    public Messenger findAll(List<TeamDTO> teamDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}

