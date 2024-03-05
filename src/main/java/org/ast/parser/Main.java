package org.ast.parser;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.utils.CodeGenerationUtils;
import com.github.javaparser.utils.SourceRoot;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        SourceRoot sourceRoot = new SourceRoot(CodeGenerationUtils.mavenModuleRoot(Main.class).resolve("src/main/resources"));

        //Compilation Unit
        CompilationUnit unit = sourceRoot.parse("", "Sample.java");

        // Get the number of the declared functions
        data.add(String.valueOf(unit.findAll(MethodDeclaration.class).size()));

        // Fetch the methods name and store in data
        unit.findAll(MethodDeclaration.class).forEach(methodDeclaration -> {
            data.add(methodDeclaration.getNameAsString());
        });

        File csvFile = new File(sourceRoot.getRoot().toString(), "function_info.csv");

        // Write from data into the file

        try (FileWriter writer = new FileWriter(csvFile)) {
            for (String row : data) {
                writer.write(String.join(",", row) + "\n");
            }
        }catch (Exception ex){
            System.out.println("Error happened: " + ex.getMessage());
        }
    }
}