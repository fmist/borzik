pipeline {
   agent any
   environment {
           PATH = "$PATH:/usr/local/bin/"
       }
    tools {
        gradle "gradle"
    }

    stages {
        stage('Get project') {
            steps {
                git 'https://github.com/fmist/borzik.git'
            }
        }

        stage('Build') {
            steps {
                sh "gradle clean build -D"
            }
        }
//         stage('SonarQube Analysis') {
//             steps {
//               sh "gradle sonar"
//             }
//         }
        stage('UI Test') {
            steps {
                sh "gradle cucumber"
            }
        }
        stage('Deploy') {
             steps {
               sh "docker-compose up -d --wait --build"
             }
        }
    }
      post {
          always {
            cleanWs()
          }
      }
}