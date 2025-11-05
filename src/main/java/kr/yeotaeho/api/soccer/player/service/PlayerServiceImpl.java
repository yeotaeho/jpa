package kr.yeotaeho.api.soccer.player.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.yeotaeho.api.soccer.player.repositroy.PlayerRepository;
import kr.yeotaeho.api.soccer.player.domain.PlayerDTO;
import kr.yeotaeho.api.common.domain.Messenger;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
        private final PlayerRepository playerRepository;

        @Override
        public Messenger saveAll(List<PlayerDTO> playerDTO, Model model) {
                System.out.println("========================================");
                System.out.println("Service: " + playerDTO.size() + "개의 선수 데이터를 Repository로 전달");
                System.out.println("========================================\n");

                // PlayerRepository로 데이터 전달
                Messenger messenger = playerRepository.saveAll(playerDTO, model);

                return messenger;
        }

        @Override
        public Messenger update(PlayerDTO playerDTO) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'update'");
        }

        @Override
        public Messenger delete(PlayerDTO playerDTO) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'delete'");
        }

        @Override
        public Messenger findById(PlayerDTO playerDTO) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'findById'");
        }

        @Override
        public Messenger findAll(List<PlayerDTO> playerDTO) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'findAll'");
        }
}
