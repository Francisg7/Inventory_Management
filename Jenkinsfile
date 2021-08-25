library identifier: "pipeline-library@v1.6",
retriever: modernSCM(
  [
    $class: "GitSCMSource",
    remote: "https://github.com/redhat-cop/pipeline-library.git"
  ]
)

appSourceUrl = "https://github.com/Francisg7/Inventory_Management/"
appSourceRef = "master"

appFolder = "app"
appName = "Inventory-management"


pipeline {
  // Use Jenkins Maven slave
  // Jenkins will dynamically provision this as OpenShift Pod
  // All the stages and steps of this Pipeline will be executed on this Pod
  // After Pipeline completes the Pod is killed so every run will have clean
  // workspace
  agent {
    label 'maven'
  }

  // Pipeline Stages start here
  // Requeres at least one stage
  stages {

    // Checkout source code
    // This is required as Pipeline code is originally checkedout to
    // Jenkins Master but this will also pull this same code to this slave
    stage('Git Checkout') {
      steps {
        sh "mkdir ${appFolder}"
        dir(appFolder){ 
          git url: "${appSourceUrl}", branch: "${appSourceRef}"
        }
      }
    }
    
    stage('Build') {
        agent {
            docker {
                image 'franciswilliams/invventory:latest'
                // Run the container on the node specified at the top-level of the Pipeline, in the same workspace, rather than on a new node entirely
            }
        }
        steps {
            sh 'mvn --version'
        }
    }

    stage('Get version from POM'){
      steps {
        dir(appFolder){
          tag=readMavenPom().getVersion()
        }
      }
    }

    

    // Build Container Image using the artifacts produced in previous stages
    stage('Deploy Build'){
      steps {
       dir(appFolder){
           binaryBuild(buildConfigName:appName, buildFromPath:".")
        }
      }
    }

//     stage('Promote from Build to Dev') {
//       steps {
//         tagImage(sourceImageName: env.APP_NAME, sourceImagePath: env.BUILD, toImagePath: env.DEV)
//       }
//     }

//     stage ('Verify Deployment to Dev') {
//       steps {
//         verifyDeployment(projectName: env.DEV, targetApp: env.APP_NAME)
//       }
//     }

//     stage('Promote from Dev to Stage') {
//       steps {
//         tagImage(sourceImageName: env.APP_NAME, sourceImagePath: env.DEV, toImagePath: env.STAGE)
//       }
//     }

//     stage ('Verify Deployment to Stage') {
//       steps {
//         verifyDeployment(projectName: env.STAGE, targetApp: env.APP_NAME)
//       }
//     }

//     stage('Promotion gate') {
//       steps {
//         script {
//           input message: 'Promote application to Production?'
//         }
//       }
//     }

//     stage('Promote from Stage to Prod') {
//       steps {
//         tagImage(sourceImageName: env.APP_NAME, sourceImagePath: env.STAGE, toImagePath: env.PROD)
//       }
//     }

//     stage ('Verify Deployment to Prod') {
//       steps {
//         verifyDeployment(projectName: env.PROD, targetApp: env.APP_NAME)
//       }
//     }
  }
}
