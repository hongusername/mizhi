package cn.jishu.mizhi.utils;

import cn.jishu.mizhi.entity.Answers;
import cn.jishu.mizhi.entity.Articles;
import cn.jishu.mizhi.entity.Questions;
import cn.jishu.mizhi.entity.Userstalks;

import java.util.Comparator;

public class ComparatorConfig implements Comparator<Object> {


    @Override
    public int compare(Object o1, Object o2) {
        //文章  回答  动态 话题
        //1.  01=文章  o2=文章
        //2.  01=文章  o2=回答
        //3.  01=文章  o2=动态
        //4.  01=文章  o2=话题

        //5.  01=回答  o2=文章
        //6  01=回答  o2=回答
        //7.  01=回答  o2=动态
        //8.  01=回答  o2=话题

        //9.  01=动态  o2=文章
        //10.  01=动态  o2=回答
        //11.  01=动态  o2=动态
        //12.  01=动态  o2=话题


        //13.  01=话题  o2=文章
        //14.  01=话题  o2=回答
        //15.  01=话题  o2=动态
        //16.  01=话题  o2=话题



        //1
        if (o1 instanceof Articles && o2 instanceof Articles) {
            Articles a = (Articles)(o1);
            Articles b = (Articles)(o2);
           long atime = a.getArticletime().getTime();
           long btime = b.getArticletime().getTime();
           if(atime >btime){
               return -1;
           }else if(atime<btime){
                    return 1;
           }else{
            return 0;
           }
        }
        //2

        else if (o1 instanceof Articles && o2 instanceof Answers) {
            Articles a = (Articles)(o1);
            Answers b = (Answers)(o2);
            long atime = a.getArticletime().getTime();
            long btime = b.getAwtime().getTime();
            if(atime >btime){
                return -1;
            }else if(atime<btime){
                return 1;
            }else{
                return 0;
            }

        }

        //3
        else if (o1 instanceof Articles && o2 instanceof Userstalks) {
            Articles a = (Articles)(o1);
            Userstalks b = (Userstalks)(o2);
            long atime = a.getArticletime().getTime();
            long btime = b.getTalktime().getTime();
            if(atime >btime){
                return -1;
            }else if(atime<btime){
                return 1;
            }else{
                return 0;
            }

        }


//4
        else if (o1 instanceof Articles && o2 instanceof Questions) {
            Articles a = (Articles)(o1);
            Questions b = (Questions)(o2);
            long atime = a.getArticletime().getTime();
            long btime = b.getQtime().getTime();
            if(atime >btime){
                return -1;
            }else if(atime<btime){
                return 1;
            }else{
                return 0;
            }

        }



        //5
        if (o1 instanceof Answers && o2 instanceof Articles) {
            Answers a = (Answers)(o1);
            Articles b = (Articles)(o2);
            long atime = a.getAwtime().getTime();
            long btime = b.getArticletime().getTime();
            if(atime >btime){
                return -1;
            }else if(atime<btime){
                return 1;
            }else{
                return 0;
            }
        }
        //6

        else if (o1 instanceof Answers && o2 instanceof Answers) {
            Answers a = (Answers)(o1);
            Answers b = (Answers)(o2);
            long atime = a.getAwtime().getTime();
            long btime = b.getAwtime().getTime();
            if(atime >btime){
                return -1;
            }else if(atime<btime){
                return 1;
            }else{
                return 0;
            }

        }

        //7
        else if (o1 instanceof Answers && o2 instanceof Userstalks) {
            Answers a = (Answers)(o1);
            Userstalks b = (Userstalks)(o2);
            long atime = a.getAwtime().getTime();
            long btime = b.getTalktime().getTime();
            if(atime >btime){
                return -1;
            }else if(atime<btime){
                return 1;
            }else{
                return 0;
            }

        }


//8
        else if (o1 instanceof Answers && o2 instanceof Questions) {
            Answers a = (Answers)(o1);
            Questions b = (Questions)(o2);
            long atime = a.getAwtime().getTime();
            long btime = b.getQtime().getTime();
            if(atime >btime){
                return -1;
            }else if(atime<btime){
                return 1;
            }else{
                return 0;
            }

        }











        //9
        if (o1 instanceof Userstalks && o2 instanceof Articles) {
            Userstalks a = (Userstalks)(o1);
            Articles b = (Articles)(o2);
            long atime = a.getTalktime().getTime();
            long btime = b.getArticletime().getTime();
            if(atime >btime){
                return -1;
            }else if(atime<btime){
                return 1;
            }else{
                return 0;
            }
        }
        //10

        else if (o1 instanceof Userstalks && o2 instanceof Answers) {
            Userstalks a = (Userstalks)(o1);
            Answers b = (Answers)(o2);
            long atime = a.getTalktime().getTime();
            long btime = b.getAwtime().getTime();
            if(atime >btime){
                return -1;
            }else if(atime<btime){
                return 1;
            }else{
                return 0;
            }

        }

        //11
        else if (o1 instanceof Userstalks && o2 instanceof Userstalks) {
            Userstalks a = (Userstalks)(o1);
            Userstalks b = (Userstalks)(o2);
            long atime = a.getTalktime().getTime();
            long btime = b.getTalktime().getTime();
            if(atime >btime){
                return -1;
            }else if(atime<btime){
                return 1;
            }else{
                return 0;
            }

        }


//12
        else if (o1 instanceof Userstalks && o2 instanceof Questions) {
            Userstalks a = (Userstalks)(o1);
            Questions b = (Questions)(o2);
            long atime = a.getTalktime().getTime();
            long btime = b.getQtime().getTime();
            if(atime >btime){
                return -1;
            }else if(atime<btime){
                return 1;
            }else{
                return 0;
            }

        }







        //13
        if (o1 instanceof Questions && o2 instanceof Articles) {
            Questions a = (Questions)(o1);
            Articles b = (Articles)(o2);
            long atime = a.getQtime().getTime();
            long btime = b.getArticletime().getTime();
            if(atime >btime){
                return -1;
            }else if(atime<btime){
                return 1;
            }else{
                return 0;
            }
        }
        //14

        else if (o1 instanceof Questions && o2 instanceof Answers) {
            Questions a = (Questions)(o1);
            Answers b = (Answers)(o2);
            long atime = a.getQtime().getTime();
            long btime = b.getAwtime().getTime();
            if(atime >btime){
                return -1;
            }else if(atime<btime){
                return 1;
            }else{
                return 0;
            }

        }

        //15
        else if (o1 instanceof Questions && o2 instanceof Userstalks) {
            Questions a = (Questions)(o1);
            Userstalks b = (Userstalks)(o2);
            long atime = a.getQtime().getTime();
            long btime = b.getTalktime().getTime();
            if(atime >btime){
                return -1;
            }else if(atime<btime){
                return 1;
            }else{
                return 0;
            }

        }


//16
        else{
            Questions a = (Questions)(o1);
            Questions b = (Questions)(o2);
            long atime = a.getQtime().getTime();
            long btime = b.getQtime().getTime();
            if(atime >btime){
                return -1;
            }else if(atime<btime){
                return 1;
            }else{
                return 0;
            }

        }


    }
}
