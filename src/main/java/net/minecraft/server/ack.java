package net.minecraft.server;


class ack extends zn {

   private final EntityRabbit c;
   private boolean d;
   private boolean e = false;


   public ack(EntityRabbit var1) {
      super(var1, 0.699999988079071D, 16);
      this.c = var1;
   }

   public boolean a() {
      if(this.a <= 0) {
         if(!this.c.o.getGameRules().getBoolean("mobGriefing")) {
            return false;
         }

         this.e = false;
         this.d = EntityRabbit.a(this.c);
      }

      return super.a();
   }

   public boolean b() {
      return this.e && super.b();
   }

   public void c() {
      super.c();
   }

   public void d() {
      super.d();
   }

   public void e() {
      super.e();
      this.c.p().a((double)this.b.n() + 0.5D, (double)(this.b.o() + 1), (double)this.b.p() + 0.5D, 10.0F, (float)this.c.bP());
      if(this.f()) {
         World var1 = this.c.o;
         Location var2 = this.b.a();
         IBlockData var3 = var1.getData(var2);
         Block var4 = var3.c();
         if(this.e && var4 instanceof BlockCarrots && ((Integer)var3.b(BlockCarrots.a)).intValue() == 7) {
            var1.setTypeAndData(var2, Blocks.AIR.P(), 2);
            var1.setAir(var2, true);
            this.c.cn();
         }

         this.e = false;
         this.a = 10;
      }

   }

   protected boolean a(World var1, Location var2) {
      Block var3 = var1.getData(var2).c();
      if(var3 == Blocks.SOIL) {
         var2 = var2.a();
         IBlockData var4 = var1.getData(var2);
         var3 = var4.c();
         if(var3 instanceof BlockCarrots && ((Integer)var4.b(BlockCarrots.a)).intValue() == 7 && this.d && !this.e) {
            this.e = true;
            return true;
         }
      }

      return false;
   }
}
