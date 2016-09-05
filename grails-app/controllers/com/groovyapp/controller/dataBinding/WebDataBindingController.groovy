package com.groovyapp.controller.dataBinding

import com.groovyapp.util.model.DemoModel
import com.groovyapp.util.model.WebDataBindingCommand
import com.groovyapp.util.model.WebDataBindingNestedCommand
import org.apache.commons.codec.binary.Base64

/**
 * Created by user on 7/31/2016.
 */
class WebDataBindingController {

    def codecLookup

    def modelCommandNMap(DemoModel demoModel) {
        println "DemoModel: $demoModel \n Map: $map Params: $params"
        render 'ok - GET '
    }

    def modelCommandNMapPost(WebDataBindingCommand webDataBindingCommand) {
        // def demoModel = new DemoModel(params)
        println "Params(post): $params"
        //def webDataBindingCommand = new WebDataBindingCommand(params.webDataBindingCommand)
        //webDataBindingCommand.properties = params
        println "***********************************************************"
        println "webDataBindingCommand: $webDataBindingCommand"
        println "***********************************************************"
        render "ok (Auto Data Binding Models as Action Args (Coc)) - ${request.getMethod()} "
    }

    def modelCommandNMapParams() {
        // def demoModel = new DemoModel(params)
        println "Params(post): $params"

        /**
         * Very Very Important:
         * @BindUsing is not applicable when Using params for binding (Like below)
         *
         * However with bindData() method it works.....
         *
         */

        def webDataBindingCommand = new WebDataBindingCommand()
        bindData(webDataBindingCommand,params)
        //def webDataBindingCommand = new WebDataBindingCommand(params.webDataBindingCommand)
        //webDataBindingCommand.properties = params
        println "***********************************************************"
        println "webDataBindingCommand: $webDataBindingCommand"
        println "***********************************************************"

        println "***********************************************************"
        String str = new String('modelCommandNMapParams'.encodeAsMyCustom())
        println "Enoded Val: $str"
        println "Decoded Val: ${new String(str.decodeMyCustom())}"
        println "***********************************************************"


        render "ok WITH PARAMS (Manually Data Binding) - ${request.getMethod()} "
    }
}
