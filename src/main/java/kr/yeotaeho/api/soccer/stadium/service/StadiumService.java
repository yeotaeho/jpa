package kr.yeotaeho.api.soccer.stadium.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.yeotaeho.api.common.domain.Messenger;
import kr.yeotaeho.api.soccer.stadium.domain.StadiumDTO;

@Service
public interface StadiumService {
    public Messenger saveAll(List<StadiumDTO> stadiumDTO, Model model);

    public Messenger update(StadiumDTO stadiumDTO);

    public Messenger delete(StadiumDTO stadiumDTO);

    public Messenger findById(StadiumDTO stadiumDTO);

    public Messenger findAll(List<StadiumDTO> stadiumDTO);
}
