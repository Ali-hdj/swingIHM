pipeline {
    agent any
    stages {
        stage('clean') {
            steps {
                bat 'mvn clean'
            }
        }
        stage('compile') {
            steps {
                bat 'mvn compile'
            }
        }
        stage('install') {
            steps {
                bat 'mvn install'
            }
        }
        stage('verify') {
            steps {
                    bat 'mvn clean verify sonar:sonar -Dsonar.login=admin -Dsonar.password=admin'
            }
        }
    }
}