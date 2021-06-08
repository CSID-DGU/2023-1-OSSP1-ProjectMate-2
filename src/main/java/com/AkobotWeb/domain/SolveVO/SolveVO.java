package com.AkobotWeb.domain.SolveVO;

import com.google.cloud.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolveVO {
    private Long bno;
    private String content;
    private String name;
    private String phone;
    private String answer;
    private Timestamp regDate;
}
