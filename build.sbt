name := "TFGOlap"

version := "1.0"

scalaVersion := "2.10.4"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"


libraryDependencies ++= Seq("org.apache.spark" %% "spark-core" % "1.4.0" exclude("org.eclipse.jetty.orbit", "javax.servlet") exclude("org.spark-project.spark", "unused") exclude("org.apache.spark", "spark-network-common_2.10") exclude("org.apache.spark", "spark-launcher_2.10") exclude("org.apache.spark", "spark-network-shuffle_2.10")  exclude("org.apache.spark", "spark-unsafe_2.10") exclude("org.apache.hadoop", "hadoop-yarn-api") exclude("com.google.guava", "guava") exclude("org.eclipse.jetty.orbit", "javax.transaction") exclude("org.eclipse.jetty.orbit", "javax.activation") exclude("org.eclipse.jetty.orbit", "javax.mail.glassfish") exclude("commons-beanutils", "commons-beanutils-core") exclude("commons-collections", "commons-collections") exclude("commons-logging", "commons-logging") exclude("com.esotericsoftware.minlog", "minlog"),
                               "org.apache.spark" %% "spark-sql" % "1.4.0" exclude("com.twitter", "parquet-format") exclude("org.spark-project.spark", "unused") exclude("org.apache.spark", "spark-unsafe_2.10") )  
