package kr.yeotaeho.api.soccer.player.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.yeotaeho.api.soccer.player.domain.PlayerDTO;
import kr.yeotaeho.api.soccer.player.service.PlayerServiceImpl;
import kr.yeotaeho.api.common.domain.Messenger;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/players")
public class PlayerController {
    private final PlayerServiceImpl playerService;

    @PostMapping("/batch")
    public Messenger saveAll(@RequestBody List<PlayerDTO> playerDTOs) {
        return playerService.saveAll(playerDTOs);
    }

    @PostMapping("")
    public Messenger save(@RequestBody PlayerDTO playerDTO) {
        return playerService.save(playerDTO);
    }

    @PutMapping("/{id}")
    public Messenger update(@PathVariable Long id, @RequestBody PlayerDTO playerDTO) {
        return playerService.update(id, playerDTO);
    }

    @DeleteMapping("/{id}")
    public Messenger delete(@PathVariable Long id) {
        return playerService.delete(id);
    }

    @GetMapping("/{id}")
    public Messenger findById(@PathVariable Long id) {
        return playerService.findById(id);
    }

    @GetMapping("")
    public Messenger findAll() {
        return playerService.findAll();
    }
}
