package com.itsci.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LoginModel {
    private Login login;

    public LoginModel(){
        login = new Login();
    }

    public LoginModel(String jsonResponse) {
        Gson gson = new GsonBuilder().create();
        login = gson.fromJson(jsonResponse, Login.class);
    }

    public String toJSONString() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this.login);
    }

    public Login getLogin() {
        return login;
    }

    public class Login {
        String username;
        String passwords;
        String address;
        String tel;
        String facebook;
        String line;
        String email;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPasswords() {
            return passwords;
        }

        public void setPasswords(String passwords) {
            this.passwords = passwords;
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
    }
}
