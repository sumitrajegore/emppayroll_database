package connection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class EmployeePayrollServiceTest {
	
    @Test
    void given3EmpWhenWrittenToFilesShouldMatchEmpEntries() {
    	
        EmployeePayrollData[] arrayOfEmp = {
        		
                new EmployeePayrollData("Mukesh",1,1235),
                new EmployeePayrollData("Bill",2,1235),
                new EmployeePayrollData("Mark",3,1235),
        };
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmp));
        employeePayrollService.empWriteData(EmployeePayrollService.IOService.FILE_IO);
        employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
        long result = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        //System.out.println(result);
        Assertions.assertEquals(3,result);
    }

    @Test
    void givenEmployeePayrollInDB_WhenRetrived_ShouldMatchEmployeeCount() {
    	
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData>employeePayrollData = employeePayrollService.readEmpPayRollData(EmployeePayrollService.IOService.DB_IO);
        //System.out.println(employeePayrollData.size());
        Assertions.assertEquals(2, employeePayrollData.size());
    }
    
    @Test
    void givenEmployeePayrollInDB_WhenUpdated_ShouldMatchEmployeeCount() {
    	
    	EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmpPayRollData(EmployeePayrollService.IOService.DB_IO);
        employeePayrollService.updateEmployeeSalary("Terisa", 30000);
        boolean result = employeePayrollService.checkEmployeePayRollSyncWithDB("Terisa");
        System.out.println(result);
        Assertions.assertEquals(true, result);
        
    }
}