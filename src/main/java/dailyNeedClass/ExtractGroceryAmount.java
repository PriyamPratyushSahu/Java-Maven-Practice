package dailyNeedClass;

public class ExtractGroceryAmount {
    public static void main(String[] args) {
        String groceryString = "Cucumber(4) = ₹ 19.78\n" +
                "Tomato(4) = ₹ 10.07\n" +
                "Onion(8/835gm) = ₹ 15.03\n" +
                "Dhaniya = ₹ 8\n" +
                "Pudina = ₹ 8\n";
        String eachItem[] = groceryString.split("\n");
        String totalFormula = "= ";
        System.out.println("Individual Price print");
        for(String i :eachItem){
            String priceSplit[] = i.split("₹ ");
            if(totalFormula.compareTo("= ") == 0)
            totalFormula = totalFormula.concat(priceSplit[1]);
            else
                totalFormula = totalFormula.concat(" + "+priceSplit[1]);
            System.out.println(priceSplit[1]);
        }
        System.out.println("\n\n\nFormula Print");
        System.out.println(totalFormula);
    }
}
