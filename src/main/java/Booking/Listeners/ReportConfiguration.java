package Booking.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ReportConfiguration {

    public static ExtentReports ExtendReprtGenerator(){
        ExtentSparkReporter report=new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/Report.html"));
        report.config().setDocumentTitle("BookingAutomation");
        report.config().setReportName("Krishna");
        ExtentReports Extent=new ExtentReports();
        Extent.attachReporter(report);
        return Extent;

    }
}
