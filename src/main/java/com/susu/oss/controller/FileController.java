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
        return new Result<PageData<FileDTO>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<FileDTO> info(@PathVariable("id") Long id){
        FileDTO dto = service.get(id);
        return new Result<FileDTO>().ok(dto);
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody FileDTO dto) {
        Boolean flag = service.save(dto);
        return new Result<Boolean>().ok(flag);
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody FileDTO dto) {
        Boolean flag = service.update(dto);
        return new Result<Boolean>().ok(flag);
    }

    @DeleteMapping
    public Result<Integer> delete(@RequestBody Long[] id) {
        Integer flag = service.delete(id);
        return new Result<Integer>().ok(flag);
    }
}
