package kr.yeotaeho.api.pickpro.controller;

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
import kr.yeotaeho.api.pickpro.domain.PickProDTO;
import kr.yeotaeho.api.pickpro.service.PickProServiceImpl;
import kr.yeotaeho.api.common.domain.Messenger;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pickpros")
public class PickProController {
    private final PickProServiceImpl pickProService;

    @GetMapping("")
    public String showPage() {
        return "log/log";
    }

    @PostMapping("")
    public String saveAll(Model model) {
        String csvFilePath = "src/main/resources/static/scv/org_chart.csv";

        List<PickProDTO> pickProDTO = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(csvFilePath);
                Reader reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
                CSVParser csvParser = new CSVParser(reader,
                        CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreSurroundingSpaces().withTrim())) {

            for (CSVRecord record : csvParser) {

                PickProDTO pickPro = new PickProDTO();

                // CSV 컬럼 인덱스로 접근
                // 0:index, 1:ParentDepartment, 2:Department, 3:SubDepartment
                pickPro.setIndex(parseInt(record.get(0)));
                pickPro.setParentDepartment(record.get(1));
                pickPro.setDepartment(record.get(2));
                pickPro.setSubDepartment(record.get(3));

                pickProDTO.add(pickPro);
            }

            // PickProService로 데이터 전달
            pickProService.saveAll(pickProDTO, model);
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
    public Messenger update(@RequestBody PickProDTO pickProDTO) {
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