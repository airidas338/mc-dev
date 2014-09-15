package net.minecraft.server;


class bdk implements ICommandListener {

   // $FF: synthetic field
   final bdj a;


   bdk(bdj var1) {
      this.a = var1;
   }

   public String getName() {
      return "Sign";
   }

   public IChatBaseComponent getScoreboardDisplayName() {
      return new ChatComponentText(this.getName());
   }

   public void sendMessage(IChatBaseComponent var1) {}

   public boolean a(int var1, String var2) {
      return true;
   }

   public Location getLocation() {
      return this.a.c;
   }

   public Vec3D d() {
      return new Vec3D((double)this.a.c.n() + 0.5D, (double)this.a.c.o() + 0.5D, (double)this.a.c.p() + 0.5D);
   }

   public World getWorld() {
      return this.a.b;
   }

   public Entity f() {
      return null;
   }

   public boolean t_() {
      return false;
   }

   public void a(ag var1, int var2) {}
}
