package company_interview.m2P.L3;

public class Main {
    public static void main(String[] args) throws Exception {
        Player player1= new Player();
        player1.setNoOfPlayer(5);
        String[] playerOrder1 = new String[]{"p1","p2","p3","p4","p5"};
        player1.setPlayerOrder(playerOrder1);
        Player player2= new Player();
        player2.setNoOfPlayer(5);
        String[] playerOrder2 = new String[]{"p6","p7","p8","p9","p10"};
        player2.setPlayerOrder(playerOrder2);


        Team team1 = new Team("India",player1,2);
        Team team2 = new Team("Pakistan",player2,2);

        int overs=team1.getOver();
        while(overs>0){
            int i = 0;
            String[] playerOrder = player1.getPlayerOrder();
            String p1 = playerOrder[i];
            player1.setCurrentPlayer(i);
            String p2 = playerOrder[i+1];
            for(int over=0;over<overs;over++){
                Character [] overOrder = new Character[]{'1','1','1','1','1','1'};
                for(int res=0;res<overOrder.length;res++){
                    if(overOrder[i]=='1' || overOrder[i]=='3'){
                       int  k =player1.getCurrentPlayer();
                       String name = playerOrder[k];

                        //change the Strike
                        // calculate Run
                        player1.setCurrentPlayer(i%2);
                        if(res == overOrder.length){
                            player1.setCurrentPlayer(i%2);
                        }
                    }else if(overOrder[i] =='W'){
                        // get the player who is out
                        if(i++>playerOrder.length){
                            throw new Exception("Team1 is All Out");
                        }
                         String newPlayer = playerOrder[i++];
                         p2 = newPlayer;
                        if(res == overOrder.length){
                            player1.setCurrentPlayer(i%2);
                        }

                    }else if(overOrder[i]=='6' || overOrder[i]=='4'){
                        // add run to the current Player
                        // increment Count 4 and 6 to player profile
                        if(res == overOrder.length){
                            player1.setCurrentPlayer(i%2);
                        }

                    }
                }


            }

        }

    }
}
