Take any java file and write the count of the declared methods in a csv file. (Used JavaParser to parse the JavaSource file)

Sample input: 

```
class Sample {
    void method1() {
        System.out.println("Implementation of method1");
    }
    
    void method2() {
        System.out.println("Implementation of method1");
    }
}
```

Sample output 

function_info.csv

```
2
method1
method2

```
