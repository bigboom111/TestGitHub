package com.itsci.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class EventModel {
    private Event event;

    public EventModel(){
        event = new Event();
    }

    public EventModel(String jsonResponse) {
        Gson gson = new GsonBuilder().create();
        event = gson.fromJson(jsonResponse, Event.class);
    }

    public String toJSONString(){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this.event);
    }

    public Event getEvent(){
        return event;
    }

    public class Event{
        String eventId;
        String title;
        String eventType;
        String gender;
        String spanofAge;
        String details;
        String startDateEvent;
        String EndDateEvent;
        String redioIncome;
        String locationName;
        String locationURL;
        String latitude;
        String longitude;
        String imgEventPR;
        String ApplicationClosed;
        String companyId;
        private CompanyModel.Company company;



        public String getEventId() {
            return eventId;
        }

        public void setEventId(String eventId) {
            this.eventId = eventId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getEventType() {
            return eventType;
        }

        public void setEventType(String eventType) {
            this.eventType = eventType;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getSpanofAge() {
            return spanofAge;
        }

        public void setSpanofAge(String spanofAge) {
            this.spanofAge = spanofAge;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public String getStartDateEvent() {
            return startDateEvent;
        }

        public void setStartDateEvent(String startDateEvent) {
            this.startDateEvent = startDateEvent;
        }

        public String getEndDateEvent() {
            return EndDateEvent;
        }

        public void setEndDateEvent(String endDateEvent) {
            EndDateEvent = endDateEvent;
        }

        public String getRedioIncome() {
            return redioIncome;
        }

        public void setRedioIncome(String redioIncome) {
            this.redioIncome = redioIncome;
        }

        public String getLocationName() {
            return locationName;
        }

        public void setLocationName(String locationName) {
            this.locationName = locationName;
        }

        public String getLocationURL() {
            return locationURL;
        }

        public void setLocationURL(String locationURL) {
            this.locationURL = locationURL;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getImgEventPR() {
            return imgEventPR;
        }

        public void setImgEventPR(String imgEventPR) {
            this.imgEventPR = imgEventPR;
        }

        public String getApplicationClosed() {
            return ApplicationClosed;
        }

        public void setApplicationClosed(String applicationClosed) {
            ApplicationClosed = applicationClosed;
        }

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        public CompanyModel.Company getCompany() {
            return company;
        }

        public void setCompany(CompanyModel.Company company) {
            this.company = company;
        }


    }
}
