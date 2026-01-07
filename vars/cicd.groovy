def gitDownload(repo)
{
  git "https://github.com/IntelliqDevops/${repo}.git"
  
}
def buildArtifact()
{
  sh 'mvn package'
}
def deployTomcat(jobname,ip,context)
{
   sh "scp webapp/target/webapp.war/${jobname}//home/ubuntu/testapp.war ubuntu@${ip}:/var/lib/tomcat10/webapps/testapp.war" ${context}.war"
}
def executeSelenium(jobname)
{
  sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"
}
