package com.cognizant.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//mark class as an Entity 
@Entity
//defining class name as Table name
@Table
public class Product 
{
//mark id as primary key
@Id
//defining id as column name
@Column
private String id;
//defining name as column name
@Column
private int price;
//defining age as column name
@Column
private String name;
//defining email as column name
@Column
private String description;
//defining rating as column name
@Column
private int rating;

public String getId() 
{
return id;
}
public void setId(String id) 
{
this.id = id;
}
public int getPrice() 
{
return price;
}
public void setPrice(int price) 
{
this.price = price;
}
public String getName() 
{
return name;
}
public void setName(String name) 
{
this.name = name;
}
public String getDescription() 
{
return description;
}
public void setDescription(String description) 
{
this.description = description;
}
public int getRating() 
{
	return rating;
}
public void setAge(int rating) 
{
	this.rating = rating;
}
}