package net.minecraft.server;


class aec extends aqf {

   // $FF: synthetic field
   final EntityMinecartCommandBlock a;


   aec(EntityMinecartCommandBlock var1) {
      this.a = var1;
   }

   public void h() {
      this.a.H().b(23, this.l());
      this.a.H().b(24, hp.a(this.k()));
   }

   public Location c() {
      return new Location(this.a.s, this.a.t + 0.5D, this.a.u);
   }

   public ChunkCoordinates d() {
      return new ChunkCoordinates(this.a.s, this.a.t, this.a.u);
   }

   public World e() {
      return this.a.o;
   }

   public Entity f() {
      return this.a;
   }
}
