package com.wqy.boot.core.service.impl;

import com.wqy.boot.common.dto.ResultDTO;
import com.wqy.boot.core.executor.SSHCommandExecutor;
import com.wqy.boot.core.service.SSHService;
import org.springframework.stereotype.Service;

@Service
public class SSHServiceImpl implements SSHService {

    @Override
    public ResultDTO<String> executeCmd(String cmd) {
        SSHCommandExecutor executor = new SSHCommandExecutor("192.168.2.195", "root", "abc123!@#");
        return executor.executeCommand(cmd);
    }
}
