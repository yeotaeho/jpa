package kr.yeotaeho.api.soccer.team.controller;

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
import kr.yeotaeho.api.soccer.team.domain.TeamDTO;
import kr.yeotaeho.api.soccer.team.service.TeamServiceImpl;
import kr.yeotaeho.api.common.domain.Messenger;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teams")
public class TeamController {
    private final TeamServiceImpl teamService;

    @GetMapping("")
    public String showPage() {
        return "log/log";
    }

    @PostMapping("")
    public String saveAll(Model model) {
        String csvFilePath = "src/main/resources/static/scv/team.csv";

        List<TeamDTO> teamDTO = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(csvFilePath);
                Reader reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
                CSVParser csvParser = new CSVParser(reader,
                        CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreSurroundingSpaces().withTrim())) {

            for (CSVRecord record : csvParser) {

                TeamDTO team = new TeamDTO();

                // CSV 컬럼 인덱스로 접근
                // 0:index, 1:teamName, 2:foundedYear, 3:homeStadium
                team.setIndex(parseInt(record.get(0)));
                team.setTeamName(record.get(1));
                team.setFoundedYear(parseInt(record.get(2)));
                team.setHomeStadium(record.get(3));

                teamDTO.add(team);
            }

            // TeamService로 데이터 전달
            teamService.saveAll(teamDTO, model);
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
    public Messenger update(@RequestBody TeamDTO teamDTO) {
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
