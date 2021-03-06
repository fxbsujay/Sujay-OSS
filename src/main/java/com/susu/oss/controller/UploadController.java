package com.susu.oss.controller;

import com.susu.oss.common.PageData;
import com.susu.oss.common.Result;
import com.susu.oss.dto.UploadDTO;
import com.susu.oss.service.UploadService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author fxbsujay@gmail.com
 */
@Api(tags = "上传记录")
@RestController
@RequestMapping("upload")
public class UploadController {


    private final UploadService service;

    public UploadController(UploadService service) {
        this.service = service;
    }

    @GetMapping("/page")
    public Result<PageData<UploadDTO>> page(@RequestParam Map<String, Object> params){
        PageData<UploadDTO> page = service.page(params);
        return Result.ok(page);
    }

    @GetMapping("{id}")
    public Result<UploadDTO> info(@PathVariable("id") Long id){
        UploadDTO dto = service.get(id);
        return Result.ok(dto);
    }

    @PostMapping
    public Result<String> save(@RequestBody UploadDTO dto) {
        Boolean flag = service.save(dto);
        if (!flag) {
            return Result.error();
        }
        return Result.ok();
    }

    @PutMapping
    public Result<String> update(@RequestBody UploadDTO dto) {
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
