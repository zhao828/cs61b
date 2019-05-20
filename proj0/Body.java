public class Body{
	public double xxPos;
	public double yyPos;
	public double xxVel; 
	public double yyVel; 
	public double mass;
	public String imgFileName;
	private double G = 6.67e-11;
	public Body(double xP, double yP, double xV,
              double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;

	}

	public double calcDistance(Body b){
		return Math.sqrt((xxPos-b.xxPos)*(xxPos-b.xxPos)+(yyPos-b.yyPos)*(yyPos-b.yyPos));


	}

	public double calcForceExertedBy(Body b){
		double r = calcDistance(b);
		return G*mass*b.mass/(r*r);

	}

	public double calcForceExertedByX(Body b){
		double r = calcDistance(b);
		double F = calcForceExertedBy(b);
		return F*(b.xxPos-xxPos)/r;
	}
	public double calcForceExertedByY(Body b){
		double r = calcDistance(b);
		double F = calcForceExertedBy(b);
		return F*(b.yyPos-yyPos)/r;
	}

	public double calcNetForceExertedByX(Body[] bodies){
		double Fx = 0;
		for (int i=0; i < bodies.length; i++){
			if (!this.equals(bodies[i])){
				Fx += calcForceExertedByX(bodies[i]);
			}
		}
		return Fx;
	}

	public double calcNetForceExertedByY(Body[] bodies ){
		double Fy = 0;
		for (int i=0; i < bodies.length; i++){
			if (!this.equals(bodies[i])){
				Fy += calcForceExertedByY(bodies[i]);
			}
		}
		return Fy;
	}



	public void update(double dt,double fX,double fY){
		xxVel += dt*fX/mass;
		yyVel +=  dt*fY/mass;
		xxPos += dt*xxVel;
		yyPos += dt*yyVel;

	}

	public void draw(){
		StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
	}



	public Body(Body b){
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;

	}

}