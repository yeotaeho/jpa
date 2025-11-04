package kr.yeotaeho.api.pickpro.repository;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import kr.yeotaeho.api.common.domain.Messenger;
import kr.yeotaeho.api.pickpro.domain.PickProDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PickProRepository {

    public Messenger saveAll(List<PickProDTO> pickProDTO, Model model) {
        System.out.println("========================================");
        System.out.println("Repository: " + pickProDTO.size() + "개의 조직도 데이터 저장 완료");
        System.out.println("========================================\n");

        for (int i = 0; i < pickProDTO.size(); i++) {
            PickProDTO pickPro = pickProDTO.get(i);

            System.out.println("--- 조직도 데이터 " + (i + 1) + " ---");
            System.out.println("인덱스: " + pickPro.getIndex());
            System.out.println("상위 부서: " + pickPro.getParentDepartment());
            System.out.println("부서: " + pickPro.getDepartment());
            System.out.println("하위 부서: " + pickPro.getSubDepartment());
            System.out.println();
        }

        System.out.println("========================================");
        System.out.println("출력 완료");
        System.out.println("========================================\n");

        Messenger messenger = Messenger.builder()
                .code(200)
                .message(pickProDTO.size() + "개의 조직도 데이터가 저장되었습니다.")
                .data(pickProDTO)
                .build();
        model.addAttribute("messenger", messenger);
        model.addAttribute("pickProDTO", pickProDTO);
        return messenger;
    }

    public Messenger update(PickProDTO pickProDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public Messenger delete(PickProDTO pickProDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public Messenger findById(PickProDTO pickProDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    public Messenger findAll(List<PickProDTO> pickProDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}
