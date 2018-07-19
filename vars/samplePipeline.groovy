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
          sh pwd
           withAWS(credentials:'amazon'){
           s3Upload(file:'helloworld.war',bucket:'warfiles-sample',path:'./target/helloworld.war')

          }




      }


}
