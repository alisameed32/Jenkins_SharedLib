def call(){
    // Added '--purge' to additionalArguments to clean the corrupted DB
    dependencyCheck additionalArguments: '--scan ./ --purge', odcInstallation: 'OWASP'
    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}