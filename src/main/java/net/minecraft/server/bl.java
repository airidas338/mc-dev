package net.minecraft.server;


class bl implements ICommandSender {

   // $FF: synthetic field
   final Entity a;
   // $FF: synthetic field
   final ICommandSender b;
   // $FF: synthetic field
   final Location c;
   // $FF: synthetic field
   final double d;
   // $FF: synthetic field
   final double e;
   // $FF: synthetic field
   final double f;
   // $FF: synthetic field
   final bk g;


   bl(bk var1, Entity var2, ICommandSender var3, Location var4, double var5, double var7, double var9) {
      this.g = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      this.e = var7;
      this.f = var9;
   }

   public String d_() {
      return this.a.d_();
   }

   public IChatBaseComponent e_() {
      return this.a.e_();
   }

   public void a(IChatBaseComponent var1) {
      this.b.a(var1);
   }

   public boolean a(int var1, String var2) {
      return this.b.a(var1, var2);
   }

   public Location c() {
      return this.c;
   }

   public Vec3D d() {
      return new Vec3D(this.d, this.e, this.f);
   }

   public World e() {
      return this.a.o;
   }

   public Entity f() {
      return this.a;
   }

   public boolean t_() {
      MinecraftServer var1 = MinecraftServer.M();
      return var1 == null || var1.c[0].Q().b("commandBlockOutput");
   }

   public void a(ag var1, int var2) {
      this.a.a(var1, var2);
   }
}
