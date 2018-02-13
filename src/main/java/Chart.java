/**
 * Created by TomasF on 2018-01-23.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Chart extends Application {
    final static String xlent = "XLENT";
    final static String hiQ = "HiQ";
    final static String evry = "Evry";
    final static String avega = "Avega";
    final static String avanade = "Avanade";

    @Override
    public void start(Stage stage) {
        stage.setTitle("Awesomeness");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc =
                new BarChart<String, Number>(xAxis, yAxis);
        bc.setTitle("Join");
        xAxis.setLabel("Company");
        yAxis.setLabel("Awsomness factor");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2017");
        series1.getData().add(new XYChart.Data(xlent, fibonacci(12)));
        series1.getData().add(new XYChart.Data(hiQ, 93));
        series1.getData().add(new XYChart.Data(evry, 91));
        series1.getData().add(new XYChart.Data(avega, 92));
        series1.getData().add(new XYChart.Data(avanade, 89));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2018");
        series2.getData().add(new XYChart.Data(xlent, fibonacci(96)));
        series2.getData().add(new XYChart.Data(hiQ, 93));
        series2.getData().add(new XYChart.Data(evry, 92));
        series2.getData().add(new XYChart.Data(avega, 92));
        series2.getData().add(new XYChart.Data(avanade, 91));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("2019");
        series3.getData().add(new XYChart.Data(xlent, fibonacci(97)));
        series3.getData().add(new XYChart.Data(hiQ, 94));
        series3.getData().add(new XYChart.Data(evry, 93));
        series3.getData().add(new XYChart.Data(avega, 93));
        series3.getData().add(new XYChart.Data(avanade, 92));

        Scene scene = new Scene(bc, 800, 600);
        bc.getData().addAll(series1, series2, series3);
        stage.setScene(scene);
        stage.show();
    }

        private int fibonacci(int n) {
            if (n <= 1) return n;
            else return fibonacci(n-1) + fibonacci(n-2);
        }


    public static void main(String[] args) {
        launch(args);
    }
}