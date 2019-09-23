package com.example.debut.entity;

import java.util.ArrayList;
import java.util.List;

public class User{
    private String userId="";
    private String passWord="";
    private String phone="";
    private int sex=1;
    private int age=18;
    private Long ctTime=0L;
    private Long utTime=0L;
    private List<Diary> diarys= new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", passWord='" + passWord + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", ctTime=" + ctTime +
                ", utTime=" + utTime +
                ", diarys=" + diarys +
                '}';
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

    public Long getCtTime() {
        return ctTime;
    }

    public void setCtTime(Long ctTime) {
        this.ctTime = ctTime;
    }

    public Long getUtTime() {
        return utTime;
    }

    public void setUtTime(Long utTime) {
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