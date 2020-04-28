/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import client.StudentClient;
import entity.StudentTbl;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author root
 */
@Named(value = "studentBean")
@RequestScoped
public class StudentBean {

    /**
     * Creates a new instance of StudentBean
     */
    int StudentID;
    String StudentName, StudentPass;
    GenericType<Collection<StudentTbl>> gstuds;
    Collection<StudentTbl> studs;
    Response res;
    StudentClient client;

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public String getStudentPass() {
        return StudentPass;
    }

    public void setStudentPass(String StudentPass) {
        this.StudentPass = StudentPass;
    }

    public StudentBean() {

    }

    public Collection<StudentTbl> getStudent() {
        studs = Display();
        return studs;
    }

    public Collection<StudentTbl> Display() {
        Collection<StudentTbl> s;
        client = new StudentClient();
        gstuds = new GenericType<Collection<StudentTbl>>() {
        };
        res = client.getStuds(Response.class);
        s = res.readEntity(gstuds);
        return s;
    }

    public String addForm() {
        return "addStudentPage";
    }

    public String addStudent() {
        StudentTbl s = new StudentTbl();
        client = new StudentClient();
        s.setStudentName(getStudentName());
        s.setStudentPass(getStudentPass());
        client.addStuds(s);
        return "index";
    }

    public String updateStuds(int id) {
        for (StudentTbl s : getStudent()) {
            if (id == s.getStudentID()) {
                this.setStudentID(s.getStudentID());
                this.setStudentName(s.getStudentName());
                this.setStudentPass(s.getStudentPass());
            }
        }
        return "editPage";
    }

    public String editStudent() {
        StudentTbl s = new StudentTbl();
        client = new StudentClient();
        s.setStudentID(getStudentID());
        s.setStudentName(getStudentName());
        s.setStudentPass(getStudentPass());
        client.updateStuds(s);
        return "index";
    }

    public String deleteStudent(int StudID) {
        StudentTbl s = new StudentTbl();
        client = new StudentClient();
        client.deleteStuds(String.valueOf(StudID));
        return "index";

    }
}
