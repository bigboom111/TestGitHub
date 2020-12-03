package com.itsci.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReportModel {
    private Report report;

    public ReportModel(){
        report = new Report();
    }

    public ReportModel(String jsonResponse) {
        Gson gson = new GsonBuilder().create();
        report = gson.fromJson(jsonResponse, Report.class);
    }

    public String toJSONString(){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this.report);
    }

    public Report getReport(){
        return report;
    }

    public class Report{
        String reportId;
        String time;
        String details;
        private MemberModel.Member member;
        private EventModel.Event event;

        public String getReportId() {
            return reportId;
        }

        public void setReportId(String reportId) {
            this.reportId = reportId;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public MemberModel.Member getMember() {
            return member;
        }

        public void setMember(MemberModel.Member member) {
            this.member = member;
        }

        public EventModel.Event getEvent() {
            return event;
        }

        public void setEvent(EventModel.Event event) {
            this.event = event;
        }
    }
}
