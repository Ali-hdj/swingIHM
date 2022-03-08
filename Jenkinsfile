pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                bat 'mvn install'
            }
        }
	  stage('SonarQube analysis') {
	    withSonarQubeEnv('SonarQube') { // If you have configured more than one global server connection, you can specify its name
	      sh "${scannerHome}/bin/sonar-scanner"
	    }
	  }
    }
}
