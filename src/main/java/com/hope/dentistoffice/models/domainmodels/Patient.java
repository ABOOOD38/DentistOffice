package com.hope.dentistoffice.models.domainmodels;

import java.math.BigDecimal;

public record Patient(Integer ID, PersonalInfo personalInfo, BigDecimal owedBalance, BigDecimal payedBalance,
                      Visit visit,
                      Appointment appointment) {

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Integer ID;
        private PersonalInfo personalInfo;
        private BigDecimal owedBalance = new BigDecimal(0);
        private BigDecimal payedBalance = new BigDecimal(0);
        private Visit visit;
        private Appointment appointment;

        public Builder withID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder withPersonalInfo(PersonalInfo personalInfo) {
            this.personalInfo = personalInfo;
            return this;
        }

        public Builder withOwedBalance(BigDecimal owedBalance) {
            this.owedBalance = owedBalance;
            return this;
        }

        public Builder withPayedBalance(BigDecimal payedBalance) {
            this.payedBalance = payedBalance;
            return this;
        }

        public Builder withVisit(Visit visit) {
            this.visit = visit;
            return this;
        }

        public Builder withAppointment(Appointment appointment) {
            this.appointment = appointment;
            return this;
        }

        public Patient build() {
            return new Patient(ID, personalInfo, owedBalance, payedBalance, visit, appointment);
        }
    }

    @Override
    public String toString() {
        return personalInfo.toString() + "\n" +
                "Patient{" +
                "owedBalance=" + owedBalance +
                ", payedBalance=" + payedBalance +
                ", visits=" + visit +
                ", app_id=" + appointment +
                '}';
    }
}
