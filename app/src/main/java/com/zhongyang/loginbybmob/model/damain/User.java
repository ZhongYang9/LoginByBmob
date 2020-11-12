package com.zhongyang.loginbybmob.model.damain;

import cn.bmob.v3.BmobObject;

/**
 * @项目名称 LoginByBmob
 * @类名 User
 * @包名 com.zhongyang.loginbybmob.model.damain
 * @创建时间 2020/11/10 13:44
 * @作者 钟阳
 * @描述 用户数据实体类
 */
public class User extends BmobObject {
    private String name;//用户姓名
    private String telephone;//用户电话（主键）
    private String password;//用户密码
    private String gender;//用户性别

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
