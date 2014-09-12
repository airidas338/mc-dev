package net.minecraft.server;

class bhe extends Location {

   private final int b;


   public bhe(Location var1, int var2) {
      super(var1.n(), var1.o(), var1.p());
      this.b = var2;
   }

   public int q() {
      return this.b;
   }
}
