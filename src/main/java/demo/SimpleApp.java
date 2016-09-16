package demo;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

/**
 * Apache Spark application.
 *
 */
public class SimpleApp {

    public static void main(String[] args) {

        final String logFile = "./src/main/resources/README.md";  // A local copy of the README that is provided with Spark.

        final SparkConf conf = new SparkConf().setAppName("Simple Application");
        final JavaSparkContext sparkContext = new JavaSparkContext(conf);
        final JavaRDD<String> logData = sparkContext.textFile(logFile).cache();

        final long numAs = countOccurances(logData, "a");
        final long numBs = countOccurances(logData, "b");

        System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);

    }

    private static long countOccurances(final JavaRDD<String> logData, final String str) {
        return logData.filter(new Function<String, Boolean>() {
            public Boolean call(final String s) throws Exception {
                return s.contains(str);
            }
        }).count();
    }

}
