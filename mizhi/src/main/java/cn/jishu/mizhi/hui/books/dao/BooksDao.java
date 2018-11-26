package cn.jishu.mizhi.hui.books.dao;

import cn.jishu.mizhi.entity.Books;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface BooksDao {
    /**
     * 组合查询 根据作者和类型查询，如业务升级查询条件可扩展为其他属性
     * @param
     * @return
     */
    List<Books> queryBooksAll(@Param("b") Books books);

    /**
     * 增加书
     * @param books
     * @return
     */
    Integer addBooks(@Param("b") Books books);

    /**
     *
     */
}
