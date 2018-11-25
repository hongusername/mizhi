package cn.jishu.mizhi.hui.books.service.impl;

import cn.jishu.mizhi.entity.Books;
import cn.jishu.mizhi.hui.books.dao.BooksDao;
import cn.jishu.mizhi.hui.books.service.BooksService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {
    @Resource
    private BooksDao booksDao;

    @Override
    public PageInfo<Books> queryBooksAll(Books books, Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<Books> list = this.booksDao.queryBooksAll(books);
        PageInfo<Books> pageInfo = new PageInfo<Books>(list);
        return pageInfo;
    }

    @Override
    public Integer addBooks(Books books) {
        return this.booksDao.addBooks(books);
    }
}
