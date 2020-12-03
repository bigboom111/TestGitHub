package com.itsci.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashSet;
import java.util.Set;

public class MemberModel {
    private  Member member;

    public MemberModel(){
        member = new Member();
    }

    public MemberModel(String jsonResponse) {
        Gson gson = new GsonBuilder().create();
        member = gson.fromJson(jsonResponse, Member.class);
    }

    public String toJSONString() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this.member);
    }

    public Member getMember() {
        return member;
    }

    public class Member {
        String idCard;
        String fullname;
        String birthday;
        String age;
        String address;
        String tel;
        String facebook;
        String line;
        String email;
        String profilePicture;
        String photoIdCard;
        String username;
        String password;
        private LoginModel.Login login;
        private MemberHasTimeModel.MemberHasTime memberHasTime;


        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getFacebook() {
            return facebook;
        }

        public void setFacebook(String facebook) {
            this.facebook = facebook;
        }

        public String getLine() {
            return line;
        }

        public void setLine(String line) {
            this.line = line;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getProfilePicture() {
            return profilePicture;
        }

        public void setProfilePicture(String profilePicture) {
            this.profilePicture = profilePicture;
        }

        public String getPhotoIdCard() {
            return photoIdCard;
        }

        public void setPhotoIdCard(String photoIdCard) {
            this.photoIdCard = photoIdCard;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public LoginModel.Login getLogin() {
            return login;
        }

        public void setLogin(LoginModel.Login login) {
            this.login = login;
        }

        public MemberHasTimeModel.MemberHasTime getMemberHasTime() {
            return memberHasTime;
        }

        public void setMemberHasTime(MemberHasTimeModel.MemberHasTime memberHasTime) {
            this.memberHasTime = memberHasTime;
        }
    }
}
