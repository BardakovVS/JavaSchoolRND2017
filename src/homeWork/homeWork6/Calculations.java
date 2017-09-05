package homeWork.homeWork6;


public class Calculations implements CalculationsInterface {

    /*private String str;*/

    public Calculations(/*String str*/) {
        /*this.str = str;*/
    }

    @Override
    public String getCalculation(String str) {
        Double res = 0.;
        Double valL, valR;
        String calcStr = new String();
        String valueL = "", valueR = "";
        String znak = "";
        String[] strArr = /*this.*/str.split("");
        int znakPos = 0;
        for (int i = 0; i < /*this.*/str.length(); i++) {
            if (strArr[i].equals("+") || strArr[i].equals("-") || strArr[i].equals("*") || strArr[i].equals("/")) {
                valueL = /*this.*/str.substring(0, i);
                znakPos = i;
                znak = strArr[i];
            } else if (strArr[i].equals("=")) {
                valueR = /*this.*/str.substring(znakPos + 1, i);
            }
        }
        valL = Double.parseDouble(valueL);
        valR = Double.parseDouble(valueR);

        if (znak.equals("+")) res = valL + valR;
        if (znak.equals("-")) res = valL - valR;
        if (znak.equals("*")) res = valL * valR;
        if (znak.equals("/")) res = valL / valR;

        calcStr = res.toString();

        System.out.println(valueL + " " + znak + " " + valueR + " = " + calcStr);
        return calcStr;
    }

}
