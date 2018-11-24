package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resources {//资源表
    private Integer riid;//主键
    private String rtname;//资源名称
    private Integer rscore;//资源分数
    private String rdescription;//资源描述
    private Users users;//外键 用户编号
    private Resouurcetype resouurcetype;
    private Integer downloadcount;//被下载次数
}
