package com.weihaicheng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weihaicheng.dao.newsDao;
import com.weihaicheng.po.Score;
import com.weihaicheng.po.Student;
import com.weihaicheng.po.Catalog;
import com.weihaicheng.po.Comment;
import com.weihaicheng.po.Commentbyuser;
import com.weihaicheng.po.User;
import com.weihaicheng.po.xyNews;
import com.weihaicheng.service.newsService;
@Service
@Transactional
public class newsServiceimpl implements newsService {

	@Autowired
	private newsDao newsDao;
		
		@Override
		//获取所以新闻
		public List<xyNews> queryNews() {
			
			return this.newsDao.queryNews();
		}
		@Override
		//获取所以分类
		public List<Catalog> queryCatalogs() {
			
			return this.newsDao.queryCatalogs();
		}
		@Override
		//获取分类下的新闻
		public List<xyNews> queryNewsById(Integer catalogId) {
		
			return this.newsDao.queryNewsById(catalogId);
		}
		@Override
		//根据新闻id获取新闻
		public xyNews queryNewById(Integer itemId) {
			
			return this.newsDao.queryNewById(itemId);
		}
		@Override
		//登录
		public User findUser(String username, String password) {
			User user=this.newsDao.findUser(username, password);
			return user;
		}
		@Override
		//获取用户信息
		public User getUserById(Integer userId) {
			return this.newsDao.getUserById(userId);
		}
		@Override
		//根据新闻id查评论
		public List<Comment> getCommentByitemId(Integer itemId) {
			
			return this.newsDao.getCommentByitemId(itemId);
		}
		@Override
		//联合查询新闻评论
		public List<Commentbyuser> getComment(Integer itemId) {
			
			return this.newsDao.getComment(itemId);
		}
		
		@Override
		//添加评论
		public void insertComment(String commentText, Integer userId, Integer itemId) {
			this.newsDao.insertComment(commentText, userId, itemId);
			
		}
		//注册
		@Override
		public void register(String username, String password) {
			this.newsDao.register(username, password);;
			
		}
	

}
