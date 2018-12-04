package cn.jishu.mizhi.shuai.cares.services.impl;

import cn.jishu.mizhi.entity.Cares;
import cn.jishu.mizhi.shuai.cares.dao.CaresDaos;
import cn.jishu.mizhi.shuai.cares.services.CaresServicess;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CaresSersvicessImpl implements CaresServicess {
    @Resource
    private CaresDaos dao;

    @Override
    public List<Cares> queryAllGzwdr(Integer userid) {
        return dao.queryAllGzwdr(userid);
    }

    @Override
    public List<Cares> queryAllWgzdr(Integer userid) {
        return dao.queryAllWgzdr(userid);
    }

    @Override
    public Integer guanzhu(Integer userid, Integer buserid) {
        return dao.guanzhu(userid, buserid);
    }

    @Override
    public Integer quxiao(Integer userid, Integer buserid) {
        return dao.quxiao(userid, buserid);
    }
}
