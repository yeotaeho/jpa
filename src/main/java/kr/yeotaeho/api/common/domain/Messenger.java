package kr.yeotaeho.api.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Messenger {
    private int code;
    private String message;
    private Object data;
}
