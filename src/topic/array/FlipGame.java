package array;


// https://www.programcreek.com/2014/04/leetcode-flip-game-java/
// String contains + and -, flip ++ to --, store state of string
// Check if 2 ++, flip them and create new string, reverse back
public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<String>();

        if(s==null)
            return result;

        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length-1; i++){
            if(arr[i]==arr[i+1] && arr[i]=='+'){
                arr[i]='-';
                arr[i+1]='-';
                result.add(new String(arr));
                arr[i]='+';
                arr[i+1]='+';
            }
        }

        return result;
    }


    // https://www.programcreek.com/2014/05/leetcode-flip-game-ii-java/
    // Check if first person can win
    // back track => run time 0(n^n)
    public boolean canWin(String s) {
        if(s==null||s.length()==0){
            return false;
        }

       return canWinHelper(s.toCharArray());
    }

    public boolean canWinHelper(char[] arr){
        for(int i=0; i<arr.length-1;i++){
            if(arr[i]=='+'&&arr[i+1]=='+'){
                arr[i]='-';
                arr[i+1]='-';

                // If second turn lose then first lose
                boolean win = canWinHelper(arr);

                arr[i]='+';
                arr[i+1]='+';

                //if there is a flip which makes the other player lose, the first play wins
                if(!win){
                    return true;
                }
            }
        }

        return false;
    }
}
