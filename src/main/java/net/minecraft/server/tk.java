package net.minecraft.server;
public class tk extends tq {

	public int a;
	public int b;
	public final tk c;
	private final String k;
	public final ItemStack d;
	private boolean m;

	public tk(String var1, String var2, int var3, int var4, Item var5, tk var6) {
		this(var1, var2, var3, var4, new ItemStack(var5), var6);
	}

	public tk(String var1, String var2, int var3, int var4, Block var5, tk var6) {
		this(var1, var2, var3, var4, new ItemStack(var5), var6);
	}

	public tk(String var1, String var2, int var3, int var4, ItemStack var5, tk var6) {
		super(var1, new ChatMessage("achievement." + var2, new Object[0]));
		this.d = var5;
		this.k = "achievement." + var2 + ".desc";
		this.a = var3;
		this.b = var4;
		if (var3 < tl.a) {
			a = var3;
		}

		if (var4 < tl.b) {
			b = var4;
		}

		if (var3 > tl.c) {
			tl.c = var3;
		}

		if (var4 > tl.d) {
			tl.d = var4;
		}

		this.c = var6;
	}

	public tk a() {
		this.f = true;
		return this;
	}

	public tk b() {
		this.m = true;
		return this;
	}

	public tk c() {
		super.h();
		tl.e.add(this);
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

	public tk a(Class var1) {
		return (tk) super.b(var1);
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
