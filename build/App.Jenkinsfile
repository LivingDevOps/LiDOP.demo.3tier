#!groovy

pipeline {
  agent {
    label 'host'
  }

  options {
    buildDiscarder(logRotator(numToKeepStr: '10', daysToKeepStr: '7'))
    disableConcurrentBuilds()
  }

  stages {

    stage("Set Build Parameters") {
      steps {
        script {
          currentBuild.displayName = "Build_App .${BUILD_NUMBER}";
        }
      }
    }

    stage("Build") {
      steps {
        sh 'mvn clean test package install -f ./demo-backend/pom.xml'
        sh 'docker build -t demobackend ./demo-backend'
      }
    }

    stage("Code Quality") {
      steps {
        dir("./demo-backend") {
          withSonarQubeEnv('Sonarqube') {
            withCredentials([usernamePassword(credentialsId: 'lidop', passwordVariable: 'rootPassword', usernameVariable: 'rootUser')]) {
              sh 'mvn sonar:sonar -Dsonar.host.url=http://sonarqube.service.lidop.local:8084/sonarqube -Dsonar.jacoco.reportPaths=./target/coverage-reports/jacoco-unit.exec'
            }
          }
          timeout(time: 1, unit: 'HOURS') {
            waitForQualityGate abortPipeline: true
          }

        }
      }
    }

    stage("Deploy App") {
      steps {
        script {
          try {
            sh "docker rm -f demobackend"
          }
          catch(err) {
            echo "no running instance."
          }
          finally {
            sh "docker run -d -p 9200:8082 --name demobackend demobackend"
          }
        }
      }
    }
  }

  post {
    always {
      script {
        currentBuild.description = "goto <a href=https://www.${PUBLIC_IPADDRESS}.xip.io/port/9200/>App</a>"
        try {
          //sh "docker rm -f demobackend"
        }
        catch(err) {
          echo "No running Container"
        }
      }
    }
  }

}