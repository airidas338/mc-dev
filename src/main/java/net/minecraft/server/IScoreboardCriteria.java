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
	IScoreboardCriteria[] h = new IScoreboardCriteria[] { new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.a), new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.b), new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.c), new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.d),
			new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.e), new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.f), new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.g), new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.h),
			new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.i), new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.j), new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.k), new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.l),
			new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.m), new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.n), new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.o), new ScoreboardTeamCriteria("teamkill.", EnumChatFormat.p) };
	IScoreboardCriteria[] i = new IScoreboardCriteria[] { new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.a), new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.b), new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.c),
			new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.d), new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.e), new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.f), new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.g),
			new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.h), new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.i), new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.j), new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.k),
			new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.l), new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.m), new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.n), new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.o),
			new ScoreboardTeamCriteria("killedByTeam.", EnumChatFormat.p) };

	String getName();

	int a(List var1);

	boolean isReadOnly();

	EnumObjectiveValue c();

}
