	public class Line{
	private double m,c;
	public double Line(double x,double y,double m){
	c=y-m*x;
	return c;	
	}
	public double Line(double x1,double y1,double x2,double y2){
	m=(y2-y1)/(x2-x1);
	c=y1-m*x1;
	return c;
	}
	public double Slope(double x1,double y1,double x2,double y2){
	m=(y2-y1)/(x2-x1);
	return m;
	}
  public int Line(double sl,double in){
    m=sl;
    c=in;
    return 0;
  }
  public boolean Intersects(double slope){
    if(m==slope)
      return false;
    else
      return true;
  }
  public boolean Parallel(double slope){
    if(m==slope)
      return true;
    else
      return false;
    }
  public boolean Equals(double slope,double c){
    if(m==slope&&this.c==c)
      return true;
    else
      return false;
  }
  }
