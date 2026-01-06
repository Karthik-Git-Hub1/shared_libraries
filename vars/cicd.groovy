def newDownload() {
    git 'https://github.com/IntelliqDevops/maven.git'
}

def newBuild() {
    sh 'mvn clean package'
}

def newDeploy(String workspaceName, String serverIp, String appName) {
    sh """
        scp /var/lib/jenkins/workspace/${workspaceName}/webapp/target/webapp.war \
        ubuntu@${serverIp}:/var/lib/tomcat10/webapps/${appName}.war
    """
}

def runSelenium(String workspaceName) {
    sh "java -jar /var/lib/jenkins/workspace/${workspaceName}/testing.jar"
}

return this
