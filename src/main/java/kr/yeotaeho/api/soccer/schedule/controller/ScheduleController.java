package kr.yeotaeho.api.soccer.schedule.controller;

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
import kr.yeotaeho.api.soccer.schedule.domain.ScheduleDTO;
import kr.yeotaeho.api.soccer.schedule.service.ScheduleServiceImpl;
import kr.yeotaeho.api.common.domain.Messenger;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleServiceImpl scheduleService;

    @GetMapping("")
    public String showPage() {
        return "log/log";
    }

    @PostMapping("")
    public String saveAll(Model model) {
        String csvFilePath = "src/main/resources/static/scv/schedule.csv";

        List<ScheduleDTO> scheduleDTO = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(csvFilePath);
                Reader reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
                CSVParser csvParser = new CSVParser(reader,
                        CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreSurroundingSpaces().withTrim())) {

            for (CSVRecord record : csvParser) {

                ScheduleDTO schedule = new ScheduleDTO();

                // CSV 컬럼 인덱스로 접근
                // 0:index, 1:matchDate, 2:homeTeam, 3:awayTeam
                schedule.setIndex(parseInt(record.get(0)));
                schedule.setMatchDate(record.get(1));
                schedule.setHomeTeam(record.get(2));
                schedule.setAwayTeam(record.get(3));

                scheduleDTO.add(schedule);
            }

            // ScheduleService로 데이터 전달
            scheduleService.saveAll(scheduleDTO, model);
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
    public Messenger update(@RequestBody ScheduleDTO scheduleDTO) {
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
