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
        CompilationUnit cu = sourceRoot.parse("", "Sample.java");

        data.add(String.valueOf(cu.findAll(MethodDeclaration.class).size()));
        cu.findAll(MethodDeclaration.class).forEach(methodDeclaration -> {
            data.add(methodDeclaration.getNameAsString());
        });

        File csvFile = new File(sourceRoot.getRoot().toString(), "function_info.csv");
        try (FileWriter writer = new FileWriter(csvFile)) {
            for (String row : data) {
                writer.write(String.join(",", row) + "\n");
            }
        }catch (Exception ex){
            System.out.println("Error happened: " + ex.getMessage());
        }
    }
}