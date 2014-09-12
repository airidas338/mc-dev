package net.minecraft.server;

public class ari extends Location {

   public long b;
   // $FF: synthetic field
   final PortalTravelAgent c;


   public ari(PortalTravelAgent var1, Location var2, long var3) {
      super(var2.n(), var2.o(), var2.p());
      this.c = var1;
      this.b = var3;
   }
}
