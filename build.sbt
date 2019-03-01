name := "example3"

version := "0.1"

scalaVersion := "2.12.8"
val sparkVersion = "2.4.0"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-hive" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.scala-lang" % "scala-reflect" % "2.12.8"
)

assemblyMergeStrategy in assembly := {
  case PathList("javax", "inject", xs @ _*)          => MergeStrategy.first
  case PathList("javax", "xml", xs @ _*)             => MergeStrategy.first
  case PathList("org", "apache", xs @ _*)            => MergeStrategy.first
  case PathList("org", "aopalliance", xs @ _*)       => MergeStrategy.first
  case PathList("org", "objenesis", xs @ _*)         => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".html" => MergeStrategy.first
  case "plugin.xml"                                  => MergeStrategy.last
  case "parquet.thrift"                              => MergeStrategy.last
  case "application.conf"                            => MergeStrategy.concat
  case "codegen/config.fmpp"                         => MergeStrategy.discard
  case "unwanted.txt"                                => MergeStrategy.discard
  case "git.properties"                              => MergeStrategy.discard
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}