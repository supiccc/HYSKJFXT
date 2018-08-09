package com.scau.hyskjf.pojo;

public class News {
    private Integer newsid;

    private String newstitle;

    private String newstype;

    private String newsimage;

    private String newsbelong;

    private Boolean newsenablehp;

    private Boolean newsenableact;

    private String newscontent;

    public Integer getNewsid() {
        return newsid;
    }

    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }

    public String getNewstype() {
        return newstype;
    }

    public void setNewstype(String newstype) {
        this.newstype = newstype;
    }

    public String getNewsimage() {
        return newsimage;
    }

    public void setNewsimage(String newsimage) {
        this.newsimage = newsimage;
    }

    public String getNewsbelong() {
        return newsbelong;
    }

    public void setNewsbelong(String newsbelong) {
        this.newsbelong = newsbelong;
    }

    public Boolean getNewsenablehp() {
        return newsenablehp;
    }

    public void setNewsenablehp(Boolean newsenablehp) {
        this.newsenablehp = newsenablehp;
    }

    public Boolean getNewsenableact() {
        return newsenableact;
    }

    public void setNewsenableact(Boolean newsenableact) {
        this.newsenableact = newsenableact;
    }

    public String getNewscontent() {
        return newscontent;
    }

    public void setNewscontent(String newscontent) {
        this.newscontent = newscontent;
    }
}