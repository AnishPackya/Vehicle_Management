pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'MAVEN3'
    }

    stages {
        stage('Build') {
            steps {
                echo 'Running Maven Build...'
                bat 'mvn clean package -DskipTests'
            }
        }
        stage('Archive') {
            steps {
                echo 'Archiving Artifacts...'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo '✅ Build Success!'
        }
        failure {
            echo '❌ Build Failed!'
        }
    }
}
