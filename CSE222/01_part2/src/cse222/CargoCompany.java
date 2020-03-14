package cse222;

import java.util.ArrayList;

/**
 * CargoCompany class for cargo company.
 * @author Abdullah_Celik_171044002
 */
public class CargoCompany
{
    private String companyName;
    private Administrator administrator;
    private ArrayList<Branch> branch;
    private ArrayList<TransportationPersonnel> transportationPersonnel;
    private ArrayList<Person> customer;

    /**
     * Constructor for the cargo company.
     * @param companyName Cargo company's name
     * @param adminName Cargo admin's name
     * @param adminSurname Cargo admin's surname
     * @param adminId Cargo admin's id
     */
    public CargoCompany(String companyName, String adminName, String adminSurname, int adminId)
    {
        setCompanyName(companyName);
        administrator = new Administrator(this,adminName,adminSurname,adminId);
        branch = new ArrayList<>();
        transportationPersonnel = new ArrayList<>();
        customer = new ArrayList<>();
    }

    /**
     * Query shipment.
     * @param trackingNumber of the shipment
     * @return shipment if the tackingNumber is invalid. Otherwise returns null.
     */
    public Shipment queryShipment(int trackingNumber)
    {
        for(int i=0 ; i < getBranch().size() ; ++i)
            for(int j=0 ; j < getBranch().get(i).getShipment().size() ; ++j)
                if(getBranch().get(i).getShipment().get(j).getTrackingNumber() == trackingNumber)
                    return getBranch().get(i).getShipment().get(j);
        return null;
    }

    /**
     * Getter function for the company's administrator.
     * @return administrator of the company.
     */
    public Administrator getAdministrator() { return administrator; }

    /**
     * Getter function for the company's branches.
     * @return branches of the company.
     */
    public ArrayList<Branch> getBranch() { return branch; }

    /**
     * Getter function for the company's customers.
     * @return customers of the company.
     */
    public ArrayList<Person> getCustomer() { return customer; }

    /**
     * Getter function for the company's transportation personnel.
     * @return transportation personnel of the company.
     */
    public ArrayList<TransportationPersonnel> getTransportationPersonnel() { return transportationPersonnel; }

    /**
     * Getter function for the company's name.
     * @return name of the company.
     */
    public String getCompanyName() { return companyName; }

    /**
     * Setter function for the setting company's name.
     * @param companyName new company name.
     */
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    /**
     * Check whether the current company and other are the same or not.
     * @param o other object to compare them
     * @return true if the company names are same. Otherwise return false.
     */
    @Override
    public boolean equals(Object o)
    {
        if(o == null)
            return false;
        if(!(o instanceof CargoCompany))
            return false;

        return getCompanyName().equals(((CargoCompany)o).companyName);
    }

    /**
     * Create a string representation of the company.
     * @return a string representation of the company.
     */
    @Override
    public String toString()
    {
        String str = "";

        str += getCompanyName() + "\n";
        str += "Administrator : " + getAdministrator().getName() + "  " + getAdministrator().getSurname() + "\n";

        return str;
    }
}