package com.backbase.test.helpers.model;

public class Computer {
    private String computerName;
    private String introduced;
    private String discontinued;
    private String company;

    public static Builder newEntity() { return new Computer().new Builder(); }

    public String getComputerName() {
        return computerName;
    }

    public String getIntroduced() {
        return introduced;
    }

    public String getDiscontinued() {
        return discontinued;
    }

    public String getCompany() {
        return company;
    }

    public class Builder {
        private Builder() {}
        public Builder withComputerName(String firstname) { Computer.this.computerName = computerName; return this; }
        public Builder withIntroduced(String lastname) { Computer.this.introduced = introduced; return this; }
        public Builder withDiscontinued(String address) { Computer.this.discontinued = discontinued; return this; }
        public Builder withCompany(String postcode) { Computer.this.company = company; return this; }

        public Computer build() {return Computer.this; }
    }

}
