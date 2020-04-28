/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "StudentTbl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentTbl.findAll", query = "SELECT s FROM StudentTbl s"),
    @NamedQuery(name = "StudentTbl.findByStudentID", query = "SELECT s FROM StudentTbl s WHERE s.studentID = :studentID"),
    @NamedQuery(name = "StudentTbl.findByStudentName", query = "SELECT s FROM StudentTbl s WHERE s.studentName = :studentName"),
    @NamedQuery(name = "StudentTbl.findByStudentPass", query = "SELECT s FROM StudentTbl s WHERE s.studentPass = :studentPass")})
public class StudentTbl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StudentID")
    private Integer studentID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "StudentName")
    private String studentName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "StudentPass")
    private String studentPass;

    public StudentTbl() {
    }

    public StudentTbl(Integer studentID) {
        this.studentID = studentID;
    }

    public StudentTbl(Integer studentID, String studentName, String studentPass) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentPass = studentPass;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPass() {
        return studentPass;
    }

    public void setStudentPass(String studentPass) {
        this.studentPass = studentPass;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentID != null ? studentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentTbl)) {
            return false;
        }
        StudentTbl other = (StudentTbl) object;
        if ((this.studentID == null && other.studentID != null) || (this.studentID != null && !this.studentID.equals(other.studentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StudentTbl[ studentID=" + studentID + " ]";
    }
    
}
