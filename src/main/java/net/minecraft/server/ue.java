package net.minecraft.server;
import com.google.common.collect.AbstractIterator;
import java.util.Iterator;

class ue extends AbstractIterator {

   // $FF: synthetic field
   final Iterator a;
   // $FF: synthetic field
   final uc b;


   ue(uc var1, Iterator var2) {
      this.b = var1;
      this.a = var2;
   }

   protected Object computeNext() {
      return !this.a.hasNext()?this.endOfData():this.a.next();
   }
}
