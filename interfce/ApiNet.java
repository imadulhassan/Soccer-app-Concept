package com.soccer.interfce;

import com.soccer.pojo.coaches.CochesResponse;
import com.soccer.pojo.countries.ResponseCountries;
import com.soccer.pojo.event.EventResponse;
import com.soccer.pojo.fixture.ResponseFixture;
import com.soccer.network.RetrofitClientt;
import com.soccer.pojo.fixturestat.FixtureStat;
import com.soccer.pojo.leauge.ResponseLeauge;
import com.soccer.pojo.oddfix.OddResponce;
import com.soccer.pojo.playerStat.PlayerStatictics;
import com.soccer.pojo.prediction.PredictionResponce;
import com.soccer.pojo.round.RoundResponse;
import com.soccer.pojo.searchpojo.SearchResponse;
import com.soccer.pojo.standing.StandingResponse;
import com.soccer.pojo.table.LeagueTableResponse;
import com.soccer.pojo.teamPlayer.TeamPlayerResponse;
import com.soccer.pojo.teamleagues.TeamLeagueResponse;
import com.soccer.pojo.teamstat.TeamStat;
import com.soccer.pojo.transfer.TransferResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiNet {


    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("fixtures/date/{date}/")
    Call<ResponseFixture>   getFixtureFromDate(@Path("date") String date

    );

    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET(" fixtures/team/{team}/")
    Call<ResponseFixture>   getFixtureFromteamid(@Path("team") String team

    );

    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("fixtures/h2h/{team_home}/{team_away}")
    Call<ResponseFixture>   getFixtureH2h(@Path("team_home") String teamhome,@Path("team_away") String teamaway

    );




    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("teams/search/{search}")
    Call<SearchResponse>   getSearch(@Path("search") String search
    );




    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("statistics/{league_id}/{team_id}")
    Call<TeamStat>   getTeamStatistics(@Path("team_id") String team_id,
                                       @Path("league_id") String league_id
    );

    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("fixtures/live")
    Call<ResponseFixture>   getFixtureLive(
    );
    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("statistics/fixture/{fixture_id}")
    Call<FixtureStat>   getFixtureStatistics(@Path("fixture_id") String fixture_id
    );



    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("odds/fixture/{fixture_id}")
    Call<OddResponce>   getFixtureOdds(@Path("fixture_id") String fixture_id
    );




    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("leagues")
    Call<ResponseLeauge>   getAvailavleLeauges(
    );


    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("leagues/country/{country}/2019")
    Call<ResponseLeauge>   getAvailavleLeaugesFromCountry(@Path("country") String country);



    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("countries")
    Call<ResponseCountries>   getAvailableCounries(
    );




    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("fixtures/league/{league_id}")
    Call<ResponseFixture>   getLeagueMatches(@Path("league_id") String league_id
    );





    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("leagueTable/{league_id}")
    Call<StandingResponse>   getLeagueTable(@Path("league_id") String league_id
    );


    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("fixtures/league/{league_id}")
    Call<StandingResponse>   getLeagueStanding(@Path("league_id") String league_id
    );



    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("transfers/team/{team_id}")
    Call<TransferResponse>   getTeamTransfer(@Path("team_id") String team_id
    );

    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("coachs/team/{team_id}")
    Call<CochesResponse>   getTeamCoach(@Path("team_id") String team_id
    );

    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("predictions/{fixture_id}")
    Call<PredictionResponce>   getFixturePrediction(@Path("fixture_id") String fixture_id
    );



    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("events/{fixture_id}")
    Call<EventResponse>   getFixtureEvent(@Path("fixture_id") String fixture_id
    );


    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("players/fixture/{fixture_id}")
    Call<PlayerStatictics>   getFixturePlayerStatistics(@Path("fixture_id") String fixture_id
    );



    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("players/squad/{team_id}/{season}")
    Call<TeamPlayerResponse>   getTeamPlayer(@Path("team_id") String team_id, @Path("season") String season
    );



    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("leagues/team/{team_id}")
    Call<TeamLeagueResponse>   getTeamLeagues(@Path("team_id") String team_id);



    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("fixtures/team/{team_id}/next/{number}")
    Call<ResponseFixture>   getUpcomingFixture(@Path("team_id") String teamid,@Path("number") String number);



    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("fixtures/team/{team_id}/last/{number}")
    Call<ResponseFixture>   getLastFixture(@Path("team_id") String teamid,@Path("number") String number);


    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("fixtures/league/{league_id}/last/{number}")
    Call<ResponseFixture>   getLastFixtureFromLeague(@Path("league_id") String teamid,@Path("number") String number);


    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("fixtures/league/{league_id}/next/{number}")
    Call<ResponseFixture>   getNextFixtureFromLeague(@Path("league_id") String teamid,@Path("number") String number);



    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("fixtures/rounds/{league_id}/current")
    Call<RoundResponse>   getCurrentRound(@Path("league_id") String leagueid);



    @Headers({
            RetrofitClientt.HOST,
            RetrofitClientt.KEY
    })
    @GET("fixtures/league/{league_id}/{round}")
    Call<ResponseFixture>   getRoundFixtureFromLeague(@Path("league_id") String teamid,@Path("round") String round);



}
