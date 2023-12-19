package com.example.consumer;

import lombok.Data;

@Data
public class ServerVo {
    private String ip;
    private Boolean status;
    private long time;
    public ServerVo() {
    }

    public ServerVo(String ip, Boolean status, long time) {
        this.ip = ip;
        this.status = status;
        this.time = time;
    }
}
