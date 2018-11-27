package cn.jishu.mizhi.hui.books.service;

import cn.jishu.mizhi.entity.Bookrack;
import cn.jishu.mizhi.entity.Books;
import cn.jishu.mizhi.entity.Orderform;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BooksService {
    /**
     * 查询书
     *
     * @param books
     * @param pageNum
     * @return
     */
    PageInfo<Books> queryBooksAll(Books books, Integer pageNum);

    /**
     * 增加书
     *
     * @param books
     * @return
     */
    Integer addBooks(Books books);

    /**
     * 根据id查询一本书
     *
     * @param id
     * @return
     */
    Books queryBooksById(@Param("id") Integer id);

    /**
     * 根据名称查询一本书
     *
     * @param name
     * @return
     */
    Books queryBooksByName(@Param("name") String name);

    /**
     * 查询客户书架的书
     *
     * @return
     */
    List<Books> queryJiaAll(@Param("id") Integer userid);

    /**
     * 给当前用户的书架增加一本书
     *
     * @return
     */
    Integer addJia(@Param("j") Bookrack bookrack);

    /**
     * 删除当前用户的书架内的一本书
     *
     * @param uid
     * @param bid
     * @return
     */
    Integer deleteJia(@Param("uid") Integer uid, @Param("bid") Integer bid);

    /**
     * 购买书籍，在订单表增加一条购买记录
     *
     * @param orderform
     * @return
     */
    Integer addOrders(@Param("o") Orderform orderform);

    /**
     * 查询当前用户是否购买了当前书籍
     *
     * @param uid
     * @param bid
     * @return
     */
    Orderform queryOrderByBooks(@Param("uid") Integer uid, @Param("bid") Integer bid);

    /**
     * 查询所有订单信息，组合查询当前用户订单
     *
     * @return
     */
    List<Orderform> queryOrderAllByUserId(Integer uid);
}
