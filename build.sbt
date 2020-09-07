name := "TypedClusterSingletonExample"

version := "0.1"

scalaVersion := "2.13.3"

lazy val akkaVersion = "2.5.31"
lazy val protobufVersion = "3.6.1"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
  "com.typesafe.akka" %% "akka-remote" % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster-typed" % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster-sharding-typed" % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster-tools" % akkaVersion,
  "com.typesafe.akka" %% "akka-actor-testkit-typed"    % akkaVersion  % "test",
  "org.slf4j" % "slf4j-log4j12" % "1.2" % "test"

)