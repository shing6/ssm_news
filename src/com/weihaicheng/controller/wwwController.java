package com.weihaicheng.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weihaicheng.po.Catalog;
import com.weihaicheng.po.Comment;
import com.weihaicheng.po.Commentbyuser;
import com.weihaicheng.po.Score;
import com.weihaicheng.po.Student;
import com.weihaicheng.po.User;
import com.weihaicheng.po.xyNews;
import com.weihaicheng.service.newsService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class wwwController {
	@Autowired
	private newsService newsService;

	
	//获取新闻
	@RequestMapping(value = "/getNewsList")
	@ResponseBody
	public void getNewsList(HttpServletRequest request,HttpServletResponse response){
		
		String jsoncallback = request.getParameter("jsoncallback");// 客户端请求参数
        String result = "";
        List<xyNews> xyNews = newsService.queryNews();
        result = jsoncallback + "("+JSONArray.fromObject(xyNews)+")";
	    
	           try {
	        	response.setContentType("text/html; charset=utf-8");
				response.getWriter().print(result);
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

	//获取分类
	@RequestMapping(value = "/getCatalogList")
	@ResponseBody
	public void getCatalogList(HttpServletRequest request,HttpServletResponse response){
		
		String jsoncallback = request.getParameter("jsoncallback");// 客户端请求参数
        String result = "";
        List<Catalog> catalog = newsService.queryCatalogs();
        result = jsoncallback + "("+JSONArray.fromObject(catalog)+")";
	    
	           try {
	        	response.setContentType("text/html; charset=utf-8");
				response.getWriter().print(result);
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	
	//获取分类下新闻
		@RequestMapping(value = "/getCatalogNew")
		@ResponseBody
		public void getCatalogNew(HttpServletRequest request,HttpServletResponse response){
			
			String jsoncallback = request.getParameter("jsoncallback");// 客户端请求参数
	        int catalogId=Integer.parseInt(request.getParameter("id"));
			String result = "";
	        List<xyNews> xyNews = newsService.queryNewsById(catalogId);
	        result = jsoncallback + "("+JSONArray.fromObject(xyNews)+")";
		    
		           try {
		        	response.setContentType("text/html; charset=utf-8");
					response.getWriter().print(result);
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
	//根据ID获取新闻
		@RequestMapping(value = "/getNewById")
		@ResponseBody
		public void getNewById(HttpServletRequest request,HttpServletResponse response){
			String jsoncallback = request.getParameter("jsoncallback");// 客户端请求参数
	        int itemId=Integer.parseInt(request.getParameter("itemId"));
			String result = "";
	        xyNews xyNews = newsService.queryNewById(itemId);
	        result = jsoncallback + "("+JSONObject.fromObject(xyNews)+")";
		    
		           try {
		        	response.setContentType("text/html; charset=utf-8");
					response.getWriter().print(result);
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}

			
		}
		
	   //登录
		
		@RequestMapping(value = "/login")
		@ResponseBody
		public void login(HttpServletRequest request,HttpServletResponse response){
			 String jsoncallback = request.getParameter("jsoncallback");// 客户端请求参数
			 String username=request.getParameter("username");
	    	 String password=request.getParameter("password");
	    	 User user=newsService.findUser(username, password);
	    	 String result = "";
	    	 
	    	 if(user != null){
	    		HttpSession session=request.getSession();
	    		session.setAttribute("userid", user.getUserid());
	    		JSONObject json = new JSONObject();
	    		json.put("login","success");
	    		json.put("userId",user.getUserid());
	    		result = jsoncallback + "("+JSONObject.fromObject(json)+")";
			    
		           try {
		        	response.setContentType("text/html; charset=utf-8");
					response.getWriter().print(result);
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
	    	 }
	    	 else{
	    		 
	    		 JSONObject json = new JSONObject();
		    		json.put("login","faild");
		    		result = jsoncallback + "("+JSONObject.fromObject(json)+")";
				    
			           try {
			        	response.setContentType("text/html; charset=utf-8");
						response.getWriter().print(result);
						
					} catch (IOException e) {
						
						e.printStackTrace();
					}
	    		 
	    	 }
	    	
		}
		//退出
		
				@RequestMapping(value = "/logout")
				@ResponseBody
				public void logout(HttpServletRequest request,HttpServletResponse response){
					 String jsoncallback = request.getParameter("jsoncallback");// 客户端请求参数
					 HttpSession session=request.getSession();
			    	 String result = "";
			    	 if(session!=null&&session.getAttribute("userid")!=null){
							session.invalidate();
							JSONObject json = new JSONObject();
				    		json.put("logout","success");
							result = jsoncallback + "("+JSONObject.fromObject(json)+")";
						    
						           try {
						        	response.setContentType("text/html; charset=utf-8");
									response.getWriter().print(result);
									
								} catch (IOException e) {
									
									e.printStackTrace();
								}
							
						}
			    	 }
			    	 
			    	
				
		
		//根据ID获取用户信息
				@RequestMapping(value = "/getUser")
				@ResponseBody
				public void getUserById(HttpServletRequest request,HttpServletResponse response){
					String jsoncallback = request.getParameter("jsoncallback");// 客户端请求参数
					HttpSession session=request.getSession();
					String result = "";
					if(session!=null&&session.getAttribute("userid")!=null){
						int userId= (int) session.getAttribute("userid");
						User user = newsService.getUserById(userId);
				        result = jsoncallback + "("+JSONObject.fromObject(user)+")";
					    
					           try {
					        	response.setContentType("text/html; charset=utf-8");
								response.getWriter().print(result);
								
							} catch (IOException e) {
								
								e.printStackTrace();
							}
						
					}
					else{
						JSONObject json = new JSONObject();
			    		json.put("login","faild");
			    		result = jsoncallback + "("+JSONObject.fromObject(json)+")";
					    try {
				        	response.setContentType("text/html; charset=utf-8");
							response.getWriter().print(result);
							
						} catch (IOException e) {
							
							e.printStackTrace();
						}
					}
					

					
				}
				
	           //根据新闻ID获取评论
				@RequestMapping(value = "/getCommentByitemId")
				@ResponseBody
				public void getCommentByitemId(HttpServletRequest request,HttpServletResponse response){
					String jsoncallback = request.getParameter("jsoncallback");// 客户端请求参数
			        int itemId=Integer.parseInt(request.getParameter("itemId"));
					String result = "";
			        List<Comment> comment = newsService.getCommentByitemId(itemId);
			        result = jsoncallback + "("+JSONArray.fromObject(comment)+")";
				    
				           try {
				        	response.setContentType("text/html; charset=utf-8");
							response.getWriter().print(result);
							
						} catch (IOException e) {
							
							e.printStackTrace();
						}

					
				}
				
				//联合查询获取评论
				@RequestMapping(value = "/getComment")
				@ResponseBody
				public void getComment(HttpServletRequest request,HttpServletResponse response){
					String jsoncallback = request.getParameter("jsoncallback");// 客户端请求参数
			        int itemId=Integer.parseInt(request.getParameter("itemId"));
					String result = "";
			        List<Commentbyuser> commentbyuser = newsService.getComment(itemId);
			        
			        result = jsoncallback + "("+JSONArray.fromObject(commentbyuser)+")";
				    
				           try {
				        	response.setContentType("text/html; charset=utf-8");
							response.getWriter().print(result);
							
						} catch (IOException e) {
							
							e.printStackTrace();
						}

					
				}
				//添加评论
				@RequestMapping(value = "/insertComment")
				@ResponseBody
				public void insertComment(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
					String jsoncallback = request.getParameter("jsoncallback");// 客户端请求参数
					HttpSession session=request.getSession();
					String result = "";
					if(session!=null&&session.getAttribute("userid")!=null){
						int userId= (int) session.getAttribute("userid");
						String commentText=new String(request.getParameter("commentText").getBytes("ISO-8859-1"),"UTF-8");
						String stringitemId=request.getParameter("itemId");
				    	int itemId=Integer.parseInt(stringitemId);
				        newsService.insertComment(commentText, userId, itemId);
				        JSONObject json = new JSONObject();
			    		json.put("insert","success");
				        result = jsoncallback + "("+JSONObject.fromObject(json)+")";
					    
					           try {
					        	response.setContentType("text/html; charset=utf-8");
								response.getWriter().print(result);
								
							} catch (IOException e) {
								
								e.printStackTrace();
							}
						
					}
					else{
						JSONObject json = new JSONObject();
			    		json.put("login","faild");
			    		result = jsoncallback + "("+JSONObject.fromObject(json)+")";
					    try {
				        	response.setContentType("text/html; charset=utf-8");
							response.getWriter().print(result);
							
						} catch (IOException e) {
							
							e.printStackTrace();
						}
					}
		
	
	
				}
				
				//注册
				@RequestMapping(value = "/register")
				@ResponseBody
				public void register(HttpServletRequest request,HttpServletResponse response){
					 String jsoncallback = request.getParameter("jsoncallback");// 客户端请求参数
					 String username=request.getParameter("username");
			    	 String password=request.getParameter("password");
			    	 try {
				        	newsService.register(username, password);;
						    String result = "";
						    JSONObject json = new JSONObject();
						    json.put("register","success");
						    result = jsoncallback + "("+JSONObject.fromObject(json)+")";
				        	response.setContentType("text/html; charset=utf-8");
							response.getWriter().print(result);
							
						} catch (IOException e) {
							String result = "";
						    JSONObject json = new JSONObject();
						    json.put("register","faild");
						    result = jsoncallback + "("+JSONObject.fromObject(json)+")";
				        	response.setContentType("text/html; charset=utf-8");
							try {
								response.getWriter().print(result);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							e.printStackTrace();
						}
			    }
			    	
			    	
				
	
}
