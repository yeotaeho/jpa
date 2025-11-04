package kr.yeotaeho.api.soccer.player.service;

import org.springframework.stereotype.Service;

import kr.yeotaeho.api.soccer.player.repositroy.PlayerRepository;
import kr.yeotaeho.api.soccer.player.domain.PlayerDTO;
import kr.yeotaeho.api.soccer.player.domain.PlayerEntity;
import kr.yeotaeho.api.common.domain.Messenger;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
        private final PlayerRepository playerRepository;

        @Override
        public Messenger saveAll(List<PlayerDTO> playerDTO) {
                System.out.println("========================================");
                System.out.println("Service: " + playerDTO.size() + "개의 선수 데이터를 Repository로 전달");
                System.out.println("========================================\n");

                List<PlayerEntity> entities = playerDTO.stream()
                                .map(dto -> PlayerEntity.builder()
                                                .name(dto.getName())
                                                .position(dto.getPosition())
                                                .number(dto.getNumber())
                                                .team(dto.getTeam())
                                                .build())
                                .collect(Collectors.toList());

                playerRepository.saveAll(entities);

                return Messenger.builder()
                                .code(200)
                                .message(playerDTO.size() + "개의 선수 데이터가 저장되었습니다.")
                                .build();
        }

        @Override
        public Messenger save(PlayerDTO playerDTO) {
                PlayerEntity entity = PlayerEntity.builder()
                                .name(playerDTO.getName())
                                .position(playerDTO.getPosition())
                                .number(playerDTO.getNumber())
                                .team(playerDTO.getTeam())
                                .build();

                playerRepository.save(entity);

                return Messenger.builder()
                                .code(200)
                                .message("선수 데이터가 저장되었습니다.")
                                .build();
        }

        @Override
        public Messenger update(Long id, PlayerDTO playerDTO) {
                Optional<PlayerEntity> optionalPlayer = playerRepository.findById(id);

                if (optionalPlayer.isPresent()) {
                        PlayerEntity entity = optionalPlayer.get();
                        entity.setName(playerDTO.getName());
                        entity.setPosition(playerDTO.getPosition());
                        entity.setNumber(playerDTO.getNumber());
                        entity.setTeam(playerDTO.getTeam());

                        playerRepository.save(entity);

                        return Messenger.builder()
                                        .code(200)
                                        .message("선수 데이터가 수정되었습니다.")
                                        .build();
                } else {
                        return Messenger.builder()
                                        .code(404)
                                        .message("선수를 찾을 수 없습니다.")
                                        .build();
                }
        }

        @Override
        public Messenger delete(Long id) {
                if (playerRepository.existsById(id)) {
                        playerRepository.deleteById(id);
                        return Messenger.builder()
                                        .code(200)
                                        .message("선수 데이터가 삭제되었습니다.")
                                        .build();
                } else {
                        return Messenger.builder()
                                        .code(404)
                                        .message("선수를 찾을 수 없습니다.")
                                        .build();
                }
        }

        @Override
        public Messenger findById(Long id) {
                Optional<PlayerEntity> optionalPlayer = playerRepository.findById(id);

                if (optionalPlayer.isPresent()) {
                        PlayerEntity entity = optionalPlayer.get();
                        PlayerDTO dto = new PlayerDTO(
                                        entity.getId(),
                                        entity.getName(),
                                        entity.getPosition(),
                                        entity.getNumber(),
                                        entity.getTeam());

                        return Messenger.builder()
                                        .code(200)
                                        .message("선수 조회 성공")
                                        .data(dto)
                                        .build();
                } else {
                        return Messenger.builder()
                                        .code(404)
                                        .message("선수를 찾을 수 없습니다.")
                                        .build();
                }
        }

        @Override
        public Messenger findAll() {
                List<PlayerEntity> entities = playerRepository.findAll();
                List<PlayerDTO> dtos = entities.stream()
                                .map(entity -> new PlayerDTO(
                                                entity.getId(),
                                                entity.getName(),
                                                entity.getPosition(),
                                                entity.getNumber(),
                                                entity.getTeam()))
                                .collect(Collectors.toList());

                return Messenger.builder()
                                .code(200)
                                .message("전체 선수 조회 성공")
                                .data(dtos)
                                .build();
        }
}
