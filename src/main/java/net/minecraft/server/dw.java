package net.minecraft.server;
import java.util.Iterator;

final class dw implements Iterable {

   // $FF: synthetic field
   final dt a;
   // $FF: synthetic field
   final dt b;


   dw(dt var1, dt var2) {
      this.a = var1;
      this.b = var2;
   }

   public Iterator iterator() {
      return new dx(this);
   }
}
