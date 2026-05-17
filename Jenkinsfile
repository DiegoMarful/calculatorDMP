pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/DiegoMarful/calculatorDMP.git', branch: 'main'
            }
        }
        
        stage('Compile') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew compileJava'
            }
        }
        
        stage('Unit test') {
            steps {
                sh './gradlew test'
            }
            post {
                always {
                    junit 'build/test-results/test/*.xml'
                }
            }
        }
        
        stage('Code coverage') {
            steps {
                sh './gradlew jacocoTestReport'
                // Publicar informe HTML (necesita plugin HTML Publisher)
                publishHTML(target: [
                    reportDir: 'build/reports/jacoco/test/html',
                    reportFiles: 'index.html',
                    reportName: "JaCoCo Report"
                ])
                sh './gradlew jacocoTestCoverageVerification'
            }
        }
    }
}
