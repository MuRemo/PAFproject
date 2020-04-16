package com.hospital;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.hospital.hospital;

@Path("/payments")
public class HospitalResource {
hospital payobj = new hospital();
@GET
@Path("/")
@Produces(MediaType.TEXT_HTML)
public String readItems()
 {
 return "Hello" ;
 }


@POST
@Path("/")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.TEXT_PLAIN)
public String insertItem(@FormParam("patientid") int patientid,
 @FormParam("date") String date,
 @FormParam("cardtype") String cardtype,
 @FormParam("cardnumber") String cardnumber,
 @FormParam("expirydate") String expirydate,
 @FormParam("pinnumber") String pinnumber,
 @FormParam("amount") String amount)
{
 String output = payobj.insertPayment(patientid, date, cardtype, cardnumber, expirydate, pinnumber, amount);
return output;
}

}



