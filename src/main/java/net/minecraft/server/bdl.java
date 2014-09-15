package net.minecraft.server;


class bdl implements ICommandListener {

   // $FF: synthetic field
   final EntityHuman a;
   // $FF: synthetic field
   final bdj b;


   bdl(bdj var1, EntityHuman var2) {
      this.b = var1;
      this.a = var2;
   }

   public String getName() {
      return this.a.getName();
   }

   public IChatBaseComponent getScoreboardDisplayName() {
      return this.a.getScoreboardDisplayName();
   }

   public void sendMessage(IChatBaseComponent var1) {}

   public boolean a(int var1, String var2) {
      return true;
   }

   public Location getLocation() {
      return this.b.c;
   }

   public Vec3D d() {
      return new Vec3D((double)this.b.c.n() + 0.5D, (double)this.b.c.o() + 0.5D, (double)this.b.c.p() + 0.5D);
   }

   public World getWorld() {
      return this.a.getWorld();
   }

   public Entity f() {
      return this.a;
   }

   public boolean t_() {
      return false;
   }

   public void a(ag var1, int var2) {
      bdj.a(this.b).a(this, var1, var2);
   }
}
