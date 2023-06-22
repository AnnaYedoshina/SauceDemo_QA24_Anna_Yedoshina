pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
        jdk "JDK19"
    }

    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'

        choice (name: 'SUITE', choices: ['suites/smokeTest.xml', 'suites/regressionTest.xml'], description: 'Choose suite to run')

        password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a password')

        choice (name: 'BROWSER', choices: ['chrome', 'safari'], description: 'Choose browser')

        booleanParam(name: 'HEADLESS', defaultValue: false, description: 'Headless mode')
    }

    stages {
        stage('Build app') {
            steps {
                sh "echo Building app"
            }
        }

        stage('Run unit tests') {
            steps {
                sh "echo Running unit tests"
            }
        }

        stage('Run tests') {
            steps {
                git branch: "${params.BRANCH}", url: 'https://github.com/AnnaYedoshina/SauceDemo_QA24_Anna_Yedoshina.git'
                // Get some code from a GitHub repository
                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true -Dsuite=${params.SUITE} -Dbrowser=${params.BROWSER} -Dheadless = ${params.HEADLESS} clean test"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/**/*.xml'
                }
            }
        }

        stage('Generate Allure report') {
            steps {
                 script {
                    allure([
                     includeProperties: false,
                     jdk: '',
                     properties: [],
                     reportBuildPolicy: 'ALWAYS',
                     results: [[path: 'target/allure-results']]
                     ])
                }
            }
        }
    }
}
