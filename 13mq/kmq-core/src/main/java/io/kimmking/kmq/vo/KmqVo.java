package io.kimmking.kmq.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class KmqVo {

    private int start;

    private int size;

    private String topic;

    private String msg;
}
