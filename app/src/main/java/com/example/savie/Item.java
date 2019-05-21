package com.example.savie;

import java.io.Serializable;

public class Item implements Serializable {
    private long id;
    private String name;
    private String topicname;
    private String link;
    private long imgshow;
    private long img;
    private String color;
    private String tag1;
    private String tag2;
    private String content;

    public Item(){
        name = "";
    }

    public Item(long id, String name, String topicname, String link,
                long imgshow, long img, String color, String tag1,
                String tag2, String content){
        this.id = id;
        this.name = name;
        this.topicname = topicname;
        this.link = link;
        this.imgshow = imgshow;
        this.img= img;
        this.color = color;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.content = content;
    }
    public long getId(){return id;}
    public void setId(long id){this.id=id;}
    public String getName(){return name;}
    public String getTopicname(){return topicname;}
    public String getLink(){return link;}
    public long getImgshow(){return imgshow;}
    public long getImg(){return img;}
    public String getColor(){return color;}
    public String getTag1(){return tag1;}
    public String getTag2(){return tag2;}
    public String getContent(){return content;}

    public void setName(String name){this.name=name;}
    public void setTopicname(String topicname){this.topicname=topicname;}
    public void setLink(String link){this.link=link;}
    public void setImgshow(long imgshow){this.imgshow=imgshow;}
    public void setImg(long img){this.img=img;}
    public void setColor(String color){this.color=color;}
    public void setTag1(String tag1){this.tag1=tag1;}
    public void setTag2(String tag2){this.tag2=tag2;}
    public void setContent(String content){this.content=content;}


}
