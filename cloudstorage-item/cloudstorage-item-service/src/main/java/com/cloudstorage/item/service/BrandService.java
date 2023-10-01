package com.cloudstorage.item.service;

import com.cloudstorage.common.pojo.PageResult;
import com.cloudstorage.item.mapper.BrandMapper;
import com.cloudstorage.item.pojo.Brand;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author wegop
 * @date 2023/9/23 18:25
 */
@Service
public class BrandService {
    @Autowired
    private BrandMapper brandMapper;

    /**
     *
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @param key
     * @return
     */
    public PageResult<Brand> queryBrandByPageAndSort(
            Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        // 开始分页
        PageHelper.startPage(page, rows);
        // 过滤
        // 初始化Example对象
        Example example = new Example(Brand.class);
        // 判断查询条件是否为null则查询所有
        if (StringUtils.isNotBlank(key)) {
            example.createCriteria().andLike("name", "%" + key + "%")
                    .orEqualTo("letter", key);
        }
        if (StringUtils.isNotBlank(sortBy)) {
            // 排序
            String orderByClause = sortBy + (desc ? " DESC" : " ASC");
            example.setOrderByClause(orderByClause);
        }
        // 查询
        List<Brand>  brands = this.brandMapper.selectByExample(example);
        PageInfo<Brand> pageInfo = new PageInfo<>(brands);

        // 返回结果
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }
}
