package com.ponshine.oa.common.util;

import com.ponshine.oa.common.dto.PageDTO;
import com.ponshine.oa.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuhui
 * @version V1.0
 * @Title:
 * @Package
 * @Description: TODO
 * @date
 */
public class PageUtil {

    /**
     * page 转 PageDto
     * @param userPage
     * @return
     */
    public static synchronized PageDTO convert2TOPageDto(Page userPage){
        PageDTO pageDTO = new PageDTO();
        pageDTO.setRows(userPage.getContent());
        pageDTO.setTotal((int)userPage.getTotalElements());// 总数据量
        pageDTO.setCurrPage(userPage.getNumber()); // 当前页
        pageDTO.setPageSize(userPage.getSize());
        return pageDTO;
    }


}
