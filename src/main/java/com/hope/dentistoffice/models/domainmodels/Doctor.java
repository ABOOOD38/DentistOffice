package com.hope.dentistoffice.models.domainmodels;

public record Doctor(Integer ID, PersonalInfo personalInfo, Schedule schedule, LoginInfo loginInfo) {

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Integer ID;
        private LoginInfo loginInfo;
        private Schedule schedule;
        private PersonalInfo personalInfo;

        public Builder withID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder withPersonalInfo(PersonalInfo personalInfo) {
            this.personalInfo = personalInfo;
            return this;
        }

        public Builder withSchedule(Schedule schedule) {
            this.schedule = schedule;
            return this;
        }

        public Builder withLoginInfo(LoginInfo loginInfo) {
            this.loginInfo = loginInfo;
            return this;
        }

        public Doctor build() {
            return new Doctor(ID, personalInfo, schedule, loginInfo);
        }
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "ID=" + ID +
                ", personalInfo=" + personalInfo +
                ", scheduleID=" + schedule +
                ", loginID=" + loginInfo +
                '}';
    }
}

