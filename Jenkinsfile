// Based on:
// https://raw.githubusercontent.com/redhat-cop/container-pipelines/master/basic-spring-boot/Jenkinsfile

library identifier: "pipeline-library@v1.5",
retriever: modernSCM(
  [
    $class: "GitSCMSource",
    remote: "https://github.com/redhat-cop/pipeline-library.git"
  ]
)

// The name you want to give your Spring Boot application
// Each resource related to your app will be given this name
appName = "inventory-application"

pipeline {
  stages{
        stage("initialize"){
            steps{
               sh '''
                   echo "PATH = ${PATH}"
                   echo "M2_HOME = ${M2_HOME}"
                   '''

            }
        }
    }
    // Use the 'maven' Jenkins agent image which is provided with OpenShift
    agent { label "maven" }
    stages {
        stage("Checkout") {
            steps {
                checkout scm
            }
        }
        stage("Docker Build") {
            steps {
                sh 'docker-compose up'
            }
        }

        // You could extend the pipeline by tagging the image,
        // or deploying it to a production environment, etc......
    }
}