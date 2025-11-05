package kr.yeotaeho.api.soccer.player.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.yeotaeho.api.common.domain.Messenger;
import kr.yeotaeho.api.soccer.player.domain.PlayerDTO;

@Service
public interface PlayerService {
    public Messenger saveAll(List<PlayerDTO> playerDTO, Model model);

    public Messenger update(PlayerDTO playerDTO);

    public Messenger delete(PlayerDTO playerDTO);

    public Messenger findById(PlayerDTO playerDTO);

    public Messenger findAll(List<PlayerDTO> playerDTO);
}
