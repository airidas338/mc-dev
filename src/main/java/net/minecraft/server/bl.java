package net.minecraft.server;


class bl implements ICommandListener {

   // $FF: synthetic field
   final Entity a;
   // $FF: synthetic field
   final ICommandListener b;
   // $FF: synthetic field
   final Location c;
   // $FF: synthetic field
   final double d;
   // $FF: synthetic field
   final double e;
   // $FF: synthetic field
   final double f;
   // $FF: synthetic field
   final CommandExecute g;


   bl(CommandExecute var1, Entity var2, ICommandListener var3, Location var4, double var5, double var7, double var9) {
      this.g = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      this.e = var7;
      this.f = var9;
   }

   public String getName() {
      return this.a.getName();
   }

   public IChatBaseComponent getScoreboardDisplayName() {
      return this.a.getScoreboardDisplayName();
   }

   public void sendMessage(IChatBaseComponent var1) {
      this.b.sendMessage(var1);
   }

   public boolean a(int var1, String var2) {
      return this.b.a(var1, var2);
   }

   public Location getLocation() {
      return this.c;
   }

   public Vec3D d() {
      return new Vec3D(this.d, this.e, this.f);
   }

   public World getWorld() {
      return this.a.o;
   }

   public Entity f() {
      return this.a;
   }

   public boolean t_() {
      MinecraftServer var1 = MinecraftServer.M();
      return var1 == null || var1.c[0].getGameRules().getBoolean("commandBlockOutput");
   }

   public void a(ag var1, int var2) {
      this.a.a(var1, var2);
   }
}
