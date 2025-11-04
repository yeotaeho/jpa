package kr.yeotaeho.api.soccer.team.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.yeotaeho.api.common.domain.Messenger;
import kr.yeotaeho.api.soccer.team.domain.TeamDTO;

@Service
public interface TeamService {
    public Messenger saveAll(List<TeamDTO> teamDTO, Model model);

    public Messenger update(TeamDTO teamDTO);

    public Messenger delete(TeamDTO teamDTO);

    public Messenger findById(TeamDTO teamDTO);

    public Messenger findAll(List<TeamDTO> teamDTO);
}
