package com.susu.oss.controller;

import com.susu.oss.common.Result;
import com.susu.oss.dto.UserDTO;
import com.susu.oss.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import com.susu.oss.common.PageData;
import java.util.Map;

/**
 * @author fxbsujay@gmail.com
 */
@Api( tags = "用户")
@RestController
@RequestMapping("user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/page")
    public Result<PageData<UserDTO>> page(@RequestParam Map<String, Object> params){
        PageData<UserDTO> page = service.page(params);
        return Result.ok(page);
    }

    @GetMapping("{id}")
    public Result<UserDTO> info(@PathVariable("id") Long id){
        UserDTO dto = service.get(id);
        return Result.ok(dto);
    }

    @PostMapping
    public Result<String> save(@RequestBody UserDTO dto) {
        Boolean flag = service.save(dto);
        if (!flag) {
            return Result.error();
        }
        return Result.ok();
    }

    @PutMapping
    public Result<String> update(@RequestBody UserDTO dto) {
        Boolean flag = service.update(dto);
        if (!flag) {
            return Result.error();
        }
        return Result.ok();
    }

    @DeleteMapping
    public Result<String> delete(@RequestBody Long[] id) {
        service.delete(id);
        return Result.ok();
    }
}
