def call(body){

      def config = [:]
      body.resolveStrategy = Closure.DELEGATE_FIRST
      body.delegate = config
      body()

      node{
          stage('checkout'){
          gitCheckout()
          }

          stage('build'){
          gradlePackage()
          }

          stage('UnitTest'){
          //    sonarQubaTest()

          }
          stage('s3_upload'){


           withAWS(credentials:'amazon',region:'us-east-2'){
           s3Upload(file:'./target/helloworld.war',bucket:'warfiles-sample',path:'helloworld.war')

           }
          }

      }


}
