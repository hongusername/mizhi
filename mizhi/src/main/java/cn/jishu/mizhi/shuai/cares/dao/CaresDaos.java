package cn.jishu.mizhi.shuai.cares.dao;

import cn.jishu.mizhi.entity.Cares;

import java.util.List;

public interface CaresDaos {
    List<Cares> queryAllGzwdr(Integer userid);

    List<Cares> queryAllWgzdr(Integer userid);

    Integer guanzhu(Integer userid, Integer buserid);

    Integer quxiao(Integer userid, Integer buserid);
}
