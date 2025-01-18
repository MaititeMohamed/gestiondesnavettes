package gestiondesnavettes.model;

public class Company {
    private int companyId;
    private String name;
    private String contactInfo;

    // Constructor
    public Company(int companyId, String name, String contactInfo) {
        this.companyId = companyId;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    // Getters and Setters
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}



