
import java.util.*;

abstract class Shape {
    HashMap<String,Object> hm = new HashMap<String, Object>();       //hashmap which replicates the behaviour of dictionary to store keys as shape name and value as measurements       
    protected abstract void area(HashMap details);                   //shape and area are abstract
}   


class OverloadedArea extends Shape {

    @Override                                                   //overriding the area method from abstract class shape
    protected void area(HashMap details) {

        if (details.containsKey("circle")) {
            double r = (Double) details.get("circle");
            double a = 3.14 * r * r;
            System.out.println("The area of the circle is "+a+" sq units");
        }

        if (details.containsKey("square")) {

            float l = (Float) details.get("square");
            System.out.println("The area of the square is "+ l * l +" sq units");
        }

        if (details.containsKey("rectangle")) {
            ArrayList a = (ArrayList) details.get("rectangle");
            Float l = (Float) a.get(0);
            Float b = (Float) a.get(1);
            System.out.println("The area of the rectangle is "+ l * b +" sq units");
        }

        if (details.containsKey("triangle")) {
            ArrayList a = (ArrayList) details.get("triangle");
            Double s1 = (Double) a.get(0);
            Double s2 = (Double) a.get(1);
            Double s3 = (Double) a.get(2);
            Double sp = (s1 + s2 + s3) / 2;
            Double ar = Math.sqrt(sp * (sp-s1) * (sp-s2) * (sp-s3));
            System.out.println("The area of the triangle is "+ ar +" sq units");

        }
    
    }
        
}


class a {
    public static void main(String[] args) {
        HashMap<String,Object> hm = new HashMap<String, Object>();
        ArrayList<Float> det = new ArrayList<Float>();                  //arraylist for float details used in area of rectangle
        Scanner sc = new Scanner(System.in);

        System.out.println("Which shapes area would you like to calculate? (Square, Rectangle, Circle or Triangle)");
        String ch = sc.next().toLowerCase();
        OverloadedArea areaObj = new OverloadedArea();                  //calling different area methods based on the 
        if (ch.equals("circle")) {                                      //value in the hashmap 
            System.out.println("Enter radius of the circle : ");
            Double r = sc.nextDouble();
            hm.put("circle", r);
            areaObj.area(hm);
        }

        else if (ch.equals("square")) {
            System.out.println("Enter length of the side of square : ");
            float l = sc.nextFloat();
            hm.put("square", l);
            areaObj.area(hm);
        }

        else if (ch.equals("rectangle")) {
            System.out.println("Enter length of the rectangle : ");
            float l = sc.nextFloat();
            System.out.println("Enter breadth of the rectannle :");
            float b = sc.nextFloat();
            det.clear();
            det.add(l);
            det.add(b);
            hm.put("rectangle", det);
            areaObj.area(hm);
        }

        else if (ch.equals("triangle")) {
            ArrayList<Double> doubleDet = new ArrayList<Double>();      //arraylist for double details used for area of triangle
            System.out.println("Enter side 1 :");
            Double s1 = sc.nextDouble();
            System.out.println("Enter side 2 :");
            Double s2 = sc.nextDouble();
            System.out.println("Enter side 3 :");
            Double s3 = sc.nextDouble();
            det.clear();
            doubleDet.add(s1);
            doubleDet.add(s2);
            doubleDet.add(s3);
            hm.put("triangle", doubleDet);
            areaObj.area(hm);

        }

        else {
            System.out.println("Please type the correct spelling...");
            System.out.println("Exiting...");
        }
        sc.close();
    }
}

