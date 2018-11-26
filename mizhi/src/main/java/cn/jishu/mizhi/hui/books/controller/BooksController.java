package cn.jishu.mizhi.hui.books.controller;

import cn.jishu.mizhi.entity.Books;
import cn.jishu.mizhi.hui.books.service.BooksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class BooksController {
    @Resource
    private BooksService service;

    @RequestMapping("bQueryBooksAll")
    public String queryBooksAll(Model model) {
        model.addAttribute("booksPageInfo", this.service.queryBooksAll(new Books(), 1).getList());
        return "book";
    }
}
