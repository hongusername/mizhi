package cn.jishu.mizhi.hui.books.service;

import cn.jishu.mizhi.entity.Books;
import com.github.pagehelper.PageInfo;

public interface BooksService {
    PageInfo<Books> queryBooksAll(Books books, Integer pageNum);

    Integer addBooks(Books books);
}
