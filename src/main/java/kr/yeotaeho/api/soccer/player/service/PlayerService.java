package kr.yeotaeho.api.soccer.player.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.yeotaeho.api.common.domain.Messenger;
import kr.yeotaeho.api.soccer.player.domain.PlayerDTO;

@Service
public interface PlayerService {
    public Messenger saveAll(List<PlayerDTO> playerDTO);

    public Messenger save(PlayerDTO playerDTO);

    public Messenger update(Long id, PlayerDTO playerDTO);

    public Messenger delete(Long id);

    public Messenger findById(Long id);

    public Messenger findAll();
}
