package com.hope.dentistoffice.models.domainmodels;

import java.time.LocalDate;
import java.time.LocalTime;

public record Schedule(Integer ID, LocalDate startAt, LocalDate endAt, String days, LocalTime startTime,
                       LocalTime endTime) {
    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Integer ID;
        private LocalDate startAt;
        private LocalDate endAt;
        private String days;
        private LocalTime startTime;
        private LocalTime endTime;

        public Builder withID(int id) {
            this.ID = id;
            return this;
        }

        public Builder withStartAt(LocalDate startAt) {
            this.startAt = startAt;
            return this;
        }

        public Builder withEndAt(LocalDate endAt) {
            this.endAt = endAt;
            return this;
        }

        public Builder withDays(String days) {
            this.days = days;
            return this;
        }

        public Builder withStartTime(LocalTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder withEndTime(LocalTime endTime) {
            this.endTime = endTime;
            return this;
        }

        public Schedule build() {
            return new Schedule(ID, startAt, endAt, days, startTime, endTime);
        }
    }

    @Override
    public String toString() {
        return ID + " -> " + startAt.toString() + " -> " + endAt.toString();
    }
}

