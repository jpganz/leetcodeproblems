package leetcode.java.general;


/*
https://leetcode.com/problems/evaluate-division/
 */

import java.util.*;

// TODO: complete this, quite hard for now
public class EvaluateDivision {


    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        int counter = 0;
        String key;
        for(List<String> equation: equations) {
            key = equation.get(0);
            Double val = values[counter];

            if(graph.containsKey(key)) {
                HashMap<String, Double> current = graph.get(key);
                current.put(equation.get(1), val);
            } else {
                HashMap<String, Double> current = new HashMap<>();
                current.put(equation.get(1), val);
                graph.put(key, current);
            }

            counter++;
        }

        // perform the queries :)


        return new double[]{};
    }




    // b / c = 3.0

    public static void main(String[] args) {
        List<List<String>> input = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );
       double[] values = new double[]{2.0, 3.0};
       List<List<String>> queries = Arrays.asList(
               Arrays.asList("a","c"),
               Arrays.asList("b", "a"),
               Arrays.asList("a", "e"),
               Arrays.asList("a", "a"),
               Arrays.asList("x", "x")
       );

       double[] response = calcEquation(input, values, queries);
       System.out.println(Arrays.toString(response));
//        String[] test = "ccccaaa".split("");
//        Arrays.sort(test);
//        System.out.println(Arrays.toString(test));
    }
}

