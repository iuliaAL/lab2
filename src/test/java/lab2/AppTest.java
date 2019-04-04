package lab2;

import static org.junit.Assert.assertTrue;

import lab2.Domain.Student;
import lab2.Domain.Teme;
import lab2.Repository.StudentRepo;
import lab2.Repository.TemeRepo;
import lab2.Service.ServiceStudent;
import lab2.Service.ServiceTeme;
import lab2.Validator.StudentValidator;
import lab2.Validator.TemeValidator;
import lab2.Validator.ValidationException;
import lab2.Validator.Validator;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void addStudentTest_1() {
        Student s = new Student("20000", "Maricica Blablabla", 934, "mari@yahoo.com", "Ioan Ratiu");

        StudentRepo rep = new StudentRepo((Validator<Student>) new StudentValidator(), "src/studenti.xml");
        ServiceStudent srv = new ServiceStudent(rep);

        srv.add(s);

        //Assert.assertTrue("Student was not added!", (srv.find("20000").equals(s)));
    }

    @Test
    public void addStudentTest_4() {
        Student s = new Student("30000", "Maricica Blablabla", 112, "mari@yahoo.com", "Ioan Ratiu");
        StudentRepo rep = new StudentRepo((Validator<Student>) new StudentValidator(), "src/studenti.xml");
        ServiceStudent srv = new ServiceStudent(rep);

        srv.add(s);

        Assert.assertTrue("Student was not added!", (srv.find("30000").equals(s)));
    }

    @Test
    public void addStudentTest_5() {
        Student s = new Student("1000", "Maricica Blablabla", 911, "mari@yahoo.com", "Ioan Ratiu");
        StudentRepo rep = new StudentRepo((Validator<Student>) new StudentValidator(), "src/studenti.xml");
        ServiceStudent srv = new ServiceStudent(rep);

        srv.add(s);

        Assert.assertTrue("Student was not added!", (srv.find("1000").equals(s)));
    }


    @Test
    public void addStudentTest_6() {
        Student s = new Student("", "Maricica Blablabla", 911, "mari@yahoo.com", "Ioan Ratiu");

        SoftAssert softAssert = new SoftAssert();

        try {
            StudentRepo rep = new StudentRepo((Validator<Student>) new StudentValidator(), "src/studenti.xml");
            ServiceStudent srv = new ServiceStudent(rep);

            srv.add(s);
        } catch (ValidationException e) {
            softAssert.assertEquals("\nID invalid", e.getMessage());
        }

        softAssert.assertAll();
    }

    @Test
    public void addStudentTest_7() {
        Student s = new Student(null, "Maricica Blablabla", 911, "mari@yahoo.com", "Ioan Ratiu");

        try {
            StudentRepo rep = new StudentRepo((Validator<Student>) new StudentValidator(), "src/studenti.xml");
            ServiceStudent srv = new ServiceStudent(rep);

            srv.add(s);
        } catch (ValidationException e) {
            Assert.assertEquals("\nID invalid", e.getMessage());
        }
    }

    @Test
    public void addStudentTest_8() {
        Student s = new Student("234", "Maricica Blablabla", 999, "mari@yahoo.com", "Ioan Ratiu");

        try {
            StudentRepo rep = new StudentRepo((Validator<Student>) new StudentValidator(), "src/studenti.xml");
            ServiceStudent srv = new ServiceStudent(rep);

            srv.add(s);
        } catch (ValidationException e) {
            Assert.assertEquals("\nGrupa invalida", e.getMessage());
        }
    }

    @Test
    public void addStudentTest_9() {
        Student s = new Student("1998", "Maricica Blablabla", 147, "mari@yahoo.com", "Ioan Ratiu");

        try {
            StudentRepo rep = new StudentRepo((Validator<Student>) new StudentValidator(), "src/studenti.xml");
            ServiceStudent srv = new ServiceStudent(rep);

            srv.add(s);
        } catch (ValidationException e) {
            Assert.assertEquals("\nGrupa invalida", e.getMessage());
        }
    }

    @Test
    public void addStudentTest_10() {
        Student s = new Student("1998", "Maricica Blablabla", 934, "mariyahoocom", "Ioan Ratiu");

        try {
            StudentRepo rep = new StudentRepo((Validator<Student>) new StudentValidator(), "src/studenti.xml");
            ServiceStudent srv = new ServiceStudent(rep);

            srv.add(s);
        } catch (ValidationException e) {
            Assert.assertEquals("\nEmail invalid", e.getMessage());
        }
    }

    @Test
    public void addStudentTest_11() {
        Student s = new Student("1998", "Maricica Blablabla", 934, "mariyahoo.com", "Ioan Ratiu");

        try {
            StudentRepo rep = new StudentRepo((Validator<Student>) new StudentValidator(), "src/studenti.xml");
            ServiceStudent srv = new ServiceStudent(rep);

            srv.add(s);
        } catch (ValidationException e) {
            Assert.assertEquals("\nEmail invalid", e.getMessage());
        }
    }

    @Test
    public void addStudentTest_12() {
        Student s = new Student("1998", "Maricica Blablabla", 934, "mari@yahoocom", "Ioan Ratiu");

        try {
            StudentRepo rep = new StudentRepo((Validator<Student>) new StudentValidator(), "src/studenti.xml");
            ServiceStudent srv = new ServiceStudent(rep);

            srv.add(s);
        } catch (ValidationException e) {
            Assert.assertEquals("\nEmail invalid", e.getMessage());
        }
    }

    @Test
    public void addStudentTest_13() {
        Student s = new Student("198", "Mari123", 934, "mari@yahoo.com", "Ioan Ratiu");

        try {
            StudentRepo rep = new StudentRepo((Validator<Student>) new StudentValidator(), "src/studenti.xml");
            ServiceStudent srv = new ServiceStudent(rep);

            srv.add(s);
        } catch (ValidationException e) {
            Assert.assertEquals("\nNume invalid", e.getMessage());
        }
    }

    @Test
    public void addStudentTest_14() {
        Student s = new Student("1998", "Mari", 934, "mari@yahoo.com", "Ioan #1");

        try {
            StudentRepo rep = new StudentRepo((Validator<Student>) new StudentValidator(), "src/studenti.xml");
            ServiceStudent srv = new ServiceStudent(rep);

            srv.add(s);
        } catch (ValidationException e) {
            Assert.assertEquals("\nNume profesor invalid", e.getMessage());
        }
    }

    @Test
    public void addStudentTest_15() {
        Student s = new Student("1", "Maricica Blablabla", 937, "mari@yahoo.com", "Ioan Ratiu");

        try {
            StudentRepo rep = new StudentRepo((Validator<Student>) new StudentValidator(), "src/studenti.xml");
            ServiceStudent srv = new ServiceStudent(rep);

            srv.add(s);
        } catch (ValidationException e) {
            Assert.assertEquals("\nGrupa invalida", e.getMessage());
        }
    }

    @Test
    public void addAssgnTest_1() {
        Teme t = new Teme(102, "descriere", 9, 10);

        TemeRepo rep = new TemeRepo((Validator<Teme>) new TemeValidator(), "src/teme.xml");
        ServiceTeme srv = new ServiceTeme(rep);
        srv.add(t);

        Assert.assertEquals("Assignment not added!", srv.find(102), t);
    }

    @Test
    public void addAssgnTest_2() {
        Teme t = new Teme(2, "descriere", 9, 15);
        try {
            TemeRepo rep = new TemeRepo((Validator<Teme>) new TemeValidator(), "src/teme.xml");
            ServiceTeme srv = new ServiceTeme(rep);
            srv.add(t);
        } catch (ValidationException e) {
            Assert.assertEquals("\nDeadline invalid", e.getMessage());
        }
    }

}
