
package Program;

import java.lang.Math;

public class Trinomial {
    private double a, b, c;
    private double delta;
    private int solutions;
    private double x1, x2;
    
    private void setA(double a) { this.a = a; }
    private void setB(double b) { this.b = b; }
    private void setC(double c) { this.c = c; }
    private void setDelta(double delta) { this.delta = delta; }
    private void setSolutions(int solutions) { this.solutions = solutions; }
    private void setX1(double x1) { this.x1 = x1; }
    private void setX2(double x2) { this.x2 = x2; }
    
    public double getA() { return this.a; }
    public double getB() { return this.b; }
    public double getC() { return this.c; }
    public double getDelta() { return this.delta; }
    public int getSolutions() { return this.solutions; }
    public double getX1() throws Exception { if(this.getSolutions() == 0) { throw new Exception("This trinomial has no solutions") ;} return this.x1; }
    public double getX2() throws Exception { if(this.getSolutions() == 0) { throw new Exception("This trinomial has no solutions") ;} return this.x2; }
    
    public String Solution()
    { 
        String vessel = String.format("Number of solutions: %d", this.getSolutions());
        try
        {
            if(this.getSolutions() == 2)
            {
                vessel = vessel + String.format("\nx1 = %f\nx2 = %f", this.getX1(), this.getX2());
            }
            else if(this.getSolutions() == 1)
            {
                vessel = vessel + String.format("\nx = %f", this.getX1());
            }
            else
            {
                vessel = vessel + String.format("\nDelta = %f", this.getDelta());
            }
        }
        catch(Exception e) {} // Can't happen under any circumstances anyway
        return vessel;
    }
    
    @Override public String toString()
    {
        String vessel = String.format("%fx^2 ", this.getA());
        if(this.getB() > 0) vessel = vessel + String.format("+%fx ", this.getB());
        else vessel = vessel + String.format("%fx ", this.getB());
        if(this.getC() > 0) vessel = vessel + String.format("+%f ", this.getC());
        else vessel = vessel + String.format("%f ", this.getC());
        return vessel;
    }
    
    Trinomial(double a, double b, double c)
    {
        this.setA(a);
        this.setB(b);
        this.setC(c);
        
        double d = Math.pow(b,2) - 4*a*c;
        this.setDelta(d);
        
        if(d > 0) 
        { 
            this.setSolutions(2); 
            double rd = Math.sqrt(d);
            this.setX1((-b + rd) / (2*a));
            this.setX2((-b - rd) / (2*a));
        }
        else if(d == 0) 
        { 
            this.setSolutions(1); 
            this.setX1((-b) / (2*a));
            this.setX2((-b) / (2*a));
        }
        else 
        { 
            this.setSolutions(0); 
            this.setX1(0);
            this.setX2(0);
        }
        
    }
    
    private Trinomial() {}
}
