package net.minecraft.server;



public class ze extends zn {

   private final EntityVillager c;
   private boolean d;
   private boolean e;
   private int f;


   public ze(EntityVillager var1, double var2) {
      super(var1, var2, 16);
      this.c = var1;
   }

   public boolean a() {
      if(this.a <= 0) {
         if(!this.c.o.getGameRules().getBoolean("mobGriefing")) {
            return false;
         }

         this.f = -1;
         this.d = this.c.cs();
         this.e = this.c.cr();
      }

      return super.a();
   }

   public boolean b() {
      return this.f >= 0 && super.b();
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
         if(this.f == 0 && var4 instanceof BlockCrops && ((Integer)var3.b(BlockCrops.a)).intValue() == 7) {
            var1.setAir(var2, true);
         } else if(this.f == 1 && var4 == Blocks.AIR) {
            wa var5 = this.c.co();

            for(int var6 = 0; var6 < var5.n_(); ++var6) {
               ItemStack var7 = var5.a(var6);
               boolean var8 = false;
               if(var7 != null) {
                  if(var7.getItem() == Items.SEEDS) {
                     var1.setTypeAndData(var2, Blocks.CROPS.P(), 3);
                     var8 = true;
                  } else if(var7.getItem() == Items.bS) {
                     var1.setTypeAndData(var2, Blocks.POTATOES.P(), 3);
                     var8 = true;
                  } else if(var7.getItem() == Items.bR) {
                     var1.setTypeAndData(var2, Blocks.CARROTS.P(), 3);
                     var8 = true;
                  }
               }

               if(var8) {
                  --var7.count;
                  if(var7.count <= 0) {
                     var5.a(var6, (ItemStack)null);
                  }
                  break;
               }
            }
         }

         this.f = -1;
         this.a = 10;
      }

   }

   protected boolean a(World var1, Location var2) {
      Block var3 = var1.getData(var2).c();
      if(var3 == Blocks.SOIL) {
         var2 = var2.a();
         IBlockData var4 = var1.getData(var2);
         var3 = var4.c();
         if(var3 instanceof BlockCrops && ((Integer)var4.b(BlockCrops.a)).intValue() == 7 && this.e && (this.f == 0 || this.f < 0)) {
            this.f = 0;
            return true;
         }

         if(var3 == Blocks.AIR && this.d && (this.f == 1 || this.f < 0)) {
            this.f = 1;
            return true;
         }
      }

      return false;
   }
}
