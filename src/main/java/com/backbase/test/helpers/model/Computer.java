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
        public Builder withComputerName(String computerName) { Computer.this.computerName = computerName; return this; }
        public Builder withIntroduced(String introduced) { Computer.this.introduced = introduced; return this; }
        public Builder withDiscontinued(String discontinued) { Computer.this.discontinued = discontinued; return this; }
        public Builder withCompany(String company) { Computer.this.company = company; return this; }
        public Computer build() {return Computer.this; }
    }

    public void setComputerName (String newComputerName) {computerName = newComputerName;}
    public void setIntroduced (String newIntroduced) {introduced = newIntroduced;}
    public void setDiscontinued (String newDiscontinued) {discontinued = newDiscontinued;}
    public void setCompany (String newCompany) {company = newCompany;}

}
