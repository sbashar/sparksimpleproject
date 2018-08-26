import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;

public class SimpleApp {
    public static void main(String[] args) {
        String logFile = "/home/saydul/development/sparksimpleproject/README.md";
        SparkSession sparkSession = SparkSession.builder().appName("Simple Application").getOrCreate();

        Dataset<String> logData = sparkSession.read().textFile(logFile).cache();

        long numAs = logData.filter((FilterFunction<String>) s -> s.contains("a")).count();
        long numBs = logData.filter((FilterFunction<String>) s -> s.contains("b")).count();

        System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);

        sparkSession.stop();

    }
}
