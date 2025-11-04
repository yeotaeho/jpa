package kr.yeotaeho.api.pickpro.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pickpros")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PickProEntity {

    @Id private Long indexId;


    private String parentDepartment;


    private String department;


    private String subDepartment;
}