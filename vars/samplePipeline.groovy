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
           withAWS(credentials:'AKIAJ7D5XIXGBK2GHWDA')
           s3Upload(file:'helloworld.war',bucket:'warfiles-sample',path:'.\pipeline-code\shared_library\share_Pipeline\target\helloworld.war')
              sh pwd
          }




      }


}
