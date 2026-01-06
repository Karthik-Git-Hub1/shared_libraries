def newDownload() {
    git 'https://github.com/IntelliqDevops/maven.git'
}

def newBuild() {
    sh 'mvn clean package'
}

def newDeploy(String shared_libraries, String 16.112.67.97, String testapp) {
    sh """
        scp /var/lib/jenkins/workspace/${workspaceName}/webapp/target/webapp.war \
        ubuntu@${16.112.67.97}:/var/lib/tomcat10/webapps/${testapp}.war
    """
}

def runSelenium(String workspaceName) {
    sh "java -jar /var/lib/jenkins/workspace/${shared_libraries}/testing.jar"
}

return this
