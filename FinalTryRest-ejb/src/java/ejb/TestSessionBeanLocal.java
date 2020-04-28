/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.StudentTbl;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface TestSessionBeanLocal {

    Collection<StudentTbl> getAllStudents();

    void addStudents(String StudentName, String StudentPass);
    
    public void updateStudents(int StudentID,String StudentName,String StudentPass);
    
    public void deleteStudents(int StudentID);
}
