package cn.jishu.mizhi.hui.books.service.impl;

import cn.jishu.mizhi.entity.Bookrack;
import cn.jishu.mizhi.entity.Books;
import cn.jishu.mizhi.entity.Orderform;
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

    /**
     * 查询书
     *
     * @param books
     * @param pageNum
     * @return
     */
    @Override
    public PageInfo<Books> queryBooksAll(Books books, Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<Books> list = this.booksDao.queryBooksAll(books);
        PageInfo<Books> pageInfo = new PageInfo<Books>(list);
        return pageInfo;
    }

    /**
     * 增加书籍
     *
     * @param books
     * @return
     */
    @Override
    public Integer addBooks(Books books) {
        return this.booksDao.addBooks(books);
    }

    /**
     * 查询当前用户书架
     *
     * @param userid
     * @return
     */
    @Override
    public List<Books> queryJiaAll(Integer userid) {
        return this.booksDao.queryJiaAll(userid);
    }

    /**
     * 增加当前用户的书架的书
     *
     * @param bookrack
     * @return
     */
    @Override
    public Integer addJia(Bookrack bookrack) {
        return this.booksDao.addJia(bookrack);
    }

    /**
     * 删除书架内的书
     *
     * @param uid
     * @param bid
     * @return
     */
    @Override
    public Integer deleteJia(Integer uid, Integer bid) {
        return this.booksDao.deleteJia(uid, bid);
    }

    /**
     * 增加订单，购买书籍
     *
     * @param orderform
     * @return
     */
    @Override
    public Integer addOrders(Orderform orderform) {
        return this.booksDao.addOrders(orderform);
    }

    /**
     * 查询当前用户是否购买了当前书籍
     *
     * @param uid
     * @param bid
     * @return
     */
    @Override
    public Orderform queryOrderByBooks(Integer uid, Integer bid) {
        return this.booksDao.queryOrderByBooks(uid, bid);
    }

    /**
     * 查询所有订单信息，组合查询当前用户订单
     *
     * @param uid
     * @return
     */
    @Override
    public List<Orderform> queryOrderAllByUserId(Integer uid) {
        return this.booksDao.queryOrderAllByUserId(uid);
    }

    /**
     * 根据id查询一本书
     *
     * @param id
     * @return
     */
    @Override
    public Books queryBooksById(Integer id) {
        return this.booksDao.queryBooksById(id);
    }

    /**
     * 根据名称查询一本书
     *
     * @param name
     * @return
     */
    @Override
    public Books queryBooksByName(String name) {
        return this.booksDao.queryBooksByName(name);
    }
}
