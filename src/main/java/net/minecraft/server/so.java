package net.minecraft.server;

class so implements WorldBorderListener {

   // $FF: synthetic field
   final PlayerList a;


   so(PlayerList var1) {
      this.a = var1;
   }

   public void a(WorldBorder var1, double var2) {
      this.a.a((Packet)(new kr(var1, kt.a)));
   }

   public void a(WorldBorder var1, double var2, double var4, long var6) {
      this.a.a((Packet)(new kr(var1, kt.b)));
   }

   public void a(WorldBorder var1, double var2, double var4) {
      this.a.a((Packet)(new kr(var1, kt.c)));
   }

   public void a(WorldBorder var1, int var2) {
      this.a.a((Packet)(new kr(var1, kt.e)));
   }

   public void b(WorldBorder var1, int var2) {
      this.a.a((Packet)(new kr(var1, kt.f)));
   }

   public void b(WorldBorder var1, double var2) {}

   public void c(WorldBorder var1, double var2) {}
}
