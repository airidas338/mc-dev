package net.minecraft.server;

public final class WorldSettings {

   private final long a;
   private final EnumGamemode b;
   private final boolean c;
   private final boolean d;
   private final WorldType e;
   private boolean f;
   private boolean g;
   private String h;


   public WorldSettings(long var1, EnumGamemode var3, boolean var4, boolean var5, WorldType var6) {
      this.h = "";
      this.a = var1;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      this.e = var6;
   }

   public WorldSettings(WorldData var1) {
      this(var1.b(), var1.r(), var1.s(), var1.t(), var1.u());
   }

   public WorldSettings a() {
      this.g = true;
      return this;
   }

   public WorldSettings a(String var1) {
      this.h = var1;
      return this;
   }

   public boolean c() {
      return this.g;
   }

   public long d() {
      return this.a;
   }

   public EnumGamemode e() {
      return this.b;
   }

   public boolean f() {
      return this.d;
   }

   public boolean g() {
      return this.c;
   }

   public WorldType h() {
      return this.e;
   }

   public boolean i() {
      return this.f;
   }

   public static EnumGamemode a(int var0) {
      return EnumGamemode.getById(var0);
   }

   public String j() {
      return this.h;
   }
}
