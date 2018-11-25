package cn.jishu.mizhi;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@SpringBootApplication
@MapperScan("cn.jishu.mizhi.*.*.dao")
public class MizhiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MizhiApplication.class, args);
    }

    /**
     * 配置mybatis的分页插件pageHelper
     *
     * @return
     */
    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        java.util.Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("dialect", "mysql");//配置mysql数据库的方言
        pageHelper.setProperties(properties);
        return pageHelper;
    }



}
