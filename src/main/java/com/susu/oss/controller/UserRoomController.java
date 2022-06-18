package com.susu.oss.controller;

import com.susu.oss.common.PageData;
import com.susu.oss.common.Result;
import com.susu.oss.dto.UserRoomDTO;
import com.susu.oss.service.UserRoomService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author fxbsujay@gmail.com
 */
@RestController
@RequestMapping("user_room")
public class UserRoomController {


    private final UserRoomService service;

    public UserRoomController(UserRoomService service) {
        this.service = service;
    }

    @GetMapping("/page")
    public Result<PageData<UserRoomDTO>> page(@RequestParam Map<String, Object> params){
        PageData<UserRoomDTO> page = service.page(params);
        return Result.ok(page);
    }

    @GetMapping("{id}")
    public Result<UserRoomDTO> info(@PathVariable("id") Long id){
        UserRoomDTO dto = service.get(id);
        return Result.ok(dto);
    }

    @PostMapping
    public Result<String> save(@RequestBody UserRoomDTO dto) {
        Boolean flag = service.save(dto);
        if (!flag) {
            return Result.error();
        }
        return Result.ok();
    }

    @PutMapping
    public Result<String> update(@RequestBody UserRoomDTO dto) {
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
