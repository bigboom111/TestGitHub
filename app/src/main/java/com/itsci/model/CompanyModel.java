package com.itsci.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class CompanyModel {
    private Company company;

    public CompanyModel(){
        company = new Company();
    }

    public CompanyModel(String jsonResponse) {
        Gson gson = new GsonBuilder().create();
        company = gson.fromJson(jsonResponse, Company.class);
    }

    public String toJSONString(){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this.company);
    }

    public Company getCompany(){
        return company;
    }

    public class Company{
        String companyId;
        String companyName;
        String foundingYears;
        String coordiniatorName;
        String contectNumber;
        String companyLogo;
        String businessCertificate;
        private LoginModel.Login login;
        private List<EventModel.Event> event = new ArrayList<>();

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getFoundingYears() {
            return foundingYears;
        }

        public void setFoundingYears(String foundingYears) {
            this.foundingYears = foundingYears;
        }

        public String getCoordiniatorName() {
            return coordiniatorName;
        }

        public void setCoordiniatorName(String coordiniatorName) {
            this.coordiniatorName = coordiniatorName;
        }

        public String getContectNumber() {
            return contectNumber;
        }

        public void setContectNumber(String contectNumber) {
            this.contectNumber = contectNumber;
        }

        public String getCompanyLogo() {
            return companyLogo;
        }

        public void setCompanyLogo(String companyLogo) {
            this.companyLogo = companyLogo;
        }

        public String getBusinessCertificate() {
            return businessCertificate;
        }

        public void setBusinessCertificate(String businessCertificate) {
            this.businessCertificate = businessCertificate;
        }

        public LoginModel.Login getLogin() {
            return login;
        }

        public void setLogin(LoginModel.Login login) {
            this.login = login;
        }

        public List<EventModel.Event> getEvent() {
            return event;
        }

        public void setEvent(List<EventModel.Event> event) {
            this.event = event;
        }
    }
}
