package cn.jishu.mizhi.shuai.users.controller;

import cn.jishu.mizhi.entity.Users;
import cn.jishu.mizhi.shuai.users.services.UsersServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class BjImgController {
    @Resource
    private UsersServices services;

    @RequestMapping("bjimgController")
    public String imgFile(@RequestParam(value = "file", required = false) MultipartFile file,
                          HttpServletRequest request, HttpSession session) {
        // ****************
        String path = request.getSession().getServletContext().getRealPath("/image/bjImg");
        System.out.println(path);
        // 1.输入路径
        File target = new File(path);
        // 2.判断路径是否存在
        if (!target.exists()) {
            // 3.不存在创建
            target.mkdirs();
        }
        // (1)获取文件后缀****************
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.indexOf(".") + 1, fileName.length());
        // (2)获取系统时间
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String sj = df.format(new Date());
        // (3)合成文件名****************
        String urlName = sj + "." + suffix;
        try {
            // 合成输出 文件路径+文件名称
            FileOutputStream out = new FileOutputStream(path + "//" + urlName);
            out.write(file.getBytes());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Users user = (Users) session.getAttribute("user");
        user.setHomepageimg(urlName);
        services.updateBj(user);
        session.setAttribute("user", user);
        return "geren.html";
    }
    @RequestMapping("updateTouxiang")
    public String updateTouxiang(@RequestParam(value = "file", required = false) MultipartFile file,
                          HttpServletRequest request, HttpSession session) {
        // ****************
        String path = request.getSession().getServletContext().getRealPath("/image/touXiang");
        System.out.println(path);
        // 1.输入路径
        File target = new File(path);
        // 2.判断路径是否存在
        if (!target.exists()) {
            // 3.不存在创建
            target.mkdirs();
        }
        // (1)获取文件后缀****************
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.indexOf(".") + 1, fileName.length());
        // (2)获取系统时间
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String sj = df.format(new Date());
        // (3)合成文件名****************
        String urlName = sj + "." + suffix;
        try {
            // 合成输出 文件路径+文件名称
            FileOutputStream out = new FileOutputStream(path + "//" + urlName);
            out.write(file.getBytes());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Users user = (Users) session.getAttribute("user");
        user.setHeadimg(urlName);
        services.updateTouxiang(user);
        session.setAttribute("user", user);
        return "geren.html";
    }
}
