package cn.jishu.mizhi.hui.books.dao;

import cn.jishu.mizhi.entity.Bookrack;
import cn.jishu.mizhi.entity.Books;
import cn.jishu.mizhi.entity.Orderform;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BooksDao {
    /**
     * 组合查询 根据作者和类型查询，如业务升级查询条件可扩展为其他属性
     *
     * @param
     * @return
     */
    List<Books> queryBooksAll(@Param("b") Books books);//测试已通过

    /**
     * 根据id查询一本书
     *
     * @param id
     * @return
     */
    Books queryBooksById(@Param("id") Integer id);//测试已通过

    /**
     * 根据名称查询一本书
     *
     * @param name
     * @return
     */
    Books queryBooksByName(@Param("name") String name);//测试已通过

    /**
     * 增加书
     *
     * @param books
     * @return
     */
    Integer addBooks(@Param("b") Books books);//测试已通过

    /**
     * 查询客户书架的书
     *
     * @return
     */
    List<Books> queryJiaAll(@Param("id") Integer userid);//测试已通过

    /**
     * 给当前用户的书架增加一本书
     *
     * @return
     */
    Integer addJia(@Param("j") Bookrack bookrack);//测试已通过

    /**
     * 删除当前用户的书架内的一本书
     *
     * @param uid
     * @param bid
     * @return
     */
    Integer deleteJia(@Param("uid") Integer uid, @Param("bid") Integer bid);//测试已通过

    /**
     * 购买书籍，在订单表增加一条购买记录
     *
     * @param orderform
     * @return
     */
    Integer addOrders(@Param("o") Orderform orderform);//测试已通过

    /**
     * 查询当前用户是否购买了当前书籍
     *
     * @param uid
     * @param bid
     * @return
     */
    Orderform queryOrderByBooks(@Param("uid") Integer uid, @Param("bid") Integer bid);//测试已通过

    /**
     * 查询所有订单信息，组合查询当前用户订单
     *
     * @return
     */
    List<Orderform> queryOrderAllByUserId(@Param("id") Integer uid);



}
