package net.minecraft.server;
import java.io.IOException;


public abstract class act extends xn implements wt {

   public act(World var1) {
      super(var1);
   }

   public boolean aX() {
      return true;
   }

   public boolean bQ() {
      return true;
   }

   public boolean bR() {
      return this.o.a(this.aQ(), (Entity)this);
   }

   public int w() {
      return 120;
   }

   protected boolean C() {
      return true;
   }

   protected int b(ahd var1) {
      return 1 + this.o.s.nextInt(3);
   }

   public void K() throws IOException {
      int var1 = this.aA();
      super.K();
      if(this.ai() && !this.V()) {
         --var1;
         this.h(var1);
         if(this.aA() == -20) {
            this.h(0);
            this.a(wh.f, 2.0F);
         }
      } else {
         this.h(300);
      }

   }

   public boolean aK() {
      return false;
   }
}
