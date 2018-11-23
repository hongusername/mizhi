package cn.jishu.mizhi.hui.address.service;

import cn.jishu.mizhi.entity.District;

import java.util.List;
public interface AddressService {
    List<District> queryAll();

    List<District> queryAllById(Integer id);
}
