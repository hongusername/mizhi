package cn.jishu.mizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.jishu.mizhi.*.*.dao")
public class MizhiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MizhiApplication.class, args);
    }
}
