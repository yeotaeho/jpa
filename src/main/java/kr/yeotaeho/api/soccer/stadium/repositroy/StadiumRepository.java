package kr.yeotaeho.api.soccer.stadium.repositroy;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import kr.yeotaeho.api.common.domain.Messenger;
import kr.yeotaeho.api.soccer.stadium.domain.StadiumDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StadiumRepository {

    public Messenger saveAll(List<StadiumDTO> stadiumDTO, Model model) {
        System.out.println("========================================");
        System.out.println("Repository: " + stadiumDTO.size() + "개의 경기장 데이터 저장 완료");
        System.out.println("========================================\n");

        for (int i = 0; i < stadiumDTO.size(); i++) {
            StadiumDTO stadium = stadiumDTO.get(i);

            System.out.println("--- 경기장 데이터 " + (i + 1) + " ---");
            System.out.println("인덱스: " + stadium.getIndex());
            System.out.println("경기장 이름: " + stadium.getStadiumName());
            System.out.println("위치: " + stadium.getLocation());
            System.out.println("수용 인원: " + stadium.getCapacity());
            System.out.println();
        }

        System.out.println("========================================");
        System.out.println("출력 완료");
        System.out.println("========================================\n");

        Messenger messenger = Messenger.builder()
                .code(200)
                .message(stadiumDTO.size() + "개의 경기장 데이터가 저장되었습니다.")
                .data(stadiumDTO)
                .build();
        model.addAttribute("messenger", messenger);
        model.addAttribute("stadiumDTO", stadiumDTO);
        return messenger;
    }

    public Messenger update(StadiumDTO stadiumDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public Messenger delete(StadiumDTO stadiumDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public Messenger findById(StadiumDTO stadiumDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    public Messenger findAll(List<StadiumDTO> stadiumDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}

