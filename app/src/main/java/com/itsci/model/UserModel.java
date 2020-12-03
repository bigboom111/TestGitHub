package com.itsci.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserModel {
    private  User user;

    public UserModel(){
        user = new User();
    }

    public UserModel(String jsonResponse) {
        Gson gson = new GsonBuilder().create();
        user = gson.fromJson(jsonResponse, User.class);
    }

    public String toJSONString() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this.user);
    }

    public User getUser() {
        return user;
    }

    public static class User {
        String id;
        String firstname;
        String lastname;
        String email;
        String password;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstname;
        }

        public void setFirstName(String firstName) {
            this.firstname = firstName;
        }

        public String getLastName() {
            return lastname;
        }

        public void setLastName(String lastName) {
            this.lastname = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
