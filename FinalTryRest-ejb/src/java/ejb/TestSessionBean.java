/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.StudentTbl;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class TestSessionBean implements TestSessionBeanLocal {
    
    @PersistenceContext(unitName = "TestPU")
    EntityManager em;
    
    @Override
    public Collection<StudentTbl> getAllStudents() {
        return em.createNamedQuery("StudentTbl.findAll").getResultList();
    }
    
    @Override
    public void addStudents(String StudentName, String StudentPass) {
        StudentTbl s = new StudentTbl();
        s.setStudentName(StudentName);
        s.setStudentPass(StudentPass);
        em.persist(s);
    }

    @Override
    public void updateStudents(int StudentID, String StudentName, String StudentPass) {
        StudentTbl s = (StudentTbl) em.find(StudentTbl.class, StudentID);
        s.setStudentName(StudentName);
        s.setStudentPass(StudentPass);
        em.merge(s);
    }

    @Override
    public void deleteStudents(int StudentID) {
        StudentTbl s = (StudentTbl) em.find(StudentTbl.class, StudentID);
        em.remove(s);
    }
    
}
