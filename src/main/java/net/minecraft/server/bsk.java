package net.minecraft.server;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;

public interface bsk {

	Map a = Maps.newHashMap();
	bsk b = new bsi("dummy");
	bsk c = new bsi("trigger");
	bsk d = new bsi("deathCount");
	bsk e = new bsi("playerKillCount");
	bsk f = new bsi("totalKillCount");
	bsk g = new bsj("health");
	bsk[] h = new bsk[] { new bsh("teamkill.", EnumChatFormat.a), new bsh("teamkill.", EnumChatFormat.b), new bsh("teamkill.", EnumChatFormat.c), new bsh("teamkill.", EnumChatFormat.d),
			new bsh("teamkill.", EnumChatFormat.e), new bsh("teamkill.", EnumChatFormat.f), new bsh("teamkill.", EnumChatFormat.g), new bsh("teamkill.", EnumChatFormat.h),
			new bsh("teamkill.", EnumChatFormat.i), new bsh("teamkill.", EnumChatFormat.j), new bsh("teamkill.", EnumChatFormat.k), new bsh("teamkill.", EnumChatFormat.l),
			new bsh("teamkill.", EnumChatFormat.m), new bsh("teamkill.", EnumChatFormat.n), new bsh("teamkill.", EnumChatFormat.o), new bsh("teamkill.", EnumChatFormat.p) };
	bsk[] i = new bsk[] { new bsh("killedByTeam.", EnumChatFormat.a), new bsh("killedByTeam.", EnumChatFormat.b), new bsh("killedByTeam.", EnumChatFormat.c),
			new bsh("killedByTeam.", EnumChatFormat.d), new bsh("killedByTeam.", EnumChatFormat.e), new bsh("killedByTeam.", EnumChatFormat.f), new bsh("killedByTeam.", EnumChatFormat.g),
			new bsh("killedByTeam.", EnumChatFormat.h), new bsh("killedByTeam.", EnumChatFormat.i), new bsh("killedByTeam.", EnumChatFormat.j), new bsh("killedByTeam.", EnumChatFormat.k),
			new bsh("killedByTeam.", EnumChatFormat.l), new bsh("killedByTeam.", EnumChatFormat.m), new bsh("killedByTeam.", EnumChatFormat.n), new bsh("killedByTeam.", EnumChatFormat.o),
			new bsh("killedByTeam.", EnumChatFormat.p) };

	String a();

	int a(List var1);

	boolean b();

	bsl c();

}
