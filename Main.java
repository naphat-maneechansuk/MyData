public class Main {
    public static boolean sortByASD(String x,String y){
        return x.compareTo(y) == -1;
    }
    public static void main(String[] args) {
        String  x = "AAA";
        String y = "BBB";


        String[] word = {"AAA","DDz","EEE","BB"};
        for (int i = 0; i < word.length-1; i++) {
            int room = i;
            for (int j = i+1; j < word.length; j++) {
                if(word[room].compareTo(word[j])>0){
                    room = j;
                }
            }
            String temp = word[i];
            word[i] = word[room];
            word[room] = temp;

        }
        for (String v : word){
            System.out.println(v);
        }
    }
}