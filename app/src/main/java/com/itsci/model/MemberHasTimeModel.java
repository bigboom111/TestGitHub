package com.itsci.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MemberHasTimeModel {
    private MemberHasTime memberHasTime;

    public MemberHasTimeModel(){
        memberHasTime = new MemberHasTime();
    }

    public MemberHasTimeModel(String jsonResponse) {
        Gson gson = new GsonBuilder().create();
        memberHasTime = gson.fromJson(jsonResponse, MemberHasTime.class);
    }

    public String toJSONString(){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this.memberHasTime);
    }

    public MemberHasTime getMemberHasTime(){
        return memberHasTime;
    }

    public class MemberHasTime{
        String id;
        private MemberModel.Member member;
        private TimeModel.Time time;
        String Status;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public MemberModel.Member getMember() {
            return member;
        }

        public void setMember(MemberModel.Member member) {
            this.member = member;
        }

        public TimeModel.Time getTime() {
            return time;
        }

        public void setTime(TimeModel.Time time) {
            this.time = time;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String status) {
            Status = status;
        }
    }
}
