package org.gdas.bigreportsworker.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.gdas.bigreportsworker.model.entity.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;

import static java.lang.String.format;

@Service
public class ReportService {

    @Value("${reports.folder")
    private String reportsFolder;

    private final EmployeeService employeeService;

    public ReportService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void produce(String message) {
        try {
            Instant start = Instant.now();

            List<Employee> employees = Collections.synchronizedList(employeeService.findAll());

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Employee Report");
            Row headerRow = sheet.createRow(0);

            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Social Number");
            headerRow.createCell(2).setCellValue("First Name");
            headerRow.createCell(3).setCellValue("Last Name");
            headerRow.createCell(4).setCellValue("BirthDay");
            headerRow.createCell(5).setCellValue("Address");
            headerRow.createCell(6).setCellValue("Number");
            headerRow.createCell(7).setCellValue("Complement");
            headerRow.createCell(8).setCellValue("Neighborhood");
            headerRow.createCell(9).setCellValue("City");
            headerRow.createCell(10).setCellValue("State");
            headerRow.createCell(11).setCellValue("Country");
            headerRow.createCell(12).setCellValue("Hiring Date");
            headerRow.createCell(13).setCellValue("Salary");

            for (int i = 0; i < employees.size(); i++) {
                Employee employee = employees.get(i);
                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(String.valueOf(employee.getId()));
                row.createCell(1).setCellValue(employee.getSocialNumber());
                row.createCell(2).setCellValue(employee.getFirstName());
                row.createCell(3).setCellValue(employee.getLastName());
                row.createCell(4).setCellValue(employee.getBirthday());
                row.createCell(5).setCellValue(employee.getAddress());
                row.createCell(6).setCellValue(employee.getNumber());
                row.createCell(7).setCellValue(employee.getComplement());
                row.createCell(8).setCellValue(employee.getNeighborhood());
                row.createCell(9).setCellValue(employee.getCity());
                row.createCell(10).setCellValue(employee.getState());
                row.createCell(11).setCellValue(employee.getCountry());
                row.createCell(12).setCellValue(employee.getHiring_date());
                row.createCell(13).setCellValue(String.valueOf(employee.getSalary()));
            }

            FileOutputStream outputStream = new FileOutputStream(format("%s/report_%s.xlsx", reportsFolder, LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)));
            workbook.write(outputStream);
            workbook.close();

            Instant end = Instant.now();
            Duration duration = Duration.between(start, end);
            System.out.printf("it took %d seconds(s) (or %d milliseconds) to process the report%n", duration.getSeconds(), duration.get(ChronoUnit.MILLIS));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
