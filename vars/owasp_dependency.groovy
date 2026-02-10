// 1. Add 'String nvdKey' inside the parenthesis to accept the argument
def call(String nvdKey){
    
    // 2. Use the variable '${nvdKey}' in the additionalArguments
    dependencyCheck additionalArguments: "--scan ./ --nvdApiKey ${nvdKey}", odcInstallation: 'OWASP'
    
    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}