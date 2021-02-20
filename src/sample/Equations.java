package sample;



public class Equations {
    public static double futureValue(double p , double r, double n , double t, double pmt){
        double fv;

        fv = (p* Math.pow((1+(r/n)),n*t))+ ((pmt*n)/r)*(Math.pow((1+(r/n)),n*t)-1);
        fv= Math.round(fv * 100.0) / 100.0;
        return fv;
    }

    public static double investment(double fv , double r, double n , double t, double pmt){

        double p;

        p = (fv-(pmt*n)/r*((Math.pow((1+(r/n)),n*t))-1))/Math.pow((1+(r/n)),n*t);
        p=Math.round(p * 100.0) / 100.0;

        return p;
    }
    public static double period(double P,double r,double n,double FV,double PMT,double CpY){
        return (Math.log(((FV * r) + (CpY * PMT)) / ((P * r) + (CpY * PMT))) / (n * Math.log(1 + (r / n))));
    }
    public static double payment(double fv , double r, double n , double p, double t){  //end pmt

        double pmt;
        pmt = r*( fv - p*Math.pow((1+(r/n)),(n*t)))/(Math.pow((1+(r/n)),(n*t))-1) ;
        pmt = Math.round(pmt * 100.0) / 100.0;
                return pmt;

    }


    public static double rate(double fv , double n , double p, double t) {
        double r;
        r = n*(Math.pow((fv / p),1/(n*t))-1)*100;
        r=Math.round(r * 100.0) / 100.0;
        return r;
    }


}
