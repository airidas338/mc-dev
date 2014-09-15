package net.minecraft.server;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;

public interface IScoreboardCriteria {

	Map criteria = Maps.newHashMap();
	IScoreboardCriteria b = new ScoreboardBaseCriteria("dummy");
	IScoreboardCriteria c = new ScoreboardBaseCriteria("trigger");
	IScoreboardCriteria d = new ScoreboardBaseCriteria("deathCount");
	IScoreboardCriteria e = new ScoreboardBaseCriteria("playerKillCount");
	IScoreboardCriteria f = new ScoreboardBaseCriteria("totalKillCount");
	IScoreboardCriteria g = new ScoreboardHealthCriteria("health");
	IScoreboardCriteria[] h = new IScoreboardCriteria[] { new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.BLACK), new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.DARK_BLUE), new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.DARK_GREEN), new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.DARK_AQUA),
			new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.DARK_RED), new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.DARK_PURPLE), new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.GOLD), new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.GRAY),
			new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.DARK_GRAY), new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.BLUE), new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.GREEN), new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.AQUA),
			new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.RED), new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.LIGHT_PURPLE), new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.YELLOW), new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.WHITE) };
	IScoreboardCriteria[] i = new IScoreboardCriteria[] { new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.BLACK), new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.DARK_BLUE), new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.DARK_GREEN),
			new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.DARK_AQUA), new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.DARK_RED), new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.DARK_PURPLE), new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.GOLD),
			new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.GRAY), new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.DARK_GRAY), new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.BLUE), new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.GREEN),
			new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.AQUA), new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.RED), new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.LIGHT_PURPLE), new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.YELLOW),
			new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.WHITE) };

	String getName();

	int a(List var1);

	boolean isReadOnly();

	EnumObjectiveValue c();

}
