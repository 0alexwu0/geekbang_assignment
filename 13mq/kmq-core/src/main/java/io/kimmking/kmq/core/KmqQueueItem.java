package io.kimmking.kmq.core;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class KmqQueueItem {

    private String body;

    private boolean isRead;
}
