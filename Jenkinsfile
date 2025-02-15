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
                sh "gradle clean build"
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