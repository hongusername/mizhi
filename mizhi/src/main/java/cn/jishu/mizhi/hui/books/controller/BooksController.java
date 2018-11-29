package cn.jishu.mizhi.hui.books.controller;

import cn.jishu.mizhi.entity.*;
import cn.jishu.mizhi.hui.books.service.BooksService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

@Controller
public class BooksController {
    @Resource
    private BooksService service;

    @RequestMapping("kanshu")
    public String kanshu(Model model, Integer bid, HttpSession session) {
        Users u = (Users) session.getAttribute("user");
        Books b = this.service.queryBooksById(bid);
        if (this.service.queryOrderByBooks(u.getUserid(), b.getBid()) != null) {
            session.setAttribute("shutext", b.getTryread());
        } else {
            int i=400;
            if (b.getTryread().length()<400){
                i=b.getTryread().length()/2;
            }
            String shutext = b.getTryread().substring(0, i);
            session.setAttribute("shutext", shutext);
        }
        return "dushu";
    }

    /**
     * 展示书籍 分类查找
     *
     * @param model
     * @return
     */
    @RequestMapping("bQueryBooksAll")
    public String queryBooksAll(Model model, Integer btid) {
        Books b = new Books();
        Booktype bt = new Booktype();
        if (btid != null) {
            if (btid != 0) {
                bt.setBtid(btid);
                b.setBooktype(bt);
            }
        }
        Random random = new Random();
        int i = random.nextInt(9) + 1;
        model.addAttribute("booksPageInfo", this.service.queryBooksAll(new Books(), i).getList());
        model.addAttribute("booksPageInfo2", this.service.queryBooksAll2(b));
        return "book";
    }

    /**
     * 进入详情页
     *
     * @param model
     * @return
     */
    @RequestMapping("queryBooksById")
    public String queryBooksById(Model model, Integer bid, HttpSession session) {
        session.setAttribute("bid", bid);//保存当前书籍id
        Users u = (Users) session.getAttribute("user");
        if (u != null) {
            if (this.service.queryOrderByBooks(u.getUserid(), bid) != null) {
                model.addAttribute("bool1", "true");
            }
        }
        model.addAttribute("books", this.service.queryBooksById(bid));
        return "bookcommd";
    }

    /**
     * 查看当前用户书架
     *
     * @return
     */
    @RequestMapping("queryBookJia")
    public String myJia(Model model, HttpSession session) {
        Users u = (Users) session.getAttribute("user");
        List<Books> listbooks = this.service.queryJiaAll(u.getUserid());
        model.addAttribute("jia", listbooks);
        return "mybook";
    }

    /* *//**
     * 支付完成后执行的操作
     *
     * @return
     *//*
    @RequestMapping("payIndex")
    public String payIndex(HttpSession session) {
        Integer bid = (Integer) session.getAttribute("bid");
        Integer userid = ((Users) session.getAttribute("user")).getUserid();
        Books b = new Books();
        b.setBid(bid);
        Users u = new Users();
        u.setUserid(userid);
        Orderform o = new Orderform(null, u, b, null, null, "1", this.service.queryBooksById(2002).getNewprice());
        this.service.addOrders(o);
        return "redirect:/queryBooksById?bit=bid";
    }*/
}
