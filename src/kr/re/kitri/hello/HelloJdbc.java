package kr.re.kitri.hello;
import kr.re.kitri.hello.service.MyBizService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by danawacomputer on 2017-05-08.
 */
public class HelloJdbc {

    public static void main(String[] args){



//        int firstNumber = 3;
//        int secondNumber = 5;

//        int result = processLogic(firstNumber,secondNumber);

//        MyBizService service = new MyBizService();

        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
//        intList = new ArrayList<>();//의도적으로 비어있는 배열 생성

        int result = MyBizService.sumIntList(intList);
        double resultAverage = 0;
        try {
            resultAverage = MyBizService.averageIntList(intList);
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(result);
        System.out.println(resultAverage);
        System.out.printf("합은 %d 이고 평균은 %.1f 입니다.",result, resultAverage);
    }

//    public static int processLogic(int firstNumber, int seconNumber){
//        return firstNumber + seconNumber;
//    }

}
