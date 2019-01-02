package com.weihaicheng.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.weihaicheng.po.Score;
import com.weihaicheng.po.Student;
import com.weihaicheng.po.Catalog;
import com.weihaicheng.po.Comment;
import com.weihaicheng.po.Commentbyuser;
import com.weihaicheng.po.User;
import com.weihaicheng.po.xyNews;


public interface newsDao {
   
    //获取所有新闻
    public List<xyNews> queryNews();
    //获取所有分类
    public List<Catalog> queryCatalogs();
    //获取分类下新闻
    public List<xyNews> queryNewsById(Integer catalogId);
    //根据新闻id获取新闻
    public xyNews queryNewById(Integer itemId);
    //登录
    public User findUser(@Param("username") String username,@Param("password") String password);
    //获取用户信息
    public User getUserById(Integer userId);
    //获取根据新闻id获取评论
    public List<Comment> getCommentByitemId(Integer itemId);
    //联合查询获取评论
    public List<Commentbyuser> getComment(Integer itemId);
    //添加评论
    public void insertComment(@Param("commentText") String commentText,@Param("userId") Integer userId,@Param("itemID") Integer itemId);
    //注册
    public void register(@Param("username") String username,@Param("password") String password);
    
}
