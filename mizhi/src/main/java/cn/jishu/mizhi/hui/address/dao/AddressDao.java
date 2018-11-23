package cn.jishu.mizhi.hui.address.dao;

import cn.jishu.mizhi.entity.District;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressDao {
    List<District> queryAll();

    List<District> queryAllById(@Param("id") Integer id);
}
