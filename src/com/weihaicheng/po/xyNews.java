package com.weihaicheng.po;
import java.util.Date;
public class xyNews {
   private Integer ItemID;
   private Integer CatalogID;
   private String Title;
   private String Description;
   private String Author;
   private Date  Date;
   private String image;
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public Integer getItemID() {
	return ItemID;
}
public void setItemID(Integer itemID) {
	ItemID = itemID;
}
public Integer getCatalogID() {
	return CatalogID;
}
public void setCatalogID(Integer catalogID) {
	CatalogID = catalogID;
}
public String getTitle() {
	return Title;
}
public void setTitle(String title) {
	Title = title;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public String getAuthor() {
	return Author;
}
public void setAuthor(String author) {
	Author = author;
}
public Date getDate() {
	return Date;
}
public void setDate(Date date) {
	Date = date;
}
   
}
