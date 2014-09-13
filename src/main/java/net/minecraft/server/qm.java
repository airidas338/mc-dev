package net.minecraft.server;

class qm implements WorldBorderListener {

   // $FF: synthetic field
   final SecondaryWorldServer a;


   qm(SecondaryWorldServer var1) {
      this.a = var1;
   }

   public void a(WorldBorder var1, double var2) {
      this.a.af().a(var2);
   }

   public void a(WorldBorder var1, double var2, double var4, long var6) {
      this.a.af().a(var2, var4, var6);
   }

   public void a(WorldBorder var1, double var2, double var4) {
      this.a.af().c(var2, var4);
   }

   public void a(WorldBorder var1, int var2) {
      this.a.af().b(var2);
   }

   public void b(WorldBorder var1, int var2) {
      this.a.af().c(var2);
   }

   public void b(WorldBorder var1, double var2) {
      this.a.af().c(var2);
   }

   public void c(WorldBorder var1, double var2) {
      this.a.af().b(var2);
   }
}
