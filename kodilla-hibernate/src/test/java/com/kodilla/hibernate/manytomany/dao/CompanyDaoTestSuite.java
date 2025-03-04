package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyDaoTestSuite {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private CompanyDao companyDao;

    private Employee johnSmith;
    private Employee stephanieClarckson;
    private Employee lindaKovalsky;
    private Company softwareMachine;
    private Company dataMaesters;
    private Company greyMatter;

    @BeforeEach
    void setUp() {
        johnSmith = new Employee("John", "Smith");
        stephanieClarckson = new Employee("Stephanie", "Clarckson");
        lindaKovalsky = new Employee("Linda", "Kovalsky");

        softwareMachine = new Company("Software Machine");
        dataMaesters = new Company("Data Maesters");
        greyMatter = new Company("Grey Matter");

        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);

        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);
    }

    @AfterEach
    void cleanUp() {
        try {
            employeeDao.deleteAll();
            companyDao.deleteAll();
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void testRetrieveEmployeeByLastname () {
        //When
        List<Employee> employeesLastname = employeeDao.retrieveByLastname("Clarckson");

        //Then
        assertNotNull(employeesLastname);
        assertEquals("Stephanie", employeesLastname.get(0).getFirstname());
    }

    @Test
    void testRetrieveByFirstThreeLetters () {
        //When
        List<Company> companiesPrefix = companyDao.retrieveByFirstThreeLetters("Sof");

        //Then
        assertNotNull(companiesPrefix);
        assertEquals(1, companiesPrefix.size());
        assertEquals("Software Machine", companiesPrefix.get(0).getName());
    }

    @Test
    void testSaveManyToMany() {
        //Given
        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        int softwareMachineId = softwareMachine.getId();
        int dataMaestersId = dataMaesters.getId();
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);
    }
}