package com.epam.kushnarenko.plugin

import groovy.io.FileType
import org.gradle.api.Plugin
import org.gradle.api.Project

public class JavaScriptMinifierPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.task('minify', type: JavaScriptMinifierTask)
    }
}
