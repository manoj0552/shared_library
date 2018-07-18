
call(body){
  def config = [:]
  body resloveStrategy=Closer.DELEGATE_FIRST
  body.delegate = config
  body()
  
  node{
    sh "echo ${config.projectName}" 
  }
  

}
