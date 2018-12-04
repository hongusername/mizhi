package cn.jishu.mizhi.hong.like.services;

import cn.jishu.mizhi.entity.Likecontexts;
import cn.jishu.mizhi.entity.Likes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LikesServices {
    //获得指定用户的收藏夹
    List<Likes> queryLikesByUserid(Integer userid);
    //查询用户拥有的收藏夹
    Integer likesCount(Integer userid);

    //创建文件夹
    Integer createLikes(Likes likes);

    //删除文件夹
    Integer deleteLikes(Integer lid);
    //修改文件夹
    Integer updateLIikes(Likes likes);
    //查看是否有同名收藏夹
    Integer queryCountByUseridAndLname(Integer userid, String lname);
    // 收藏文章/回答
    Integer addLikesContexts(Likecontexts likecontexts);
    //删除收藏的文章/回答
    Integer deleteLikesContextByLidAndLcfcidAndLctype(Likecontexts likecontexts);

    //某个收藏夹下的集合
    List<Likecontexts> queryLikecontextsByLid(Integer lid);

    //查询某条Likecontexts信息所在的收藏夹
    List<Likes> quertLikesByLikecontexts(Likecontexts likecontexts);
}
