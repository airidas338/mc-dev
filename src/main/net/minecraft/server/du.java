package net.minecraft.server;
import java.util.Iterator;

final class du implements Iterable {

   // $FF: synthetic field
   final Location a;
   // $FF: synthetic field
   final Location b;


   du(Location var1, Location var2) {
      this.a = var1;
      this.b = var2;
   }

   public Iterator iterator() {
      return new dv(this);
   }
}
