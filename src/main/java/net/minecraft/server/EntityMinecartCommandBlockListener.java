package net.minecraft.server;


class EntityMinecartCommandBlockListener extends CommandBlockListenerAbstract {

   // $FF: synthetic field
   final EntityMinecartCommandBlock a;


   EntityMinecartCommandBlockListener(EntityMinecartCommandBlock var1) {
      this.a = var1;
   }

   public void h() {
      this.a.H().b(23, this.l());
      this.a.H().b(24, hp.a(this.k()));
   }

   public Location getLocation() {
      return new Location(this.a.s, this.a.t + 0.5D, this.a.u);
   }

   public Vec3D d() {
      return new Vec3D(this.a.s, this.a.t, this.a.u);
   }

   public World getWorld() {
      return this.a.o;
   }

   public Entity f() {
      return this.a;
   }
}
