package net.minecraft.server;
import com.google.common.collect.AbstractIterator;

class dv extends AbstractIterator {

   private Location b;
   // $FF: synthetic field
   final du a;


   dv(du var1) {
      this.a = var1;
      this.b = null;
   }

   protected Location a() {
      if(this.b == null) {
         this.b = this.a.a;
         return this.b;
      } else if(this.b.equals(this.a.b)) {
         return (Location)this.endOfData();
      } else {
         int var1 = this.b.n();
         int var2 = this.b.o();
         int var3 = this.b.p();
         if(var1 < this.a.b.n()) {
            ++var1;
         } else if(var2 < this.a.b.o()) {
            var1 = this.a.a.n();
            ++var2;
         } else if(var3 < this.a.b.p()) {
            var1 = this.a.a.n();
            var2 = this.a.a.o();
            ++var3;
         }

         this.b = new Location(var1, var2, var3);
         return this.b;
      }
   }

   // $FF: synthetic method
   protected Object computeNext() {
      return this.a();
   }
}
