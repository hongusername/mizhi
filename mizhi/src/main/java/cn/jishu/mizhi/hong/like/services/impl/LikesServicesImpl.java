package cn.jishu.mizhi.hong.like.services.impl;

import cn.jishu.mizhi.entity.Likecontexts;
import cn.jishu.mizhi.entity.Likes;
import cn.jishu.mizhi.hong.like.dao.LikeMapper;
import cn.jishu.mizhi.hong.like.services.LikesServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LikesServicesImpl implements LikesServices {

    @Resource
    private LikeMapper likeMapper;

    @Override
    public List<Likes> queryLikesByUserid(Integer userid) {
        return likeMapper.queryLikesByUserid(userid);
    }

    @Override
    public Integer likesCount(Integer userid) {
        return likeMapper.likesCount(userid);
    }

    @Override
    public Integer createLikes(Likes likes) {
        System.out.println("likes"+likes);
        return likeMapper.createLikes(likes);
    }

    @Override
    public Integer deleteLikes(Integer lid) {
        return likeMapper.deleteLikes(lid);
    }

    @Override
    public Integer updateLIikes(Likes likes) {
        return likeMapper.updateLIikes(likes);
    }

    @Override
    public Integer queryCountByUseridAndLname(Integer userid, String lname) {
        return likeMapper.queryCountByUseridAndLname(userid, lname);
    }


    @Override
    public Integer addLikesContexts(Likecontexts likecontexts) {
        return likeMapper.addLikesContexts(likecontexts);
    }

    @Override
    public Integer deleteLikesContextByLidAndLcfcidAndLctype(Likecontexts likecontexts) {
        return likeMapper.deleteLikesContextByLidAndLcfcidAndLctype(likecontexts);
    }

    @Override
    public List<Likecontexts> queryLikecontextsByLid(Integer lid) {
        return likeMapper.queryLikecontextsByLid(lid);
    }

    @Override
    public List<Likes> quertLikesByLikecontexts(Likecontexts likecontexts) {
        return likeMapper.quertLikesByLikecontexts(likecontexts);
    }

}
