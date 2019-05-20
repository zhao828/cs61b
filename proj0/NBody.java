public class NBody{
	private static int n;
	public static double readRadius(String s){
		In in = new In(s);
		
		n = in.readInt();
		return in.readDouble();

	}
	public static void main(String[] args) {
		double T= Double.parseDouble(args[0]);
		double dt =Double.parseDouble(args[1]);
		String filename = args[2];
		double r = readRadius(filename);
		Body[] bodies = readBodies(filename);
		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-r, r);
		// StdDraw.picture(0, 0, "images/starfield.jpg");
		// for( int i = 0;i < n;i++){
		// 	bodies[i].draw();
		// }
		// StdDraw.show();
		// StdDraw.pause(10);
		double t = 0;
		Double[] xForces = new Double[n];
		Double[] yForces = new Double[n];
		while (t <= T){
			for( int i = 0;i < n;i++){
			xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
			yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
			}
			StdDraw.picture(0, 0, "images/starfield.jpg");
			for( int i = 0;i < n;i++){
			bodies[i].update(dt,xForces[i],yForces[i]);
			bodies[i].draw();
			}			
			
			StdDraw.show();
			StdDraw.pause(10);
			t+=dt;

		}

		StdOut.printf("%d\n", bodies.length);
		StdOut.printf("%.2e\n", r);
		for (int i = 0; i < bodies.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            	bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
		}
		

		
	}
	public static Body[] readBodies(String s){
		In in = new In(s);
		
		n = in.readInt();
		
		double r = in.readDouble();
		Body[] bodies = new Body[n];
		for (int i =0 ; i < n ;i++){
			
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			bodies[i] =new Body(xxPos, yyPos, xxVel,
              yyVel, mass,imgFileName);

		}
		return bodies;

	}


}