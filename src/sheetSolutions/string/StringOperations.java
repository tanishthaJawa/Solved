//package sheetSolutions.string;
//
//import java.util.Scanner;
//
//public class StringOperations {
//  public static void main(String[] args) {
//    //
//    Scanner in = new Scanner(System.in);
//    int k=0;
//    String t = "";
//    int n = in.nextInt();
//    for(int i=0;i<n;i++){
//        t=in.nextLine();
//
//        k=in.nextInt();
//
//    }
//    switch (k){
//        case 1:append( s, t);
//            break;
//        case 2:delete(p,t);
//            break;
//        case 3:print( p, t);
//            break;
//        case 4:undo()
//            break;
//        default:System.out.println("Invalid operation");
//        break;
//    }
//  }
//
//    private static void undo() {
//    }
//
//    private static void delete(int p, String t) {
//      StringBuilder t1= new StringBuilder();
//      t1.append(t);
//      for(int i =t1.length()-p; i <t1.length() ; i++) {
//          t1.deleteCharAt(i);//t1.delete(t1.length()-p,t1.length());without for loop
//      }
//        System.out.println(t1.toString());
//    }
//
//    public static void append(String s,String t){
//      System.out.println(t.concat(s));
//
//  }
//    public static void  print(int p,String t){
//        System.out.println(t.charAt(p-1));
//    }
//}
