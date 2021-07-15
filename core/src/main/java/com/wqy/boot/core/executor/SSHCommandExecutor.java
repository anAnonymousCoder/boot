package com.wqy.boot.core.executor;

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import com.wqy.boot.common.dto.ResultDTO;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * 远程连接服务器执行命令工具类
 *
 * @author wqy
 * @version 1.0 2021/3/16
 */
public class SSHCommandExecutor {

    private static final Logger logger = LoggerFactory.getLogger(SSHCommandExecutor.class);

    /**
     * 远程连接
     */
    private Connection connection;

    /**
     * 远程机器IP
     */
    private final String hostIp;

    /**
     * 用户名
     */
    private final String username;

    /**
     * 密码
     */
    private final String password;

    /**
     * 超时时长
     */
    private static final long TIME_OUT = 1000 * 20L;

    public SSHCommandExecutor(String hostIp, String username, String password) {
        this.hostIp = hostIp;
        this.username = username;
        this.password = password;
    }

    /**
     * 新建会话
     *
     * @return 新建会话结果
     */
    public Session openSession() {
        try {
            connection = new Connection(hostIp);
            connection.connect();
            // 登录
            boolean authentication = connection.authenticateWithPassword(username, password);
            if (authentication) {
                // 开启会话
                Session session = connection.openSession();
                logger.info("Session opened successfully, hostIp: {}", hostIp);
                return session;
            } else {
                throw new RuntimeException("SSH authentication failed, hostIp: " + hostIp);
            }
        } catch (Exception e) {
            if (connection != null) {
                connection.close();
            }
            logger.error("SSH connection failed, error: {}", e.getLocalizedMessage());
            return null;
        }
    }

    /**
     * 执行命令
     *
     * @param command 命令
     * @return 终端输出
     */
    public ResultDTO<String> execute(String command) {
        InputStream stdout = null;
        InputStream stderr = null;
        Session session = openSession();
        if (session == null) {
            return ResultDTO.failure("Failed to open session", "");
        }
        try {
            logger.debug("Start to execute command: {}", command);
            session.execCommand(command);
            // 终端输出信息
            stdout = new StreamGobbler(session.getStdout());
            // 调试信息
            stderr = new StreamGobbler(session.getStderr());
            session.waitForCondition(ChannelCondition.CLOSED | ChannelCondition.EOF | ChannelCondition.EXIT_STATUS, TIME_OUT);
            Integer ext = session.getExitStatus() != null ? session.getExitStatus() : 0;
            logger.info("Exit with status {}.", ext);
            String out = IOUtils.toString(stdout, StandardCharsets.UTF_8);
            String error = IOUtils.toString(stderr, StandardCharsets.UTF_8);
            if (StringUtils.isBlank(error)) {
                return ResultDTO.success("SSH command execution succeeded", out);
            } else {
                return ResultDTO.failure("SSH command execution failed", error);
            }
        } catch (IOException e) {
            logger.error("An exception occurred while executing the command, error: {}", e.getLocalizedMessage());
            return ResultDTO.failure("An exception occurred while executing the command", "");
        } finally {
            if (connection != null) {
                connection.close();
            }
            closeQuietly(stdout);
            closeQuietly(stderr);
        }
    }


    /**
     * 执行一组命令
     *
     * @param commandArray 命令字符串数组
     * @return 执行结果
     */
    public ResultDTO<String> executeCommand(String... commandArray) {
        String command = StringUtils.join(commandArray, ';');
        if (StringUtils.isBlank(command.replace(";", ""))) {
            logger.error("Cannot execute empty command");
            return ResultDTO.failure("Cannot execute empty command", "");
        }
        return execute(command);
    }

    /**
     * 执行shell命令
     *
     * @param commandArray 命令字符串数组
     * @return 执行结果
     */
    public ResultDTO<String> executeShell(String... commandArray) {
        if (commandArray == null || commandArray.length == 0) {
            logger.error("Cannot execute empty command");
            return ResultDTO.failure("Cannot execute empty command", "");
        }
        return execute(commandArray);
    }

    /**
     * 新建虚拟终端执行命令
     *
     * @param commandArray 命令字符串数组
     * @return 执行结果
     */
    public ResultDTO<String> execute(String... commandArray) {
        return null;
    }


    /**
     * 关闭源
     *
     * @param closeable 源
     */
    public void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }

    public static void main(String[] args) {
        SSHCommandExecutor executor = new SSHCommandExecutor("192.168.2.52", "root", "gtis@123");
        System.out.println(executor.executeCommand("systemctl stop firewalld"));
    }

}
