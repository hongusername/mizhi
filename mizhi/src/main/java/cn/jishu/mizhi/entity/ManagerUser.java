package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: mizhi
 * @description: ${description}
 * @author: ShiDunKai
 * @create: 2018-11-29 13:47
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerUser {
    private Integer mUid;
    private String mUserName,mPassword;
    private List<ManagerController> managerControllerList;
}
