package com.epam.kushnarenko.plugin

import groovy.io.FileType
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import java.util.regex.Matcher
import java.util.regex.Pattern

class JavaScriptMinifierTask extends DefaultTask {

    String javaScriptDirectory;
    String outputFileName;

    final MINIFYING_REGEX = /(\\/\*(.|[\r\n])*?\*\\/|(\\\\/\\\\/(.)*))|(?<!var|return|new|else|function|if)(\s+)/
    final EMPTY_STRING = ""
    final JAVA_SCRIPT_FORMAT = ".js"

    final FIND_VARIABLES_LIST_REGEX = /var\s+((\w|\\_|\\$)+)\s*/
    final FIND_ALL_VARIABLES_REGEX = "(?=([^\"']*[\"'][^\"']*[\"'])*[^\"']*)"


    @TaskAction
    def minify() {
        File file = getFile(javaScriptDirectory, outputFileName, JAVA_SCRIPT_FORMAT)
        println(javaScriptDirectory)
        println(outputFileName)
        def myOutputResult = readFile(javaScriptDirectory, JAVA_SCRIPT_FORMAT)
        myOutputResult = myOutputResult.replaceAll(MINIFYING_REGEX, EMPTY_STRING)




        Pattern regex = Pattern.compile(FIND_VARIABLES_LIST_REGEX);
        Matcher regexMatcher = regex.matcher(myOutputResult);
        def variables = [] as Set

        final String alphabet = "0123456789ABCDE";
        final int N = alphabet.length();
        Random r = new Random();
        while (regexMatcher.find()) {
            variables.add(regexMatcher.group(1))
        }
        Iterator<String> iter = variables.iterator()


        while (iter.hasNext()) {
            String variable = iter.next()
            String newVariableName = "${variable} \$${alphabet.charAt(r.nextInt(N))}";
            while (variables.contains(newVariableName)) {
                newVariableName = "${variable} \$${alphabet.charAt(r.nextInt(N))}";
            }
            variables.add(newVariableName)
            println(newVariableName)
            //myOutputResult.replaceAll(s + FIND_ALL_VARIABLES_REGEX, newVariableName)
        }


        println(myOutputResult)
        println(variables)


        file.text = myOutputResult
    }

    static String readFile(String directory, String fileType) {
        def output = new StringBuilder()
        new File(directory).eachFileRecurse(FileType.FILES) {
            if (it.name.endsWith(fileType)) {
                it.readLines().each { line ->
                    output <<= line << '\n'
                }
            }
        }
        return output.toString()
    }

    static File getFile(String directory, fileName, fileFormat) {
        return new File(directory + "/${fileName}${fileFormat}")
    }

}
