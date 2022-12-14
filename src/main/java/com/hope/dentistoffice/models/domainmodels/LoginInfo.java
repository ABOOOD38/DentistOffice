package com.hope.dentistoffice.models.domainmodels;

public record LoginInfo(Integer ID, String userName, String password, Integer roleID) {
    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Integer ID;
        private String userName;
        private String password;
        private Integer roleID;

        public Builder withID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder withUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withRoleID(Integer roleID) {
            this.roleID = roleID;
            return this;
        }

        public LoginInfo build() {
            return new LoginInfo(ID, userName, password, roleID);
        }
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != LoginInfo.class)
            return false;

        LoginInfo other = (LoginInfo) obj;
        return this.userName.equals(other.userName) && this.password.equals(other.password);
    }

    public boolean equalsUserName(Object obj) {
        LoginInfo other = (LoginInfo) obj;
        return this.userName.equals(other.userName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
