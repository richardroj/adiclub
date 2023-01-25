pipeline {
    agent any
     tools {
        maven 'maven-local'
        jdk 'jdk-11'
     }
    environment {
        DATE = new Date().format('yy.M')
        TAG = "${DATE}.${BUILD_NUMBER}"
    }
    stages {
        stage('Build') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
         stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Docker Build') {
            steps {
                script {
                    docker.build("richardroj/adiclub:${TAG}")
                }
            }
        }
        stage('Pushing Docker Image to Dockerhub') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'docker_credential') {
                        docker.image("richardroj/adiclub:${TAG}").push()
                        docker.image("richardroj/adiclub:${TAG}").push("latest")
                    }
                }
            }
        }
        stage('Deploy'){
            steps {
                sh "docker stop adiclub | true"
                sh "docker rm adiclub | true"
                sh "docker run --name adiclub -d -p 9004:8080 richardroj/adiclub:${TAG}"
            }
        }
    }
}
