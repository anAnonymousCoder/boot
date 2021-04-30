package com.wqy.boot.core.service;

import com.wqy.boot.common.dto.ResultDTO;

public interface SSHService {

    ResultDTO<String> executeCmd(String cmd);
}
