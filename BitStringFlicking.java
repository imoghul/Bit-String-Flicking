import java.util.Scanner;
public class BitStringFlicking {
    public static String operation = "";
    public static String boolExpression1 = "";
    public static String boolExpression2 = "";
    public static String input = "";
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int itterations = 11;
        for(int i = 0;i<itterations;i++) {
            System.out.println("Please enter the input");
            BitStringFlicking.input = s.nextLine();
            doAll();
		}
		s.close();
    }
   
    public static String doAnd(String boolean1, String boolean2) {
        String result = "";
        for(int i = 0; i<boolean1.length(); i++) {
            int bool1 = Integer.valueOf(boolean1.substring(i,i+1));
            int bool2 = Integer.valueOf(boolean2.substring(i,i+1));
            if(bool1+bool2==1 || bool1+bool2==0) {
                result+="0";
            }else if(bool1+bool2==2) {
                result+="1";
            }   
        }
        return result;
    }
    public static String doOr(String boolean1, String boolean2) {
        String result = "";
        for(int i = 0; i<boolean1.length(); i++) {
            int bool1 = Integer.valueOf(boolean1.substring(i,i+1));
            int bool2 = Integer.valueOf(boolean2.substring(i,i+1));
            if(bool1+bool2==1 || bool1+bool2==2) {
                result+="1";
            }else if(bool1+bool2==0) {
                result+="0";
            }   
        }
        return result;
    }
    public static String doRshift(String boolean1, int times) {
        for(int i = 0; i<times;i++) {
            boolean1 = "0"+boolean1.substring(0,boolean1.length()-1);
        }
        return boolean1;
    }
    public static String doLshift(String boolean1, int times) {
        for(int i = 0; i<times;i++) {
            boolean1 = boolean1.substring(1,boolean1.length())+"0";
        }
        return boolean1;
    }
    public static String doLCIRC(String boolean1, int times) {
        for(int i = 0;i<times;i++) {
            boolean1 = boolean1.substring(1,boolean1.length())+boolean1.substring(0,1);
        }
        return boolean1;
    }
    public static String doRCIRC(String boolean1, int times) {
        for(int i = 0;i<times;i++) {
            boolean1 = boolean1.substring(boolean1.length()-1,boolean1.length())+boolean1.substring(0,boolean1.length()-1);
        }
        return boolean1;
    }
    public static String doNot(String boolean1) {
        String result = "";
        for(int i=0;i<boolean1.length();i++) {
            if(boolean1.substring(i,i+1).equalsIgnoreCase("1")) {
                result+="0";
            }else if(boolean1.substring(i,i+1).equalsIgnoreCase("0")) {
                result+="1";
            }
        }
        return result;
    }

    public static void processOperation(String op, String bool1, String bool2) {
        if(op.equalsIgnoreCase("AND")) {
            System.out.println(doAnd(bool1,bool2));
        }else if(op.equalsIgnoreCase("OR")) {
            System.out.println(doOr(bool1,bool2));
        }else if(op.equalsIgnoreCase("NOT")) {
            System.out.println(doNot(bool1));
        }else if(op.substring(0,5).equalsIgnoreCase("RCIRC")) {
            System.out.println(doRCIRC(bool1,Integer.valueOf(op.substring(6,op.length()))));
        }else if(op.substring(0,5).equalsIgnoreCase("LCIRC")) {
            System.out.println(doLCIRC(bool1,Integer.valueOf(op.substring(6,op.length()))));
        }else if(op.substring(0,6).equalsIgnoreCase("LSHIFT")) {
            System.out.println(doLshift(bool1,Integer.valueOf(op.substring(7,op.length()))));
        }else if(op.substring(0,6).equalsIgnoreCase("RSHIFT")) {
            System.out.println(doRshift(bool1,Integer.valueOf(op.substring(7,op.length()))));
        }
    }
    public static void processInput(String in) {
        String[] splitted = in.split("\\s");
        for(int i = 0;i<splitted.length;i++) {
            for(int d = 0;d < splitted[i].length();d++) {
                if(splitted[i].substring(d,d+1).equalsIgnoreCase("1") || splitted[i].substring(d,d+1).equalsIgnoreCase("0")) {
                    if(BitStringFlicking.boolExpression1=="") {
                        BitStringFlicking.boolExpression1 = splitted[i];
                    }else {
                        BitStringFlicking.boolExpression2 = splitted[i];
                    }
                }else {
                    BitStringFlicking.operation = splitted[i];
                }
                break;
            }
        }
    }

    public static void doAll() {
        processInput(BitStringFlicking.input);
        processOperation(BitStringFlicking.operation,BitStringFlicking.boolExpression1, BitStringFlicking.boolExpression2);
	}
}