package kr.yeotaeho.api.soccer.player.controller;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.nio.charset.StandardCharsets;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import kr.yeotaeho.api.soccer.player.domain.PlayerDTO;
import kr.yeotaeho.api.soccer.player.service.PlayerServiceImpl;
import kr.yeotaeho.api.common.domain.Messenger;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/players")
public class PlayerController {
    private final PlayerServiceImpl playerService;

    @GetMapping("")
    public String showPage() {
        return "log/log";
    }

    @PostMapping("")
    public String saveAll(Model model) {
        String csvFilePath = "src/main/resources/static/scv/player.csv";

        List<PlayerDTO> playerDTO = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(csvFilePath);
                Reader reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
                CSVParser csvParser = new CSVParser(reader,
                        CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreSurroundingSpaces().withTrim())) {

            for (CSVRecord record : csvParser) {

                PlayerDTO player = new PlayerDTO();

                // CSV 컬럼 매핑
                player.setPlayer_id(record.get("PLAYER_ID"));
                player.setPlayer_name(record.get("PLAYER_NAME"));
                player.setE_player_name(record.get("E_PLAYER_NAME"));
                player.setNickname(record.get("NICKNAME"));
                player.setJoin_yyyy(record.get("JOIN_YYYY"));
                player.setPosition(record.get("POSITION"));
                player.setBack_no(parseInt(record.get("BACK_NO")));
                player.setNation(record.get("NATION"));
                player.setBirth_date(record.get("BIRTH_DATE"));
                player.setSolar(record.get("SOLAR"));
                player.setHeight(parseInt(record.get("HEIGHT")));
                player.setWeight(parseInt(record.get("WEIGHT")));
                player.setTeam_id(record.get("TEAM_ID"));

                playerDTO.add(player);
            }

            // PlayerService로 데이터 전달
            playerService.saveAll(playerDTO, model);
            return "log/log";
        } catch (Exception e) {
            Messenger messenger = Messenger.builder()
                    .code(500)
                    .message("CSV 파일을 읽는 중 오류가 발생했습니다: " + e.getMessage())
                    .build();
            model.addAttribute("messenger", messenger);
            return "log/log";
        }
    }

    @PutMapping("/{id}")
    public Messenger update(@RequestBody PlayerDTO playerDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @DeleteMapping("/{id}")
    public Messenger delete(@PathVariable String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @GetMapping("/id/{id}")
    public Messenger findById(@PathVariable String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @GetMapping("/all")
    public Messenger findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    private Integer parseInt(String value) {
        try {
            return value != null && !value.isEmpty() ? Integer.parseInt(value.trim()) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
