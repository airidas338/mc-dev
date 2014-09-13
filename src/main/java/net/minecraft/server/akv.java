package net.minecraft.server;

public enum akv implements va {

   a("WHITE", 0, 0, 15, "white", "white", MaterialMapColor.j, EnumChatFormat.p),
   b("ORANGE", 1, 1, 14, "orange", "orange", MaterialMapColor.q, EnumChatFormat.g),
   c("MAGENTA", 2, 2, 13, "magenta", "magenta", MaterialMapColor.r, EnumChatFormat.l),
   d("LIGHT_BLUE", 3, 3, 12, "light_blue", "lightBlue", MaterialMapColor.s, EnumChatFormat.j),
   e("YELLOW", 4, 4, 11, "yellow", "yellow", MaterialMapColor.t, EnumChatFormat.o),
   f("LIME", 5, 5, 10, "lime", "lime", MaterialMapColor.u, EnumChatFormat.k),
   g("PINK", 6, 6, 9, "pink", "pink", MaterialMapColor.v, EnumChatFormat.n),
   h("GRAY", 7, 7, 8, "gray", "gray", MaterialMapColor.w, EnumChatFormat.i),
   i("SILVER", 8, 8, 7, "silver", "silver", MaterialMapColor.x, EnumChatFormat.h),
   j("CYAN", 9, 9, 6, "cyan", "cyan", MaterialMapColor.y, EnumChatFormat.d),
   k("PURPLE", 10, 10, 5, "purple", "purple", MaterialMapColor.z, EnumChatFormat.f),
   l("BLUE", 11, 11, 4, "blue", "blue", MaterialMapColor.A, EnumChatFormat.b),
   m("BROWN", 12, 12, 3, "brown", "brown", MaterialMapColor.B, EnumChatFormat.g),
   n("GREEN", 13, 13, 2, "green", "green", MaterialMapColor.C, EnumChatFormat.c),
   o("RED", 14, 14, 1, "red", "red", MaterialMapColor.D, EnumChatFormat.e),
   p("BLACK", 15, 15, 0, "black", "black", MaterialMapColor.E, EnumChatFormat.a);
   private static final akv[] q = new akv[values().length];
   private static final akv[] r = new akv[values().length];
   private final int s;
   private final int t;
   private final String u;
   private final String v;
   private final MaterialMapColor w;
   private final EnumChatFormat x;
   // $FF: synthetic field
   private static final akv[] y = new akv[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p};


   private akv(String var1, int var2, int var3, int var4, String var5, String var6, MaterialMapColor var7, EnumChatFormat var8) {
      this.s = var3;
      this.t = var4;
      this.u = var5;
      this.v = var6;
      this.w = var7;
      this.x = var8;
   }

   public int a() {
      return this.s;
   }

   public int b() {
      return this.t;
   }

   public String d() {
      return this.v;
   }

   public MaterialMapColor e() {
      return this.w;
   }

   public static akv a(int var0) {
      if(var0 < 0 || var0 >= r.length) {
         var0 = 0;
      }

      return r[var0];
   }

   public static akv b(int var0) {
      if(var0 < 0 || var0 >= q.length) {
         var0 = 0;
      }

      return q[var0];
   }

   public String toString() {
      return this.v;
   }

   public String l() {
      return this.u;
   }

   static {
      akv[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         akv var3 = var0[var2];
         q[var3.a()] = var3;
         r[var3.b()] = var3;
      }

   }
}
