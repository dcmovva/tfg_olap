package tfg.olap

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.rdd._

object TFGMain {

  case class Portfolio(asset: String, scenario: String, riskfactor: String, pnl: Int)

  def main(args: Array[String]) {

    val startTime = System.currentTimeMillis();
    val conf = new SparkConf().setAppName("Risk Cube")
    val sc = new SparkContext(conf)

    val sqlContext = new org.apache.spark.sql.SQLContext(sc)
    import sqlContext.implicits._

    val prt = sc.textFile("/tmp/out.txt").map(_.split(",")).map(p => Portfolio(p(0), p(1), p(2), p(3).trim.toInt)).toDF()
    prt.registerTempTable("prt")

    val tmp = sqlContext.sql("SELECT asset, scenario,riskfactor,pnl FROM prt WHERE asset=\"Asset_4547\"")

    tmp.save("/tmp/output/" + System.currentTimeMillis() / 1000 + "/")

    val endTime = System.currentTimeMillis();

    val duration = (endTime - startTime);

    println("that took: " + duration / 1000 + " seconds.");

  }

}