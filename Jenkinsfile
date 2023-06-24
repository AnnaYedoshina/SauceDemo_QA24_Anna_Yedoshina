pipeline {
    agent any

    tools {

        maven "M3"
        jdk 'JDK19'
    }

    triggers {
        parameterizedCron('''
        0 21 * * 0-6 %SUITE=smokeTest.xml;BROWSER=Chrome;
        30 21 * * 0-6 %SUITE=regressionTest.xml;BROWSER=Safari;
        ''')
    }

    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'
        choice(name: 'SUITE', choices: ['suites/smokeTest.xml', 'suites/regressionTest.xml'], description: 'Choose suite to run')
        choice (name: 'BROWSER', choices: ['Chrome', 'Safari'], description: 'Select a browser')
        booleanParam (defaultValue: false, description: 'Headless', name: 'HEADLESS')
    }

    stages {
        stage('Run test') {
            steps {
                git branch: "${params.BRANCH}", url: 'https://github.com/AnnaYedoshina/SauceDemo_QA24_Anna_Yedoshina'



                sh "mvn -Dmaven.test.failure.ignore=true -Dsuite=${params.SUITE} -Dsbrowser=${params.BROWSER} -Dheadless=${params.HEADLESS} clean test "



            }

            post {


                success {
                    junit '**/target/surefire-reports/TEST-*.xml'

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