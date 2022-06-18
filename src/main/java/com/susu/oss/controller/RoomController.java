package com.susu.oss.controller;

import com.susu.oss.common.PageData;
import com.susu.oss.common.Result;
import com.susu.oss.dto.RoomDTO;
import com.susu.oss.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author fxbsujay@gmail.com
 */
@RestController
@RequestMapping("room")
public class RoomController {


    private final RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @GetMapping("/page")
    public Result<PageData<RoomDTO>> page(@RequestParam Map<String, Object> params){
        PageData<RoomDTO> page = service.page(params);
        return Result.ok(page);
    }

    @GetMapping("{id}")
    public Result<RoomDTO> info(@PathVariable("id") Long id){
        RoomDTO dto = service.get(id);
        return Result.ok(dto);
    }

    @PostMapping
    public Result<String> save(@RequestBody RoomDTO dto) {
        Boolean flag = service.save(dto);
        if (!flag) {
            return Result.error();
        }
        return Result.ok();
    }

    @PutMapping
    public Result<String> update(@RequestBody RoomDTO dto) {
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
