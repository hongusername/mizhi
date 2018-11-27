package cn.jishu.mizhi.kai.manager.server.impl;

import cn.jishu.mizhi.entity.Member;
import cn.jishu.mizhi.entity.Questions;
import cn.jishu.mizhi.entity.Users;
import cn.jishu.mizhi.kai.manager.dao.ManagerDao;
import cn.jishu.mizhi.kai.manager.server.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: mizhi
 * @description: ${description}
 * @author: ShiDunKai
 * @create: 2018-11-23 17:42
 **/
@Service
public class ManagerServiceImpl implements ManagerService {
    @Resource
    private ManagerDao managerDao;
    @Override
    public List<Users> queryAllUser() {
        return managerDao.queryAllUser();
    }

    @Override
    public Users qeuryUsersById(Integer userid) {
        return managerDao.qeuryUsersById(userid);
    }

    @Override
    public Integer updateUserStatus(Users users) {
        return managerDao.updateUserStatus(users);
    }

    @Override
    public List<Questions> qeuryAllQuestions() {
        return managerDao.qeuryAllQuestions();
    }

    @Override
    public List<Questions> queyrTypeById(Integer questId) {
        return managerDao.queyrTypeById(questId);
    }

    @Override
    public Integer updateStatus(Questions questions) {
        return managerDao.updateStatus(questions);
    }



    @Override
    public List<Member> queryAll() {
        return managerDao.queryAll();
    }

    @Override
    public Integer deleteByQuestionId(Integer mid) {
        return managerDao.deleteByQuestionId(mid);
    }

    @Override
    public Integer insertMember(Member member) {
        return managerDao.insertMember(member);
    }

    @Override
    public Member queryByMemberById(Integer qMid) {
        return managerDao.queryByMemberById(qMid);
    }

    @Override
    public Integer updateMember(Member member) {
        return managerDao.updateMember(member);
    }
}
