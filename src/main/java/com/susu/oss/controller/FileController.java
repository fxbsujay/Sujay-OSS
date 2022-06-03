package com.susu.oss.controller;

import com.susu.oss.common.PageData;
import com.susu.oss.common.Query;
import com.susu.oss.common.Result;
import com.susu.oss.dto.FileDTO;
import com.susu.oss.service.FileService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author fxbsujay@gmail.com
 */
@RestController
@RequestMapping("file")
public class FileController {


    private final FileService service;

    public FileController(FileService service) {
        this.service = service;
    }

    @GetMapping("/page")
    public Result page(@RequestParam Map<String, Object> params){
        PageData<FileDTO> page = service.page(new Query(params));
        return Result.ok(page);
    }

    @GetMapping("{id}")
    public Result info(@PathVariable("id") Long id){
        FileDTO dto = service.info(id);
        return Result.ok(dto);
    }

    @PostMapping
    public Result save(@RequestBody FileDTO dto) {
        Boolean flag = service.save(dto);
        if (!flag) {
            return Result.error();
        }
        return Result.ok();
    }

    @PutMapping
    public Result update(@RequestBody FileDTO dto) {
        Boolean flag = service.update(dto);
        if (!flag) {
            return Result.error();
        }
        return Result.ok();
    }

    @DeleteMapping
    public Result delete(@RequestBody Long[] id) {
        service.delete(id);
        return Result.ok();
    }
}
