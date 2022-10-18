#! /usr/bin/env kotlinc-jvm -script



import java.lang.ProcessBuilder
import java.util.concurrent.TimeUnit 



val springAPI = "https://start.spring.io/"
println("*******************************************")
println("*                                         *")
println("* Thank you for using Spring Initializer! *")
println("*                                         *")
println("*******************************************")
println()

// Group Id
println("Please type your project group id")
val groupId = readLine()
println("Your group id is $groupId")

// Artifact Id
println("Please type your project artifact id")
val artifactId = readLine()
println("Your artifact id is $artifactId")

// API
println("please select api (d(default)/s(spring)/specify url)")
var api = readLine()
when (api) {
  "d" -> api = "" // meaning will use command line configuration not script
  "s" -> api = springAPI
}


val command = "springtools --init --group-id ${groupId} --artifact-id ${artifactId} "

if(api == ""){
  exec(command)
}else{
  val commandWithAPI = "${command} --api ${api}"
  exec(commandWithAPI)
}

fun exec(cmd : String) {
  println(cmd)
  val workingDir = java.io.File(".")
  var commands = cmd.split(" ").toTypedArray()
  ProcessBuilder(cmd.split(" "))
  .directory(workingDir)
  .redirectOutput(ProcessBuilder.Redirect.INHERIT)
  .redirectError(ProcessBuilder.Redirect.INHERIT)
  .start().waitFor(60, TimeUnit.SECONDS)
}








// Execution
