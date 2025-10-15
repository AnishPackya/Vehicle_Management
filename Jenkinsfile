pipeline {
    agent any

    tools {
        jdk 'JDK'          // Make sure you configured JDK in Jenkins
        maven 'Maven'      // Make sure you configured Maven in Jenkins
    }

    stages {

        stage('Checkout SCM') {
            steps {
                git branch: 'main', url: 'https://github.com/AnishPackya/Vehicle_Management.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building with Maven...'
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                bat 'mvn test'
            }
        }

    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed. Check logs!'
        }
    }
}
