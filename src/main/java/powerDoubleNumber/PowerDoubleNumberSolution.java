package powerDoubleNumber;

/**
 * Created by yaodongluo on 2018/7/9.
 */
public class PowerDoubleNumberSolution {
    public double Power(double base, int exponent){
        double b =0.0;
        if(exponent==0){
            return 1;
        }
        if(exponent>0){
            b = PowerPositive(base,exponent);
        }
        if(exponent<0){
            b =  1/Power(base,-exponent);
        }
        return b;
    }

    private double PowerPositive(double base, int exponent) {
        if(exponent==0){
            return 1;
        }
        if(exponent==1){
            return base;
        }
        return PowerPositive(base,exponent-1)*base;
    }

    public static void main(String[] args){
        PowerDoubleNumberSolution solution = new PowerDoubleNumberSolution();
        System.out.println(solution.Power(2,-3));
    }
}
