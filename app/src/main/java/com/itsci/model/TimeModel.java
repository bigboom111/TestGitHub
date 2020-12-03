package com.itsci.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TimeModel {
    private Time time;

    public TimeModel(){
        time = new Time();
    }

    public TimeModel(String jsonResponse) {
        Gson gson = new GsonBuilder().create();
        time = gson.fromJson(jsonResponse, Time.class);
    }

    public String toJSONString(){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this.time);
    }

    public Time getTime(){
        return time;
    }

    public class Time{
        String timeId ;
        String startTime;
        String endTime ;
        String number ;
        String income ;
        String description;
        String eventId;
        private EventModel.Event event;
        private MemberHasTimeModel.MemberHasTime memberHasTime;

        public String getTimeId() {
            return timeId;
        }

        public void setTimeId(String timeId) {
            this.timeId = timeId;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getIncome() {
            return income;
        }

        public void setIncome(String income) {
            this.income = income;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public EventModel.Event getEvent() {
            return event;
        }

        public void setEvent(EventModel.Event event) {
            this.event = event;
        }

        public MemberHasTimeModel.MemberHasTime getMemberHasTime() {
            return memberHasTime;
        }

        public String getEventId() {
            return eventId;
        }

        public void setEventId(String eventId) {
            this.eventId = eventId;
        }

        public void setMemberHasTime(MemberHasTimeModel.MemberHasTime memberHasTime) {
            this.memberHasTime = memberHasTime;
        }
    }
}
