package net.minecraft.server;


class aei extends aqi {

   // $FF: synthetic field
   final aeh a;


   aei(aeh var1) {
      this.a = var1;
   }

   public void a(int var1) {
      this.a.o.a((Entity)this.a, (byte)var1);
   }

   public World a() {
      return this.a.o;
   }

   public dt b() {
      return new dt(this.a);
   }
}
