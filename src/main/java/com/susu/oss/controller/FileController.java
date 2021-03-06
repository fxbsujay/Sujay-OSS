package com.susu.oss.controller;

import com.susu.oss.common.PageData;
import com.susu.oss.common.Result;
import com.susu.oss.dto.FileDTO;
import com.susu.oss.service.FileService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * @author fxbsujay@gmail.com
 */
@Api( tags = "文件表")
@RestController
@RequestMapping("file")
public class FileController {


    private final FileService service;

    public FileController(FileService service) {
        this.service = service;
    }

    @GetMapping("/page")
    public Result<PageData<FileDTO>> page(@RequestParam Map<String, Object> params){
        PageData<FileDTO> page = service.page(params);
        return Result.ok(page);
    }

    @GetMapping("{id}")
    public Result<FileDTO> info(@PathVariable("id") Long id){
        FileDTO dto = service.get(id);
        return Result.ok(dto);
    }

    @PostMapping
    public Result<String> save(@RequestBody FileDTO dto) {
        Boolean flag = service.save(dto);
        if (!flag) {
            return Result.error();
        }
        return Result.ok();
    }

    @PutMapping
    public Result<String> update(@RequestBody FileDTO dto) {
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
