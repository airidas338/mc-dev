package net.minecraft.server;


class bcu extends aqf {

   // $FF: synthetic field
   final bct a;


   bcu(bct var1) {
      this.a = var1;
   }

   public Location c() {
      return this.a.c;
   }

   public ChunkCoordinates d() {
      return new ChunkCoordinates((double)this.a.c.n() + 0.5D, (double)this.a.c.o() + 0.5D, (double)this.a.c.p() + 0.5D);
   }

   public World e() {
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
