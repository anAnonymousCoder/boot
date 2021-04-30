package com.wqy.boot.common.client;

import com.wqy.boot.common.dto.ResultDTO;
import com.wqy.boot.common.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "core", url = "http://127.0.0.1:8001")
@RequestMapping("/rest/user")
public interface DemoClient {

    @GetMapping("/{username}")
    UserDTO findByUsername(@PathVariable(name = "username") String username);

    @PostMapping
    ResultDTO<UserDTO> saveUser(@RequestBody UserDTO userDTO);
}
