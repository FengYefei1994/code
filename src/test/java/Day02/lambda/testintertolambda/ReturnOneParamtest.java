package Day02.lambda.testintertolambda;

import Day02.lambda.intertolambda.ReturnOneParam;

public class ReturnOneParamtest {
    public static void main(String[] args) {
        ReturnOneParam returnOneParam = (int a) -> {
            System.out.println("ReturnOneParam param:" + a);
            return 1;
        };

        int res2 = returnOneParam.method(6);
        System.out.println("return:" + res2);

    }
}
