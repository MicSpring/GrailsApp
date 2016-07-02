import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.FileAppender
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy
import ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy
import grails.util.BuildSettings
import grails.util.Environment

// See http://logback.qos.ch/manual/groovy.html for details on configuration
appender('STDOUT', ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%level %logger - %msg%n"
    }
}

appender('FILE_APPENDER', RollingFileAppender) {
    file = "E:/My_Work/GrailsApp/logs/testFile.log"
    append = true
    rollingPolicy(SizeAndTimeBasedRollingPolicy) {
        fileNamePattern = "E:/My_Work/GrailsApp/logs/testFile-%d{yyyy-MM-dd}.%i.log"
        maxHistory = 30
        maxFileSize = "5MB"
    }
        encoder(PatternLayoutEncoder) {
        pattern = "%level %logger - %msg%n"
    }
}

//root(ERROR, ['STDOUT','FILE'])
/*logger("org.springframework.jms.core", DEBUG, ['STDOUT'], false)
logger("org.springframework.jms.support", DEBUG, ['STDOUT'], false)
logger("org.springframework.jms.annotation", DEBUG, ['STDOUT'], false)
logger("org.springframework.jms.config", DEBUG, ['STDOUT'], false)
logger("org.springframework.jms.support", DEBUG, ['STDOUT'], false)
logger("org.springframework.jms.support", DEBUG, ['STDOUT'], false)*/

logger("org.springframework", DEBUG, ['FILE_APPENDER'], false)
logger("org.grails", DEBUG, ['FILE_APPENDER'], false)

def targetDir = BuildSettings.TARGET_DIR
/*if (Environment.isDevelopmentMode() && targetDir) {
    appender("FULL_STACKTRACE", FileAppender) {
        file = "${targetDir}/stacktrace.log"
        append = true
        encoder(PatternLayoutEncoder) {
            pattern = "%level %logger - %msg%n"
        }
    }
    logger("StackTrace", ERROR, ['FULL_STACKTRACE'], false)

}*/
