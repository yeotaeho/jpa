package kr.yeotaeho.api.soccer.schedule.repositroy;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import kr.yeotaeho.api.common.domain.Messenger;
import kr.yeotaeho.api.soccer.schedule.domain.ScheduleDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ScheduleRepository {

    public Messenger saveAll(List<ScheduleDTO> scheduleDTO, Model model) {
        System.out.println("========================================");
        System.out.println("Repository: " + scheduleDTO.size() + "개의 일정 데이터 저장 완료");
        System.out.println("========================================\n");

        for (int i = 0; i < scheduleDTO.size(); i++) {
            ScheduleDTO schedule = scheduleDTO.get(i);

            System.out.println("--- 일정 데이터 " + (i + 1) + " ---");
            System.out.println("인덱스: " + schedule.getIndex());
            System.out.println("경기 날짜: " + schedule.getMatchDate());
            System.out.println("홈팀: " + schedule.getHomeTeam());
            System.out.println("원정팀: " + schedule.getAwayTeam());
            System.out.println();
        }

        System.out.println("========================================");
        System.out.println("출력 완료");
        System.out.println("========================================\n");

        Messenger messenger = Messenger.builder()
                .code(200)
                .message(scheduleDTO.size() + "개의 일정 데이터가 저장되었습니다.")
                .data(scheduleDTO)
                .build();
        model.addAttribute("messenger", messenger);
        model.addAttribute("scheduleDTO", scheduleDTO);
        return messenger;
    }

    public Messenger update(ScheduleDTO scheduleDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public Messenger delete(ScheduleDTO scheduleDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public Messenger findById(ScheduleDTO scheduleDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    public Messenger findAll(List<ScheduleDTO> scheduleDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}

