package com.hope.dentistoffice.models.domainmodels;

import java.time.LocalDate;
import java.time.LocalTime;

public record Appointment(Integer ID, LocalDate appointmentDate, LocalTime startTime, Integer duration) {

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Integer ID;
        private LocalDate appointmentDate;
        private LocalTime startTime;
        private Integer duration;

        public Builder withID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder withAppointmentDate(LocalDate appointmentDate) {
            this.appointmentDate = appointmentDate;
            return this;
        }

        public Builder withStartTime(LocalTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder withDuration(Integer duration) {
            this.duration = duration;
            return this;
        }

        public Appointment build() {
            return new Appointment(ID, appointmentDate, startTime, duration);
        }
    }
}
