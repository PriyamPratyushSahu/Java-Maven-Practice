package RealWorldApplications;

public class QnAFilter {
    public static void main(String[] args) {
        String QnAList = "";

        String splitNewLine[] = QnAList.split("\n");
        for(int i = 0; i < splitNewLine.length; i++){
            if(splitNewLine[i].length() > 6){
                String[] splitTimerAndQuestion = splitNewLine[i].split(" - ");
                if(splitNewLine[i].charAt(6) == '-'){
                    System.out.println(splitTimerAndQuestion[1]);
                }
            }
        }
    }
}