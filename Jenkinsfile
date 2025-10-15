pipeline {
    agent any

    tools {
        // Make sure this name matches what you configured in Jenkins Global Tool Configuration
        maven 'Maven'  
        jdk 'JDK'      
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/AnishPackya/Vehicle_Management.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                bat "${tool 'Maven'}\\bin\\mvn clean package"
            }
        }

        stage('Test') {
            steps {
                bat "${tool 'Maven'}\\bin\\mvn test"
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                echo 'Deploying WAR to Tomcat...'
                // Example: copy WAR to Tomcat webapps folder
                bat 'copy target\\VehicleManagement-1.0-SNAPSHOT.war "C:\\apache-tomcat-9.0.73\\webapps\\"'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed! Check logs.'
        }
    }
}
