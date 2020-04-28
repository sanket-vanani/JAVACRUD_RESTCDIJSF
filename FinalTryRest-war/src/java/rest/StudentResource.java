/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entity.StudentTbl;
import ejb.TestSessionBeanLocal;
import java.util.Collection;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author root
 */
@Path("student")
public class StudentResource {

    @Context
    private UriInfo context;

    @EJB
    TestSessionBeanLocal tbl;

    /**
     * Creates a new instance of StudentResource
     */
    public StudentResource() {
    }

    /**
     * Retrieves representation of an instance of rest.StudentResource
     *
     * @param s
     * @return
     */
    @GET
    @Path("/getStuds")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<StudentTbl> getStuds() {
        return tbl.getAllStudents();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addStuds(StudentTbl s) {
        tbl.addStudents(s.getStudentName(), s.getStudentPass());
    }

    @PUT
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateStuds(StudentTbl s) {
        tbl.updateStudents(s.getStudentID(), s.getStudentName(), s.getStudentPass());
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/delete")
    public String deleteStuds(@QueryParam("StudID")int StudentID)
    {
        tbl.deleteStudents(StudentID);
        return "ok";
    }
        
    
//    @GET
//     @Produces(MediaType.TEXT_PLAIN)
//    @Path("/deleteEmp")
//     @RolesAllowed("Admin")
//    public String removeEmp(@QueryParam("eid")int EmployeeId){
//        ebl.remove(EmployeeId);
//        return "Ok";
//    }
}
