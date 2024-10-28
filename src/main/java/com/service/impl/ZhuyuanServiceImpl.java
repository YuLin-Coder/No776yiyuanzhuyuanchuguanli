package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.ZhuyuanDao;
import com.entity.ZhuyuanEntity;
import com.service.ZhuyuanService;
import com.entity.view.ZhuyuanView;

/**
 * 住院 服务实现类
 * @author 
 * @since 2021-04-08
 */
@Service("zhuyuanService")
@Transactional
public class ZhuyuanServiceImpl extends ServiceImpl<ZhuyuanDao, ZhuyuanEntity> implements ZhuyuanService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ZhuyuanView> page =new Query<ZhuyuanView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
