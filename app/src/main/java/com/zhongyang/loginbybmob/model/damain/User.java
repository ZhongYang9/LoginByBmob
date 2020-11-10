package com.zhongyang.loginbybmob.model.damain;

/**
 * @项目名称 LoginByBmob
 * @类名 User
 * @包名 com.zhongyang.loginbybmob.model.damain
 * @创建时间 2020/11/10 13:44
 * @作者 钟阳
 * @描述 用户数据实体类
 */
public class User {
    private String userName;//用户姓名
    private String userPwd;//用户密码
    private String userTel;//用户电话（主键）
    private String gender;//用户性别

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
