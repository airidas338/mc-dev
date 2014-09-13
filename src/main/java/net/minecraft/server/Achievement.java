package net.minecraft.server;
public class Achievement extends tq {

	public int a;
	public int b;
	public final Achievement c;
	private final String k;
	public final ItemStack d;
	private boolean m;

	public Achievement(String var1, String var2, int var3, int var4, Item var5, Achievement var6) {
		this(var1, var2, var3, var4, new ItemStack(var5), var6);
	}

	public Achievement(String var1, String var2, int var3, int var4, Block var5, Achievement var6) {
		this(var1, var2, var3, var4, new ItemStack(var5), var6);
	}

	public Achievement(String var1, String var2, int var3, int var4, ItemStack var5, Achievement var6) {
		super(var1, new ChatMessage("achievement." + var2, new Object[0]));
		this.d = var5;
		this.k = "achievement." + var2 + ".desc";
		this.a = var3;
		this.b = var4;
		if (var3 < AchievementList.a) {
			a = var3;
		}

		if (var4 < AchievementList.b) {
			b = var4;
		}

		if (var3 > AchievementList.c) {
			AchievementList.c = var3;
		}

		if (var4 > AchievementList.d) {
			AchievementList.d = var4;
		}

		this.c = var6;
	}

	public Achievement a() {
		this.f = true;
		return this;
	}

	public Achievement b() {
		this.m = true;
		return this;
	}

	public Achievement c() {
		super.h();
		AchievementList.e.add(this);
		return this;
	}

	public boolean d() {
		return true;
	}

	public IChatBaseComponent e() {
		IChatBaseComponent var1 = super.e();
		var1.b().a(this.g() ? EnumChatFormat.f : EnumChatFormat.k);
		return var1;
	}

	public Achievement a(Class var1) {
		return (Achievement) super.b(var1);
	}

	public boolean g() {
		return this.m;
	}

	// $FF: synthetic method
	public tq b(Class var1) {
		return this.a(var1);
	}

	// $FF: synthetic method
	public tq h() {
		return this.c();
	}

	// $FF: synthetic method
	public tq i() {
		return this.a();
	}
}
