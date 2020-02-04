#!/usr/bin/env groovy
// vars/log.groovy


def call(params) {
    assert params.level
    assert params.msg

    def level = params.level
    def msg = params.msg

    println "${env.JOB_NAME} - ${env.BUILD_NUMBER} -  ${level.toUpperCase()}: ${msg}."

}