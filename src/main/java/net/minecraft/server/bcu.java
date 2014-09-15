package net.minecraft.server;


class bcu extends CommandBlockListenerAbstract {

   // $FF: synthetic field
   final bct a;


   bcu(bct var1) {
      this.a = var1;
   }

   public Location getLocation() {
      return this.a.c;
   }

   public Vec3D d() {
      return new Vec3D((double)this.a.c.n() + 0.5D, (double)this.a.c.o() + 0.5D, (double)this.a.c.p() + 0.5D);
   }

   public World getWorld() {
      return this.a.z();
   }

   public void a(String var1) {
      super.a(var1);
      this.a.o_();
   }

   public void h() {
      this.a.z().h(this.a.c);
   }

   public Entity f() {
      return null;
   }
}
