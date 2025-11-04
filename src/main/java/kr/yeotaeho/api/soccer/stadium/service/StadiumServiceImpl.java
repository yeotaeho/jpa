package kr.yeotaeho.api.soccer.stadium.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.yeotaeho.api.soccer.stadium.repositroy.StadiumRepository;
import kr.yeotaeho.api.soccer.stadium.domain.StadiumDTO;
import kr.yeotaeho.api.common.domain.Messenger;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StadiumServiceImpl implements StadiumService {
    private final StadiumRepository stadiumRepository;

    @Override
    public Messenger saveAll(List<StadiumDTO> stadiumDTO, Model model) {
        System.out.println("========================================");
        System.out.println("Service: " + stadiumDTO.size() + "개의 경기장 데이터를 Repository로 전달");
        System.out.println("========================================\n");

        // StadiumRepository로 데이터 전달
        Messenger messenger = stadiumRepository.saveAll(stadiumDTO, model);

        return messenger;
    }

    @Override
    public Messenger update(StadiumDTO stadiumDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Messenger delete(StadiumDTO stadiumDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Messenger findById(StadiumDTO stadiumDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Messenger findAll(List<StadiumDTO> stadiumDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}
