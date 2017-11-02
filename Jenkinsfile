pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat './gradlew.bat clean testClasses'
            }
        }
        stage('cleanDb') {
           steps {
               bat './gradlew.bat flywayClean -P flyway.schema=bib1 -P flyway.url=jdbc:mysql://localhost:3306/bib1'
               bat './gradlew.bat flywayValidate -P flyway.schema=bib1 -P flyway.url=jdbc:mysql://localhost:3306/bib1'
           }
        }

        stage('Test') {
            steps {
                bat(script: './gradlew.bat test', returnStatus:true)
            }
        }

        stage('CodeCoverage') {
            steps {
                script {
                    try {
                        bat './gradlew.bat jacocoTestCoverageVerification'
                    } catch(error) {
                        currentBuild.result='UNSTABLE'
                    }
                }
            }
        }
    }

    post {
        always {
            junit '**/build/test-results/test/*.xml'
            step( [ $class: 'JacocoPublisher' ] )
        }
    }
}