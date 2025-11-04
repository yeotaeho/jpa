package kr.yeotaeho.api.soccer.schedule.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.yeotaeho.api.soccer.schedule.repositroy.ScheduleRepository;
import kr.yeotaeho.api.soccer.schedule.domain.ScheduleDTO;
import kr.yeotaeho.api.common.domain.Messenger;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Override
    public Messenger saveAll(List<ScheduleDTO> scheduleDTO, Model model) {
        System.out.println("========================================");
        System.out.println("Service: " + scheduleDTO.size() + "개의 일정 데이터를 Repository로 전달");
        System.out.println("========================================\n");

        // ScheduleRepository로 데이터 전달
        Messenger messenger = scheduleRepository.saveAll(scheduleDTO, model);

        return messenger;
    }

    @Override
    public Messenger update(ScheduleDTO scheduleDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Messenger delete(ScheduleDTO scheduleDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Messenger findById(ScheduleDTO scheduleDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Messenger findAll(List<ScheduleDTO> scheduleDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}
