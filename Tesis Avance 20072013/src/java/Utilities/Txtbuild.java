/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.File;

/**
 *
 * @author JeysonAlveiro
 */
public class Txtbuild {
     public String  Tbuild(){
         Functions g = new Functions();
        return  "<?xml version='1.0' encoding=" + g.CM() + "UTF-8" + g.CM() + "?>" + g.NL() + 
                "<!-- You may freely edit this file. See commented blocks below for -->" + g.NL() +
                "<!-- some examples of how to customize the build. -->"+ g.NL() +
                "<!-- (If you delete it and reopen the project it will be recreated.) -->" + g.NL() +
                "<!-- By default, only the Clean and Build commands use this build script. -->" + g.NL() +
                "<!-- Commands such as Run, Debug, and Test only use this build script if -->" + g.NL() +
                "<!-- the Compile on Save feature is turned off for the project. -->" + g.NL() +
                "<!-- You can turn off the Compile on Save (or Deploy on Save) setting -->" + g.NL() +
                "<!-- in the project's Project Properties dialog box.-->" + g.NL() +
                "<project name= 'Academico' default= 'default' basedir='.'>" + g.NL() + 
                "<description>Builds, tests, and runs the project Academico.</description>" + g.NL() +
                "<import file='nbproject/build-impl.xml'/>" + g.NL() +
                "<!--;" + g.NL() +
                "There exist several targets which are by default empty and which can be" + g.NL() +
                "used for execution of your tasks. These targets are usually executed" + g.NL() +
                "before and after some main targets. They are:" + g.NL() + g.NL() +
                "-pre-init:                 called before initialization of project properties" + g.NL() + 
                "-post-init:                called after initialization of project properties" + g.NL() + 
                "-pre-compile:              called before javac compilation" + g.NL() +  
                "-post-compile:             called after javac compilation " + g.NL() + 
                "-pre-compile-single:       called before javac compilation of single file" + g.NL() + 
                "-post-compile-single:      called after javac compilation of single file" + g.NL() + 
                "-pre-compile-test:         called before javac compilation of JUnit tests" + g.NL() + 
                "-post-compile-test:        called after javac compilation of JUnit tests" + g.NL() + 
                "-pre-compile-test-single:  called before javac compilation of single JUnit test" + g.NL() + 
                "-post-compile-test-single: called after javac compilation of single JUunit test" + g.NL() + 
                "-pre-dist:                 called before archive building" + g.NL() + 
                "-post-dist:                called after archive building " + g.NL() + 
                "-post-clean:               called after cleaning build products" + g.NL() + 
                "-pre-run-deploy:           called before deploying" + g.NL() + 
                "-post-run-deploy:          called after deploying" + g.NL() + g.NL() + 
                "Example of pluging an obfuscator after the compilation could look like" + g.NL() + g.NL() + 
                    "<target name='-post-compile'>" + g.NL() + 
                        g.TB() +"<obfuscate>" + g.NL() +  
                            g.TB() +g.TB() +"<fileset dir='${build.classes.dir}'/>" + g.NL() + 
                        g.TB() +"</obfuscate>" + g.NL() + 
                    "</target>" + g.NL() + g.NL() + 
                "For list of available properties check the imported" + g.NL() + 
                "nbproject/build-impl.xml file." + g.NL() + g.NL() + g.NL() +  
                "Other way how to customize the build is by overriding existing main targets." + g.NL() + 
                "The target of interest are:" + g.NL() + g.NL() +  
                "init-macrodef-javac:    defines macro for javac compilation" + g.NL() + 
                "init-macrodef-junit:   defines macro for junit execution" + g.NL() + 
                "init-macrodef-debug:    defines macro for class debugging" + g.NL() + 
                "do-dist:                archive building" + g.NL() + 
                "run:                    execution of project " + g.NL() + 
                "javadoc-build:          javadoc generation " + g.NL() + g.NL() + 
                "Example of overriding the target for project execution could look like" + g.NL() + g.NL() + 
                "<target name='run' depends='<PROJNAME>-impl.jar'>" + g.NL() + 
                       g.TB() +"<exec dir='bin' executable='launcher.exe'>" + g.NL() + 
                            g.TB() + g.TB() +"<arg file='${dist.jar}'/>" + g.NL() + 
                       g.TB() +"</exec>" + g.NL() + 
                    "</target>" + g.NL() + g.NL() + 
                "Notice that overridden target depends on jar target and not only on" + g.NL() + 
                "compile target as regular run target does. Again, for list of available" + g.NL() + 
                "properties which you can use check the target you are overriding in" + g.NL() + 
                "nbproject/build-impl.xml file." + g.NL() + 

                "-->" + g.NL() + 
                "</project>"
                ;
         
    
    }
}
