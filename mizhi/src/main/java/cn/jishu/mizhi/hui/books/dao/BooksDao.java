package cn.jishu.mizhi.hui.books.dao;

import cn.jishu.mizhi.entity.Books;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface BooksDao {

    List<Books> queryBooksAll(@Param("b") Books books);

    Integer addBooks(@Param("b") Books books);
}
