pipeline {
    agent any

    environment {
        // Adjust paths if needed
        MAVEN_HOME = tool name: 'Maven', type: 'maven'
        TOMCAT_HOME = "/path/to/apache-tomcat" // e.g., C:/apache-tomcat-9.0.80
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/AnishPackya/Vehicle_Management.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    sh "${MAVEN_HOME}/bin/mvn clean package"
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    sh "${MAVEN_HOME}/bin/mvn test"
                }
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                script {
                    // Copy WAR file to Tomcat webapps directory
                    sh "cp target/vehicle-service-management-1.0-SNAPSHOT.war ${TOMCAT_HOME}/webapps/"
                }
            }
        }
    }

    post {
        success {
            echo "Build, Test, and Deployment completed successfully!"
        }
        failure {
            echo "Something went wrong. Check the Jenkins logs."
        }
    }
}
