package com.example.debut.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiModel(value = "user实体")
public class User{
    @ApiModelProperty(value = "user表的id，自增")
    private int id=0;
    @ApiModelProperty(value = "用户userId",required = true)
    private String userId="";
    @ApiModelProperty(value = "用户登录密码")
    private String passWord="";
    @ApiModelProperty(value = "用户昵称")
    private String name="LiHui";
    @ApiModelProperty(value = "手机号码")
    private String phone="";
    @ApiModelProperty(value = "性别，整型")
    private int sex=1;
    @ApiModelProperty(value = "年龄")
    private int age=18;
    @ApiModelProperty(value = "创建时间")
    private Date ctTime = new Date();
    @ApiModelProperty(value = "更新时间")
    private Date utTime= new Date();
    @ApiModelProperty(value = "用户的diarys")
    private List<Diary> diarys= new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", passWord='" + passWord + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", ctTime=" + ctTime +
                ", utTime=" + utTime +
                ", diarys=" + diarys +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCtTime() {
        return ctTime;
    }

    public void setCtTime(Date ctTime) {
        this.ctTime = ctTime;
    }

    public Date getUtTime() {
        return utTime;
    }

    public void setUtTime(Date utTime) {
        this.utTime = utTime;
    }

    public List<Diary> getDiarys() {
        return diarys;
    }

    public void setDiarys(List<Diary> diarys) {
        this.diarys = diarys;
    }
}

/*class User {
    var userId: String = ""
    var passWord = ""
    var phone = ""
    var sex = 1
    var age = 18
    var create_time: Long? = 0L
    var utTime: Long? = 0L
    var diarys: List<Diary> = ArrayList()


    override fun toString(): String {
        return "User{" +
                "userId='" + userId + '\''.toString() +
                ", passWord='" + passWord + '\''.toString() +
                ", phone='" + phone + '\''.toString() +
                ", sex=" + sex +
                ", age=" + age +
                ", ctTime=" + create_time +
                ", utTime=" + utTime +
                ", diarys=" + diarys +
                '}'.toString()
    }
}*/

/*
package com.example.debut.entity


data class User(
        var userId: String,
        var passWord: String?="1221",
        var phone: String?="123457901",
        var sex: Int?=1,
        var age: Int?=18,
        var ctTime: Long?=0L,//createTime
        var utTime: Long?=0L,//updateTime
        var diarys:List<Diary>?= arrayListOf<Diary>()
)

class User {

    var userId: String? = null
    var passWord: String? = null
    var phone: String? = null
    var sex: Int? = null
    var age: Int? = null
    var ctTime: Long? = null//createTime
    var utTime: Long? = null//updateTime
    var diarys:List<Diary>? = null

    constructor() {}

    constructor(userId: String,
                passWord: String,
                phone: String?,
                sex: Int?,
                age: Int?,
                ctTime: Long?,
                utTime: Long?
    ) {
         this.userId = userId
        this.passWord = passWord
        this.phone = phone
        this.sex = sex
        this.age = age
        this.ctTime = ctTime
        this.utTime = utTime
    }

    constructor(userId: String,
                passWord: String,
                phone: String?,
                sex: Int?,
                age: Int?,
                ctTime: Long?,
                utTime: Long?,
                vararg diarys:List<Diary>
    ) {
        this.userId = userId
        this.passWord = passWord
        this.phone = phone
        this.sex = sex
        this.age = age
        this.ctTime = ctTime
        this.utTime = utTime
        this.diarys = if (diarys.isNotEmpty()) diarys[0] else arrayListOf()
    }

    override fun toString(): String {
        return "User(userId='$userId', passWord='$passWord', phone=$phone, sex=$sex, age=$age, ctTime=$ctTime, utTime=$utTime)"
    }


}*/