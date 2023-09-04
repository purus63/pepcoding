package March6;

import java.util.Scanner;

abstract class Food {
    double proteins;
    double fats;
    double carbs;
    double tastyScore;

    abstract void getMacroNutrients();
}

class Egg extends Food {
    String type = "non-vegetarian";

    public Egg(double proteins, double fats, double carbs) {
        this.proteins = proteins;
        this.fats = fats;
        this.carbs = carbs;
        this.tastyScore = 7;
    }

    @Override
    void getMacroNutrients() {
        System.out.println("An egg has " + this.proteins + " gms of protein, " + this.fats + " gms of fats and " + this.carbs + " gms of carbohydrates");
    }
}

class Bread extends Food {
    String type = "vegetarian";

    public Bread(double proteins, double fats, double carbs) {
        this.proteins = proteins;
        this.fats = fats;
        this.carbs = carbs;
        this.tastyScore = 8;
    }

    @Override
    void getMacroNutrients() {
        System.out.println("A slice of bread has " + this.proteins + " gms of protein, " + this.fats + " gms of fats and " + this.carbs + " gms of carbohydrates");
    }
}

public class NutritionChain {

    static void getMacros(String foodCls, Food f) {
        if (f instanceof Bread) {
            System.out.println(foodCls + " is " + ((Bread) f).type);
        } else if (f instanceof Egg) {
            System.out.println(foodCls + " is " + ((Egg) f).type);
        }
    }

    static void getTaste(Food f) {
        System.out.println("Taste: " + f.tastyScore);
    }

    static void getType(Food f) {
        f.getMacroNutrients();
    }

    static void process(String mname, Food f) {
        switch (mname) {
            case "getMacros": {
                getMacros(f.getClass().getSimpleName(), f);
                break;
            }
            case "getTaste": {
                getTaste(f);
                break;
            }
            case "getType": {
                getType(f);
                break;
            }
            default:
                break;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String foodCls = sc.nextLine();
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String str3 = sc.nextLine();

        Food f = null;
        if (foodCls.equals("Bread"))
            f = new Bread(1, 2, 3);
        if (foodCls.equals("Egg"))
            f = new Egg(1, 2, 3);

        process(str1, f);
        process(str2, f);
        process(str3, f);
    }
}
