package cn.jishu.mizhi.kai.manager.dao;

import cn.jishu.mizhi.entity.Member;
import cn.jishu.mizhi.entity.Questions;
import cn.jishu.mizhi.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: mizhi
 * @description: ${description}
 * @author: ShiDunKai
 * @create: 2018-11-23 17:42
 **/
public interface ManagerDao {
    /**
    * @Description: 用户方法
    * @Param: []
    * @return: java.util.List<cn.jishu.mizhi.entity.Users>
    * @Author: ShiDunKai
    * @Date: 2018/11/23
    */
    List<Users> queryAllUser();
    Users qeuryUsersById(@Param("userId") Integer userid);
    Integer updateUserStatus(@Param("updateUser") Users users);

    /**
    * @Description: 话题方法
    * @Param: []
    * @return: java.util.List<cn.jishu.mizhi.entity.Questions>
    * @Author: ShiDunKai
    * @Date: 2018/11/23
    */
    List<Questions> qeuryAllQuestions();
    List<Questions> queyrTypeById(@Param("qId") Integer questId);
    Integer updateStatus(@Param("updateId") Questions questions);

    /**
    * @Description: 会员方法
    * @Param: []
    * @return: java.util.List<cn.jishu.mizhi.entity.Member>
    * @Author: ShiDunKai
    * @Date: 2018/11/23
    */
    List<Member> queryAll();
    Integer deleteByQuestionId(@Param("mid") Integer mid);
    Integer insertMember(@Param("member") Member member);
    Integer updateMember(@Param("upMember") Member member);


}
