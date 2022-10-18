#! /usr/bin/env kotlinc-jvm -script

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


val command = "spring init --group-id ${groupId} --artifact-id ${artifactId} "

if(api == ""){
  println(command)
}else{
  val commandWithAPI = "${command} --api ${api}"
  println(commandWithAPI)
}









// Execution
