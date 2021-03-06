public class Planet {
    public static final double G = 6.67e-11;
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet p){
        return Math.sqrt(Math.pow(xxPos - p.xxPos, 2) + Math.pow(yyPos - p.yyPos, 2));
    }
    public double calcForceExertedBy(Planet p){
        return (G*mass*p.mass)/Math.pow(calcDistance(p), 2);
    }
    public double calcForceExertedByX(Planet p){
        return (calcForceExertedBy(p) * (p.xxPos - xxPos))/calcDistance(p);
    }
    public double calcForceExertedByY(Planet p){
        return (calcForceExertedBy(p) * (p.yyPos - yyPos))/calcDistance(p);
    }
    public double calcNetForceExertedByX(Planet[] planets){
        double netForce = 0;
        for(Planet p : planets){
            if(this.equals(p)){
                continue;
            }
            netForce += calcForceExertedByX(p);
        }
        return netForce;
    }
    public double calcNetForceExertedByY(Planet[] planets){
        double netForce = 0;
        for(Planet p : planets){
            if(this.equals(p)){
                continue;
            }
            netForce += calcForceExertedByY(p);
        }
        return netForce;
    }
    public void update(double dt, double fx, double fy){
        xxVel += dt * (fx / mass);
        yyVel += dt * (fy / mass);
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }
    public void draw(){
        StdDraw.picture(xxPos, yyPos, imgFileName);
    }
}
