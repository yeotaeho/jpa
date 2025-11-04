package kr.yeotaeho.api.pickpro.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.yeotaeho.api.pickpro.repository.PickProRepository;
import kr.yeotaeho.api.pickpro.domain.PickProDTO;
import kr.yeotaeho.api.common.domain.Messenger;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PickProServiceImpl implements PickProService {
    private final PickProRepository pickProRepository;

    @Override
    public Messenger saveAll(List<PickProDTO> pickProDTO, Model model) {
        System.out.println("========================================");
        System.out.println("Service: " + pickProDTO.size() + "개의 조직도 데이터를 Repository로 전달");
        System.out.println("========================================\n");

        // PickProRepository로 데이터 전달
        Messenger messenger = pickProRepository.saveAll(pickProDTO, model);

        return messenger;
    }

    @Override
    public Messenger update(PickProDTO pickProDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Messenger delete(PickProDTO pickProDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Messenger findById(PickProDTO pickProDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Messenger findAll(List<PickProDTO> pickProDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}
