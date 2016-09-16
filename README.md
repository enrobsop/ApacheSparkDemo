Based on the [Spark Java Quick Start Guide](https://spark.apache.org/docs/latest/quick-start.html).

To execute demo:

```
# Package a JAR containing your application
$ mvn package
...

# Use spark-submit to run your application
$ YOUR_SPARK_HOME/bin/spark-submit \
  --class "demo.SimpleApp" \
  --master local[4] \
  target/ApacheSparkDemo-1.0-SNAPSHOT.jar
...
Lines with a: 61, lines with b: 27
```