package com.cloudstorage.item.controller;

import com.cloudstorage.common.pojo.PageResult;
import com.cloudstorage.item.pojo.Brand;
import com.cloudstorage.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wegop
 * @date 2023/9/23 18:25
 */
@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;


    /**
     *
     * @param page 当前页，int
     * @param rows 每页大小，int
     * @param sortBy 排序字段，String
     * @param desc 是否为降序，boolean
     * @param key   搜索条件 搜索关键词，String
     * @return
     * - total：总条数
     * - items：当前页数据
     * - totalPage：有些还需要总页数
     */

    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
            @RequestParam(value = "key", required = false) String key)
    {
        PageResult<Brand> result = this.brandService.queryBrandByPageAndSort(page,rows,sortBy,desc,key);
        //
        if (result == null || result.getItems().size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }
}
