package com.northwind.northwind.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.northwind.northwind.model.Customers;

public class CostumersRowMapper implements RowMapper<Customers> {
	
	
	private static final String CUSTOMER_ID	  = "CustomerID";
	private static final String COMPANY_NAME  = "CompanyName";
	private static final String CONTACT_NAME  = "ContactName";
	private static final String CONTACT_TITLE = "contactTitle";
	private static final String ADDRESS   	  = "Address";
	private static final String CITY		  = "City";
	private static final String REGION  	  = "Region";
	private static final String POSTAL_CODE   = "postalCode";
	private static final String COUNTRY 	  = "Country";
	private static final String PHONE 		  = "Phone";
	private static final String FAX	  		  = "Fax";
	
	@Override
	public Customers mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customers customer = new Customers();
		customer.setCustomerID(rs.getString(CUSTOMER_ID));
		customer.setCompanyName(rs.getString(COMPANY_NAME));
		customer.setContactName(rs.getString(CONTACT_NAME));
		customer.setContactTitle(rs.getString(CONTACT_TITLE));
		customer.setAddress(rs.getString(ADDRESS));
		customer.setCity(rs.getString(CITY));
		customer.setRegion(rs.getString(REGION));
		customer.setPostalCode(rs.getString(POSTAL_CODE));
		customer.setCountry(rs.getString(COUNTRY));
		customer.setPhone(rs.getString(PHONE));
		customer.setFax(rs.getString(FAX));
		return customer;
	} 

}
