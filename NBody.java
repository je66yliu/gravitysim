public class NBody {
    public static double readRadius(String fileName){
        In in = new In(fileName);
        in.readLine();
        return in.readDouble();
    }
    public static Planet[] readPlanets(String fileName){
        In in = new In(fileName);
        int numPlanets = in.readInt();
        Planet[] planets = new Planet[numPlanets];
        in.readDouble();
        for(int i = 0; i < numPlanets; i++){
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            planets[i] = new Planet(xP, yP, xV, yV, m, img);
        }
        return planets;
    }
}
