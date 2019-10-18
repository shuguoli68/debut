package com.example.debut.entity;

/**
 * 新闻接口
 */
public class News {

    /**
     * full_title : 俄商店售丑化奥巴马切菜板遭美抗议 商家道歉(图)
     * img : http://p5.qhimg.com/t01664dcf8e83665742.jpg
     * pdate_src : 2015-12-13 15:39:28
     * img_width : 342
     * src : 中国青年网
     * pdate : 43分钟前
     * img_length : 630
     * title : 俄商店售丑化奥巴马切菜板遭美抗议 商家道歉(图)
     * content : 据法新社12月10日报道称,俄罗斯一连锁店销售的切菜板上,出现了一个猴子家庭,而其中最小的猴子脸是奥巴马的面孔。一名顾客在购买了这款切菜板,并拍下照片。这些照片被疯传,引爆了这起丑闻。  美驻俄使馆发言人威尔·史蒂文斯在推特上发帖说:"看到这样公然的种族主义表现出现...
     * url : http://news.youth.cn/gj/201512/t20151213_7413620.htm
     */
    private String full_title;
    private String img;
    private String pdate_src;
    private String img_width;
    private String src;
    private String pdate;
    private String img_length;
    private String title;
    private String content;
    private String url;
    private String newsId;

    public void setFull_title(String full_title) {
        this.full_title = full_title;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setPdate_src(String pdate_src) {
        this.pdate_src = pdate_src;
    }

    public void setImg_width(String img_width) {
        this.img_width = img_width;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public void setImg_length(String img_length) {
        this.img_length = img_length;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFull_title() {
        return full_title;
    }

    public String getImg() {
        return img;
    }

    public String getPdate_src() {
        return pdate_src;
    }

    public String getImg_width() {
        return img_width;
    }

    public String getSrc() {
        return src;
    }

    public String getPdate() {
        return pdate;
    }

    public String getImg_length() {
        return img_length;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getUrl() {
        return url;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }
}
