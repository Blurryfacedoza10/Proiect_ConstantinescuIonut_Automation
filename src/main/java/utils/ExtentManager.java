package utils;


//Conține clasele de utilitare și configurare: `TestConfig` (gestionare URL-uri globale), `ExtentManager` și `TestListener` (generarea rapoartelor vizuale HTML).

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/ExtentReport.html");
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setDocumentTitle("Raport de Testare Automatizata");
            sparkReporter.config().setReportName("Rezultate Teste - Proiect Final");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Tester", "Ionut Constantinescu");
            extent.setSystemInfo("Mediu", "QA / Testare");
        }
        return extent;
    }
}