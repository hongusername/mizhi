package cn.jishu.mizhi.hui.address.service.impl;

import cn.jishu.mizhi.entity.District;
import cn.jishu.mizhi.hui.address.dao.AddressDao;
import cn.jishu.mizhi.hui.address.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressDao addressDao;

    @Override
    /**
     * 查询全部省份及直辖市
     */
    public List<District> queryAll() {
        return this.addressDao.queryAll();
    }

    @Override
    /**
     * 查询当前用户选择的地区内的信息
     */
    public List<District> queryAllById(Integer id) {
        return this.addressDao.queryAllById(id);
    }
}
