package schimbvalutar;

public class XchangeModel {
    private double finalvalue=0.0;
    private double sum=0.0;
    private int i=0;
    private int j=0;
    public void setSum(double s)
    {
        this.sum=s;
    }

    public void setFinalvalue(double rate)
    {
        this.finalvalue=rate*this.sum;
    }
    public int getIndex(String s) {
        if (s.equals("RON - Leul romanesc")) {
            return 0;

        } else if (s.equals("EUR - EURO"))
            return 1;
        else
            return 2;

    }
    public double getValue(Double sum,Double [][] values)
    {
        sum=sum*values[i][j];
        return sum;
    }


    public double getDefaultValue(Double [][] values, String s1,String s2)
    {
        double val=0.0;
         i=getIndex(s1);
         j=getIndex(s2);
        val=1.0/values[i][j];
        return val;
    }

}
