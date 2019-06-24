/*
 * Copyright 2016 Spotify AB.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

name := "spark-bigquery"
organization := "com.shina"
scalaVersion := "2.11.11"
crossScalaVersions := Seq("2.10.6", "2.11.11")

spName := "odidere/spark-bigquery"
sparkVersion := "2.2.0"
sparkComponents := Seq("core", "sql")
spAppendScalaVersion := true
spIncludeMaven := true

libraryDependencies ++= Seq(
  "com.databricks" %% "spark-avro" % "4.0.0",
  "com.google.cloud.bigdataoss" % "bigquery-connector" % "0.10.2-hadoop2"
    exclude ("com.google.guava", "guava-jdk5"),
  "org.slf4j" % "slf4j-simple" % "1.7.21",
  "joda-time" % "joda-time" % "2.9.3",
  "org.scalatest" %% "scalatest" % "2.2.1" % "test"
)

assemblyMergeStrategy in assembly := {
  case PathList("com", "databricks", "spark", "avro", xs @ _*) => MergeStrategy.first
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)

}

// Release settings
licenses += "Apache-2.0" -> url("http://opensource.org/licenses/Apache-2.0")
releaseCrossBuild             := true
releasePublishArtifactsAction := PgpKeys.publishSigned.value
pomExtra                      := {
  <url>https://github.com/odidere/spark-bigquery</url>
  <scm>
    <url>git@github.com/odidere/spark-bigquery.git</url>
    <connection>scm:git:git@github.com:odidere/spark-bigquery.git</connection>
  </scm>
  <developers>
    <developer>
      <id>odidere</id>
      <name>Oluwashina Aladejubelo</name>
      <url>https://www.linkedin.com/in/shinene</url>
    </developer>
  </developers>
}
