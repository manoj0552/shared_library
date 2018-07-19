def call(){
    withSonarQuveEnv(sonar server){
          sh mvn clean package sonar:soanr

    }

    timeout(time:1,unit:'HOURS'){
    def qg=waitForQualityGate()
    if(qg.status != 'OK'){
    error "Pipeline got aborted as quality gates got failed :${qg.status}"
    }
    }

}
