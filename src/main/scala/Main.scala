import org.apache.spark.sql.SparkSession

object Main {

  def main(args: Array[String]): Unit = {
    val ss = SparkSession
      .builder()
      .appName("EMR Spark Glue Example")
      .config("hive.metastore.connect.retries", 5)
      .config("hive.metastore.client.factory.class", "com.amazonaws.glue.catalog.metastore.AWSGlueDataCatalogHiveClientFactory")
      .enableHiveSupport()
      .getOrCreate()

    ss.catalog.setCurrentDatabase("test_cial_sources")

    // Do work here
  }
}
