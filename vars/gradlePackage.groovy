def call(){
  def mvnHome = tool "M3"
    sh "mvn clean build -DskipTest"
}
