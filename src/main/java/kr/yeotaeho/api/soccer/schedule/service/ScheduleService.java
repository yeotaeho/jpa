package kr.yeotaeho.api.soccer.schedule.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.yeotaeho.api.common.domain.Messenger;
import kr.yeotaeho.api.soccer.schedule.domain.ScheduleDTO;

@Service
public interface ScheduleService {
    public Messenger saveAll(List<ScheduleDTO> scheduleDTO, Model model);

    public Messenger update(ScheduleDTO scheduleDTO);

    public Messenger delete(ScheduleDTO scheduleDTO);

    public Messenger findById(ScheduleDTO scheduleDTO);

    public Messenger findAll(List<ScheduleDTO> scheduleDTO);
}
