package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.File;

public class ExtentManager {
    
    private static ExtentReports extent;
    
    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance("target/extent-report/extent.html");
        }
        return extent;
    }
    
    public static ExtentReports createInstance(String fileName) {
        // Créer le répertoire si nécessaire
        File file = new File(fileName).getParentFile();
        if (file != null && !file.exists()) {
            file.mkdirs();
        }

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Rapport de Tests - Amazon");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Tests Graphiques Amazon");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        return extent;
    }
}
