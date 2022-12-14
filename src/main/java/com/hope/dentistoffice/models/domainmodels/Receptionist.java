package com.hope.dentistoffice.models.domainmodels;

public record Receptionist(Integer ID, PersonalInfo personalInfo, Integer roleID, Integer loginID) {

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Integer ID;
        private final PersonalInfo.Builder personalInfoBuilder = PersonalInfo.getBuilder();
        private Integer roleID;
        private Integer loginID;

        public Builder withID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder withName(String name) {
            personalInfoBuilder.withName(name);
            return this;
        }

        public Builder withPhoneNumber(String phoneNumber) {
            personalInfoBuilder.withPhoneNumber(phoneNumber);
            return this;
        }

        public Builder withEmail(String email) {
            personalInfoBuilder.withEmail(email);
            return this;
        }

        public Builder withRoleID(Integer roleID) {
            this.roleID = roleID;
            return this;
        }

        public Builder withLoginID(int loginID) {
            this.loginID = loginID;
            return this;
        }

        public Receptionist build() {
            return new Receptionist(ID, personalInfoBuilder.build(), roleID, loginID);
        }


    }
}
