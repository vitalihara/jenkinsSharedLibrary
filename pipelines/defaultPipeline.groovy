
// vars/defaultPipeline.groovy
// This pipeline requires no parameters as input.

def call(Map pipelineParams) {
    pipeline {
        agent none

        stages {
            stage('Build and Unit test') {
                agent { label 'maven' }
                steps {
                    script {
                        module_Maven('clean verify')
                    }
                }
                post {
                    always {
                        junit testResults: '**/target/surefire-reports/*.xml', allowEmptyResults: false
                    }
                }
            }
            stage('Build') {
                agent { label 'maven' }
                steps {
                    script {
                        log(level: "INFO", msg: "BUILD")
                    }
                }
            }
        }
        post {
            always {
                script {
                    log(level: "INFO", msg: "NOTIFICATION")
                }
            }
        }
    }
}
