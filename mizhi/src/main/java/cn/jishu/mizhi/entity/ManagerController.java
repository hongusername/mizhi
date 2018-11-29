package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program: mizhi
 * @description: ${description}
 * @author: ShiDunKai
 * @create: 2018-11-29 13:51
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerController {
    private Integer mCid,mCtype,mmid;
    private Date mCtime;
    private String mCcontext;
}
