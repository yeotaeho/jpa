package kr.yeotaeho.api.pickpro.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.yeotaeho.api.common.domain.Messenger;
import kr.yeotaeho.api.pickpro.domain.PickProDTO;

@Service
public interface PickProService {
    public Messenger saveAll(List<PickProDTO> pickProDTO, Model model);

    public Messenger update(PickProDTO pickProDTO);

    public Messenger delete(PickProDTO pickProDTO);

    public Messenger findById(PickProDTO pickProDTO);

    public Messenger findAll(List<PickProDTO> pickProDTO);
}
