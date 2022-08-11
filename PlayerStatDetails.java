package com.soccer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.soccer.pojo.playerStat.PlayersItem;

public class PlayerStatDetails extends AppCompatActivity {

    TextView  shot_total , shot_on,
         goal_total , goal_conceded,goal_assist ,
    passes_total , passes_key , passes_accuracy ,
    tackle_total, tackel_blocks,tackle_interception,
            drible_attempt, dribble_success, dribble_past,
    foul_draw,foul_committed , duel_total, duel_won,
    card_yellow,card_red ,
    plenty_won,plenty_comitted,plenty_sucess,plenty_missed,plenty_saved;

    TextView team, player , postion, number, rating, min_played;
    LinearLayout captainlayout;
    PlayersItem playersItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_stat_details);
        init();
        if(getIntent().getSerializableExtra("Obj")!=null){
            playersItem= (PlayersItem) getIntent().getSerializableExtra("Obj");
            if(playersItem!=null){
                Log.d("Player", "onCreate: " +playersItem.toString());
                setData();
            }else{
                Toast.makeText(this, "Null Data ", Toast.LENGTH_SHORT).show();
            }
        }
    }

    void init(){

        ///Player Details
        team = findViewById(R.id.playerstat_team);
        player = findViewById(R.id.playerstat_player);
        postion = findViewById(R.id.playerstat_position);
        number = findViewById(R.id.playerstat_number);
        rating = findViewById(R.id.playerstat_rating);
        min_played = findViewById(R.id.playerstat_minplayed);

        //caption image layout
        captainlayout= findViewById(R.id.captain_layout);


        shot_on= findViewById(R.id.pl_stat_on);
        shot_total= findViewById(R.id.pl_stat_total);

        //goal

        goal_total= findViewById(R.id.pl_stat_goal_total);
        goal_conceded= findViewById(R.id.pl_stat_goal_conceded);
        goal_assist= findViewById(R.id.pl_stat_goal_assist);
        //passes
        passes_total= findViewById(R.id.pl_stat_passes_total);
        passes_key= findViewById(R.id.pl_stat_passes_key);
        passes_accuracy= findViewById(R.id.pl_stat_passes_acuracy);
        //tackle
        tackle_total= findViewById(R.id.pl_stat_tackle_total);
        tackle_interception= findViewById(R.id.pl_stat_tackle_interception);
        tackel_blocks= findViewById(R.id.pl_stat_tackle_block);
        //Dribble
        dribble_past= findViewById(R.id.pl_stat_dribble_past);
        dribble_success= findViewById(R.id.pl_stat_dribble_succes);
        drible_attempt = findViewById(R.id.pl_stat_dribble_attempt);

        //Foul
        foul_draw= findViewById(R.id.pl_stat_draw);
        foul_committed= findViewById(R.id.pl_stat_commited);

        //CARD
        card_red= findViewById(R.id.pl_stat_red);
        card_yellow= findViewById(R.id.pl_stat_yellow);

        //PLENTY
        plenty_comitted= findViewById(R.id.pl_stat_plenty_comited);
        plenty_missed= findViewById(R.id.pl_stat_plenty_missed);
        plenty_saved= findViewById(R.id.pl_stat_plenty_saved);
        plenty_sucess= findViewById(R.id.pl_stat_plenty_sucess);
        plenty_won= findViewById(R.id.pl_stat_plenty_won);

        //Duel
         duel_total= findViewById(R.id.pl_stat_total_duals);
         duel_won= findViewById(R.id.pl_stat__duelwon);


    }


    void setData(){

        //PlayerDetails


        if(playersItem.getTeamName()==null){
            team.setText("-");
        }else {
            team.setText(playersItem.getTeamName() + "");
        }
        if(playersItem.getPlayerName()==null){
            player.setText("-");
        }else {
            player.setText(playersItem.getPlayerName() + "");
        }

        if(playersItem.getPosition()==null){
            postion.setText("-");
        }else {
            postion.setText(playersItem.getPosition()+"");
        }
        number.setText(playersItem.getNumber()+"");

        if(playersItem.getRating()==null){
            rating.setText("-");
        }else {
            rating.setText(playersItem.getRating()+"");

        }

        min_played.setText(playersItem.getMinutesPlayed()+"");

        if(playersItem.getCaptain()!=null){
            if(playersItem.getCaptain().equals("true")){
                captainlayout.setVisibility(View.VISIBLE);
            }
        }

        // Card Details

        if(playersItem.getCards()!=null){
            card_yellow.setText(playersItem.getCards().getYellow()+"");
            card_red.setText(playersItem.getCards().getRed()+"");
        }else {
            card_yellow.setText("-");
            card_red.setText("-");
        }

        //Foul Details

        if(playersItem.getFouls()!=null){
            foul_committed.setText(playersItem.getFouls().getCommitted()+"");
            foul_draw.setText(playersItem.getFouls().getDrawn()+"");
        }else {
            foul_draw.setText("-");
            foul_committed.setText("-");
        }

        //Shot Details

        if(playersItem.getFouls()!=null){
            foul_committed.setText(playersItem.getFouls().getCommitted()+"");
            foul_draw.setText(playersItem.getFouls().getDrawn()+"");
        }else {
            foul_draw.setText("-");
            foul_committed.setText("-");
        }
        //Duels

        if(playersItem.getDuels()!=null){
            duel_won.setText(playersItem.getDuels().getWon()+"");
            duel_total.setText(playersItem.getDuels().getTotal()+"");
        }else {
            duel_won.setText("-");
            duel_total.setText("-");
        }

        //Goal Details

        if(playersItem.getGoals()!=null){

            goal_assist.setText(playersItem.getGoals().getAssists()+"");
            goal_conceded.setText(playersItem.getGoals().getConceded()+"");
            goal_total.setText(playersItem.getGoals().getTotal()+"");

        }else {
            goal_assist.setText("-");
            goal_conceded.setText("-");
            goal_total.setText("-");

        }
        //Passes Details

        if(playersItem.getPasses()!=null){

            passes_accuracy.setText(playersItem.getPasses().getAccuracy()+"");
            passes_key.setText(playersItem.getPasses().getKey()+"");
            passes_total.setText(playersItem.getPasses().getTotal()+"");

        }else {
            passes_accuracy.setText("-");
            passes_key.setText("-");
            passes_total.setText("-");

        }

        //Tackle
        if(playersItem.getTackles()!=null){

            tackel_blocks.setText(playersItem.getTackles().getBlocks()+"");
            tackle_interception.setText(playersItem.getTackles().getInterceptions()+"");
            tackle_total.setText(playersItem.getTackles().getTotal()+"");

        }else {
            tackle_interception.setText("-");
            tackle_total.setText("-");
            tackel_blocks.setText("-");

        }


        //Dribble
        if(playersItem.getDribbles()!=null){

            dribble_success.setText(playersItem.getDribbles().getSuccess()+"");
            dribble_past.setText(playersItem.getDribbles().getPast()+"");
            drible_attempt.setText(playersItem.getDribbles().getAttempts()+"");

        }else {
            dribble_success.setText("-");
            dribble_past.setText("-");
            drible_attempt.setText("-");
        }



        //PLenty
        if(playersItem.getPenalty()!=null){

            plenty_won.setText(playersItem.getPenalty().getWon()+"");
            plenty_sucess.setText(playersItem.getPenalty().getSuccess()+"");
            plenty_saved.setText(playersItem.getPenalty().getSaved()+"");
            plenty_missed.setText(playersItem.getPenalty().getMissed()+"");
            plenty_comitted.setText(playersItem.getPenalty().getCommited()+"");


        }else {

            plenty_won.setText("-");
            plenty_sucess.setText("-");
            plenty_saved.setText("-");
            plenty_missed.setText("");
            plenty_comitted.setText("-");


        }

    }


}
