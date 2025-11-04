package kr.yeotaeho.api.soccer.team.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.yeotaeho.api.soccer.team.repositroy.TeamRepository;
import kr.yeotaeho.api.soccer.team.domain.TeamDTO;
import kr.yeotaeho.api.common.domain.Messenger;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;

    @Override
    public Messenger saveAll(List<TeamDTO> teamDTO, Model model) {
        System.out.println("========================================");
        System.out.println("Service: " + teamDTO.size() + "개의 팀 데이터를 Repository로 전달");
        System.out.println("========================================\n");

        // TeamRepository로 데이터 전달
        Messenger messenger = teamRepository.saveAll(teamDTO, model);

        return messenger;
    }

    @Override
    public Messenger update(TeamDTO teamDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Messenger delete(TeamDTO teamDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Messenger findById(TeamDTO teamDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Messenger findAll(List<TeamDTO> teamDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}
