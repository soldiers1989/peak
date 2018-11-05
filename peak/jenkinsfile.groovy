node {
    properties([parameters([
            string(defaultValue: '1.3.0', description: '', name: 'version'),
            choice(choices: 'All\npeak-dd\npeak-flow\npeak-flow-h5\npeak-guest\npeak-guest-h5\npeak-sys', description: '', name: 'module'),
            choice(choices: 'All\nnode Build\nBuild\nDeploy', description: '', name: 'stage')
    ]), pipelineTriggers([])])

    stage('SubversionSCM') {
        checkout([$class        : 'SubversionSCM', filterChangelog: false, ignoreDirPropChanges: false,
                  locations     : [[cancelProcessOnExternalsFail: true, credentialsId: 'SVN_ACCOUNT', depthOption: 'infinity',
                                    ignoreExternalsOption       : true, local: '.', remote: 'svn://192.168.111.211/bigdata/code/peak/branch/peak_1.3.0/frontend']],
                  quietOperation: true, workspaceUpdater: [$class: 'UpdateUpdater']])
    }

    if (params.stage == 'All' || params.stage == 'node Build') {
        stage('node Build') {
            nodejs('NodeJS') {
                parallel flow: {
                            if (params.module == 'All' || params.module == 'peak-flow') {
                                sh '''cd ${WORKSPACE}/peak-flow/peak-flow-manage/process
                    npm install
                    ng build --prod --output-hashing=none
                    cd ../server
                    npm install'''
                            }
                        },
                        flowH5:{
                            if (params.module == 'All' || params.module == 'peak-flow-h5') {
                                sh '''cd ${WORKSPACE}/peak-flow/peak-flow-h5/app
                    npm install
                    npm run build --prod --output-hashing=none
                    cd ../server
                    npm install'''
                            }
                        },
                        dd: {
                            if (params.module == 'All' || params.module == 'peak-dd') {
                                sh '''cd ${WORKSPACE}/peak-dd/app
					npm install
					ng build --prod --output-hashing=none
					cd ../server
					npm install'''
                            }
                        },
                        resource: {
                            if (params.module == 'All' || params.module == 'peak-sys') {
                                sh '''cd ${WORKSPACE}/peak-resource/app
					npm install
					ng build --prod --output-hashing=none
					cd ../server
					npm install'''
                            }
                        },
                        guest: {
                            if (params.module == 'All' || params.module == 'peak-guest') {
                                sh '''cd ${WORKSPACE}/peak-guest/peak-guest-manage/app
					npm install
					ng build --prod --output-hashing=none
					cd ../server
					npm install'''
                            }
                        },
                        guestH5:{
                            if (params.module == 'All' || params.module == 'peak-guest-h5') {
                                sh '''cd ${WORKSPACE}/peak-guest/peak-guest-h5/app
					npm install
					ng build --prod --output-hashing=none
					cd ../server
					npm install'''
                            }
                        }
            }
        }
    }

    if (params.stage == 'All' || params.stage == 'Build') {
        stage('Build') {
            echo 'Build'
            echo "${params.module}"
            echo "${params.version}"
            def dockerfile = 'Dockerfile'
            parallel flow: {
                if (params.module == 'All' || params.module == 'peak-flow') {
                    docker.withRegistry('https://ccr.ccs.tencentyun.com', 'DOCKER_REP_KEY') {
                        dir('peak-flow/peak-flow-manage/server'){
                            def customImageFlowFront = docker.build("ccr.ccs.tencentyun.com/bjd_bigdata/peak-flow-front:${params.version}", "-f ${dockerfile} .")
                            customImageFlowFront.push()
                        }
                    }
                }
            }, flowH5: {
                if (params.module == 'All' || params.module == 'peak-flow-h5') {
                    docker.withRegistry('https://ccr.ccs.tencentyun.com', 'DOCKER_REP_KEY') {
                        dir('peak-flow/peak-flow-h5/server'){
                            def customImageFlowFront = docker.build("ccr.ccs.tencentyun.com/bjd_bigdata/peak-flow-h5-front:${params.version}", "-f ${dockerfile} .")
                            customImageFlowFront.push()
                        }
                    }
                }
            } , resource: {
                if (params.module == 'All' || params.module == 'peak-sys') {
                    docker.withRegistry('https://ccr.ccs.tencentyun.com', 'DOCKER_REP_KEY') {
                        dir('peak-resource/server') {
                            def customImageSysFront = docker.build("ccr.ccs.tencentyun.com/bjd_bigdata/peak-resource-front:${params.version}", "-f ${dockerfile} .")
                            customImageSysFront.push()
                        }
                    }
                }
            }, dd: {
                if (params.module == 'All' || params.module == 'peak-dd') {
                    docker.withRegistry('https://ccr.ccs.tencentyun.com', 'DOCKER_REP_KEY') {
                        dir('peak-dd/server') {
                            def customImageSysFront = docker.build("ccr.ccs.tencentyun.com/bjd_bigdata/peak-dd-front:${params.version}", "-f ${dockerfile} .")
                            customImageSysFront.push()
                        }
                    }
                }

            }, guest: {
                if (params.module == 'All' || params.module == 'peak-guest') {
                    docker.withRegistry('https://ccr.ccs.tencentyun.com', 'DOCKER_REP_KEY') {
                        dir('peak-guest/peak-guest-manage/server') {
                            def customImageSysFront = docker.build("ccr.ccs.tencentyun.com/bjd_bigdata/peak-guest-front:${params.version}", "-f ${dockerfile} .")
                            customImageSysFront.push()
                        }
                    }
                }
            }, guestH5:{
                if (params.module == 'All' || params.module == 'peak-guest-h5') {
                    docker.withRegistry('https://ccr.ccs.tencentyun.com', 'DOCKER_REP_KEY') {
                        dir('peak-guest/peak-guest-h5/server') {
                            def customImageSysFront = docker.build("ccr.ccs.tencentyun.com/bjd_bigdata/peak-guest-h5-front:${params.version}", "-f ${dockerfile} .")
                            customImageSysFront.push()
                        }
                    }
                }
            }
        }
    }

    if (params.stage == 'All' || params.stage == 'Deploy') {
        stage('Deploy') {
            echo 'Build'
            echo "${params.module}"
            echo "${params.version}"

            def remote = [:]
            remote.name = "dockerManager"
            remote.host = "jenkins.bjdcloud.com"
            remote.allowAnyHosts = true

            withCredentials([sshUserPrivateKey(credentialsId: 'SSH_KEY', keyFileVariable: 'identity', passphraseVariable: '', usernameVariable: 'userName')]) {
                remote.user = userName
                remote.identityFile = identity
                parallel flow: {
                    if (params.module == 'All' || params.module == 'peak-flow') {
                        sshCommand remote: remote, command: "mkdir -p /home/wheel/peak-flow-front"
                        sshPut remote: remote, from: './peak-flow/peak-flow-manage/docker-compose.yml', into: '/home/wheel/peak-flow-front/docker-compose.yml'
                        sshCommand remote: remote, command: "export VERSION=${params.version} && docker stack deploy -c /home/wheel/peak-flow-front/docker-compose.yml --with-registry-auth peak-flow-front"
                    }
                }, flowH5: {
                    if (params.module == 'All' || params.module == 'peak-flow-h5') {
                        sshCommand remote: remote, command: "mkdir -p /home/wheel/peak-flow-h5-front"
                        sshPut remote: remote, from: './peak-flow/peak-flow-h5/docker-compose.yml', into: '/home/wheel/peak-flow-h5-front/docker-compose.yml'
                        sshCommand remote: remote, command: "export VERSION=${params.version} && docker stack deploy -c /home/wheel/peak-flow-h5-front/docker-compose.yml --with-registry-auth peak-flow-h5-front"
                    }
                }, resource: {
                    if (params.module == 'All' || params.module == 'peak-sys') {
                        sshCommand remote: remote, command: "mkdir -p /home/wheel/peak-sys-front"
                        sshPut remote: remote, from: './peak-resource/docker-compose.yml', into: '/home/wheel/peak-sys-front/docker-compose.yml'
                        sshCommand remote: remote, command: "export VERSION=${params.version} && docker stack deploy -c /home/wheel/peak-sys-front/docker-compose.yml --with-registry-auth peak-resource-front"
                    }
                }, dd: {
                    if (params.module == 'All' || params.module == 'peak-dd') {
                        sshCommand remote: remote, command: "mkdir -p /home/wheel/peak-dd-front"
                        sshPut remote: remote, from: './peak-dd/docker-compose.yml', into: '/home/wheel/peak-dd-front/docker-compose.yml'
                        sshCommand remote: remote, command: "export VERSION=${params.version} && docker stack deploy -c /home/wheel/peak-dd-front/docker-compose.yml --with-registry-auth peak-dd-front"
                    }
                }, guest: {
                    if (params.module == 'All' || params.module == 'peak-guest') {
                        sshCommand remote: remote, command: "mkdir -p /home/wheel/peak-guest-front"
                        sshPut remote: remote, from: './peak-guest/peak-guest-manage/docker-compose.yml', into: '/home/wheel/peak-guest-front/docker-compose.yml'
                        sshCommand remote: remote, command: "export VERSION=${params.version} && docker stack deploy -c /home/wheel/peak-guest-front/docker-compose.yml --with-registry-auth peak-guest-front"
                    }
                }, guestH5: {
                    if (params.module == 'All' || params.module == 'peak-guest-h5') {
                        sshCommand remote: remote, command: "mkdir -p /home/wheel/peak-guest-h5-front"
                        sshPut remote: remote, from: './peak-guest/peak-guest-h5/docker-compose.yml', into: '/home/wheel/peak-guest-h5-front/docker-compose.yml'
                        sshCommand remote: remote, command: "export VERSION=${params.version} && docker stack deploy -c /home/wheel/peak-guest-h5-front/docker-compose.yml --with-registry-auth peak-guest-h5-front"
                    }
                }
            }
        }
    }
}