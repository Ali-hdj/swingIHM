pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                bat 'mvn install'
            }
        }
	  stage('build && SonarQube analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat 'mvn clean org.sonarsource.scanner.maven:sonar-maven-plugin:3.0.2:sonar'
                }
            }
        }
    }
}
