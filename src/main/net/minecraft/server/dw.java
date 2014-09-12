package net.minecraft.server;
import java.util.Iterator;

final class dw implements Iterable {

   // $FF: synthetic field
   final Location a;
   // $FF: synthetic field
   final Location b;


   dw(Location var1, Location var2) {
      this.a = var1;
      this.b = var2;
   }

   public Iterator iterator() {
      return new dx(this);
   }
}
