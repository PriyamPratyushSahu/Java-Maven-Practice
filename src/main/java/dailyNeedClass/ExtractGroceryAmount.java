package dailyNeedClass;

public class ExtractGroceryAmount {
    public static void main(String[] args) {
        String groceryString = "";
        String eachItem[] = groceryString.split("\n");
        String totalFormula = "= ";
        double totalPrice = 0.0;
        System.out.println("Individual Price print");
        for(String i :eachItem){
            // Splitting string into two parts - Item name, Price
            String priceSplit[] = i.split("₹ ");

            //Extracting the bracket content
            int leftBracketPos = priceSplit[0].indexOf('(');
            int rightBracketPos = priceSplit[0].indexOf(')');
            String insideBracketValue = priceSplit[0].substring(leftBracketPos,(rightBracketPos+1));
            System.out.println(insideBracketValue +" / ₹ " + priceSplit[1]);
            totalPrice += Double.parseDouble(priceSplit[1]);
            //Preparing a string of total formula
            if(totalFormula.compareTo("= ") == 0)
            totalFormula = totalFormula.concat(priceSplit[1]);
            else
                totalFormula = totalFormula.concat(" + "+priceSplit[1]);
        }
        System.out.printf("%.2f\n", totalPrice);
        System.out.println("\nFormula Print");
        System.out.println(totalFormula);

    }
}
