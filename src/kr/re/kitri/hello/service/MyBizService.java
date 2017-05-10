package kr.re.kitri.hello.service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

/**
 * Created by danawacomputer on 2017-05-08.
 */
public class MyBizService {
    public static int processLogic(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }
    public static int sumIntList(List <Integer> intList) {
//        int sum = 0;
//        for(int e : intList){
//        sum += e;
//    }
    int result =
            intList.stream()
            .mapToInt(x -> x.intValue())
            .sum();
        return result;
    }

    public static double averageIntList(List<Integer> intList) throws Exception{
//    int sum = 0;
//    int count = 0;
//    for(int e : intList){
//        count++;
//        sum += e;
//    }
//        double average = sum/count;
        OptionalDouble result = intList.stream()
             .mapToInt(x -> x.intValue())
             .average();
        if(result.isPresent()){
            return result.getAsDouble();//데이터가 있으면
        } else {
            throw new Exception("데이터가 없어서 평균을 구할수 없어요");
        }
    }
}
