package com.soccer.pojo.fixturestat;
import com.google.gson.annotations.SerializedName;
public class Statistics{

	@SerializedName("Total passes")
	private TotalPasses totalPasses;

	@SerializedName("Shots outsidebox")
	private ShotsOutsidebox shotsOutsidebox;

	@SerializedName("Offsides")
	private Offsides offsides;

	@SerializedName("Blocked Shots")
	private BlockedShots blockedShots;

	@SerializedName("Ball Possession")
	private BallPossession ballPossession;

	@SerializedName("Shots on Goal")
	private ShotsOnGoal shotsOnGoal;

	@SerializedName("Total Shots")
	private TotalShots totalShots;

	@SerializedName("Shots off Goal")
	private ShotsOffGoal shotsOffGoal;

	@SerializedName("Corner Kicks")
	private CornerKicks cornerKicks;

	@SerializedName("Yellow Cards")
	private YellowCards yellowCards;

	@SerializedName("Passes accurate")
	private PassesAccurate passesAccurate;

	@SerializedName("Shots insidebox")
	private ShotsInsidebox shotsInsidebox;

	@SerializedName("Fouls")
	private Fouls fouls;

	@SerializedName("Red Cards")
	private RedCards redCards;

	@SerializedName("Goalkeeper Saves")
	private GoalkeeperSaves goalkeeperSaves;

	@SerializedName("Passes %")
	private Passes passes;

	public void setTotalPasses(TotalPasses totalPasses){
		this.totalPasses = totalPasses;
	}

	public TotalPasses getTotalPasses(){
		return totalPasses;
	}

	public void setShotsOutsidebox(ShotsOutsidebox shotsOutsidebox){
		this.shotsOutsidebox = shotsOutsidebox;
	}

	public ShotsOutsidebox getShotsOutsidebox(){
		return shotsOutsidebox;
	}

	public void setOffsides(Offsides offsides){
		this.offsides = offsides;
	}

	public Offsides getOffsides(){
		return offsides;
	}

	public void setBlockedShots(BlockedShots blockedShots){
		this.blockedShots = blockedShots;
	}

	public BlockedShots getBlockedShots(){
		return blockedShots;
	}

	public void setBallPossession(BallPossession ballPossession){
		this.ballPossession = ballPossession;
	}

	public BallPossession getBallPossession(){
		return ballPossession;
	}

	public void setShotsOnGoal(ShotsOnGoal shotsOnGoal){
		this.shotsOnGoal = shotsOnGoal;
	}

	public ShotsOnGoal getShotsOnGoal(){
		return shotsOnGoal;
	}

	public void setTotalShots(TotalShots totalShots){
		this.totalShots = totalShots;
	}

	public TotalShots getTotalShots(){
		return totalShots;
	}

	public void setShotsOffGoal(ShotsOffGoal shotsOffGoal){
		this.shotsOffGoal = shotsOffGoal;
	}

	public ShotsOffGoal getShotsOffGoal(){
		return shotsOffGoal;
	}

	public void setCornerKicks(CornerKicks cornerKicks){
		this.cornerKicks = cornerKicks;
	}

	public CornerKicks getCornerKicks(){
		return cornerKicks;
	}

	public void setYellowCards(YellowCards yellowCards){
		this.yellowCards = yellowCards;
	}

	public YellowCards getYellowCards(){
		return yellowCards;
	}

	public void setPassesAccurate(PassesAccurate passesAccurate){
		this.passesAccurate = passesAccurate;
	}

	public PassesAccurate getPassesAccurate(){
		return passesAccurate;
	}

	public void setShotsInsidebox(ShotsInsidebox shotsInsidebox){
		this.shotsInsidebox = shotsInsidebox;
	}

	public ShotsInsidebox getShotsInsidebox(){
		return shotsInsidebox;
	}

	public void setFouls(Fouls fouls){
		this.fouls = fouls;
	}

	public Fouls getFouls(){
		return fouls;
	}

	public void setRedCards(RedCards redCards){
		this.redCards = redCards;
	}

	public RedCards getRedCards(){
		return redCards;
	}

	public void setGoalkeeperSaves(GoalkeeperSaves goalkeeperSaves){
		this.goalkeeperSaves = goalkeeperSaves;
	}

	public GoalkeeperSaves getGoalkeeperSaves(){
		return goalkeeperSaves;
	}

	public void setPasses(Passes passes){
		this.passes = passes;
	}

	public Passes getPasses(){
		return passes;
	}

	@Override
 	public String toString(){
		return 
			"Statistics{" + 
			"total passes = '" + totalPasses + '\'' + 
			",shots outsidebox = '" + shotsOutsidebox + '\'' + 
			",offsides = '" + offsides + '\'' + 
			",blocked Shots = '" + blockedShots + '\'' + 
			",ball Possession = '" + ballPossession + '\'' + 
			",shots on Goal = '" + shotsOnGoal + '\'' + 
			",total Shots = '" + totalShots + '\'' + 
			",shots off Goal = '" + shotsOffGoal + '\'' + 
			",corner Kicks = '" + cornerKicks + '\'' + 
			",yellow Cards = '" + yellowCards + '\'' + 
			",passes accurate = '" + passesAccurate + '\'' + 
			",shots insidebox = '" + shotsInsidebox + '\'' + 
			",fouls = '" + fouls + '\'' + 
			",red Cards = '" + redCards + '\'' + 
			",goalkeeper Saves = '" + goalkeeperSaves + '\'' + 
			",passes % = '" + passes + '\'' + 
			"}";
		}
}