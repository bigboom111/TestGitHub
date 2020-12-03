package com.itsci.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class AgencyModel {
    private Agency agency;

    public AgencyModel(){
        agency = new Agency();
    }

    public AgencyModel(String jsonResponse) {
        Gson gson = new GsonBuilder().create();
        agency = gson.fromJson(jsonResponse, Agency.class);
    }

    public String toJSONString(){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this.agency);
    }

    public Agency getAgency(){
        return agency;
    }

    public class Agency{
        String agencyId;
        String fullName;
        String idCard;
        String profilePicture;
        String photoIdCard;
        private LoginModel.Login login;

        public String getAgencyId() {
            return agencyId;
        }

        public void setAgencyId(String agencyId) {
            this.agencyId = agencyId;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
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

        public LoginModel.Login getLogin() {
            return login;
        }

        public void setLogin(LoginModel.Login login) {
            this.login = login;
        }

    }
}
