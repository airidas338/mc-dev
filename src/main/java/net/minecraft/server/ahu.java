package net.minecraft.server;


public class ahu extends ahr {

   public ahu(World var1) {
      super(var1);
   }

   public ahu(World var1, xm var2) {
      super(var1, var2);
   }

   public ahu(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   protected float m() {
      return 0.07F;
   }

   protected float j() {
      return 0.7F;
   }

   protected float l() {
      return -20.0F;
   }

   protected void a(bru var1) {
      if(!this.o.D) {
         this.o.b(2002, new dt(this), 0);
         int var2 = 3 + this.o.s.nextInt(5) + this.o.s.nextInt(5);

         while(var2 > 0) {
            int var3 = xk.a(var2);
            var2 -= var3;
            this.o.d((Entity)(new xk(this.o, this.s, this.t, this.u, var3)));
         }

         this.J();
      }

   }
}
