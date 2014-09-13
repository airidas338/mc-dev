package net.minecraft.server;


public class aju extends Item {

   protected final Block a;


   public aju(Block var1) {
      this.a = var1;
   }

   public aju b(String var1) {
      super.c(var1);
      return this;
   }

   public boolean a(ItemStack var1, EntityHuman var2, World var3, Location var4, EnumFacing var5, float var6, float var7, float var8) {
      IBlock var9 = var3.getData(var4);
      Block var10 = var9.c();
      if(var10 == Blocks.aH && ((Integer)var9.b(BlockSnow.a)).intValue() < 1) {
         var5 = EnumFacing.UP;
      } else if(!var10.f(var3, var4)) {
         var4 = var4.a(var5);
      }

      if(var1.b == 0) {
         return false;
      } else if(!var2.a(var4, var5, var1)) {
         return false;
      } else if(var4.o() == 255 && this.a.r().a()) {
         return false;
      } else if(var3.a(this.a, var4, false, var5, (Entity)null, var1)) {
         int var11 = this.a(var1.i());
         IBlock var12 = this.a.a(var3, var4, var5, var6, var7, var8, var11, var2);
         if(var3.a(var4, var12, 3)) {
            var12 = var3.getData(var4);
            if(var12.c() == this.a) {
               a(var3, var4, var1);
               this.a.a(var3, var4, var12, (EntityLiving)var2, var1);
            }

            var3.a((double)((float)var4.n() + 0.5F), (double)((float)var4.o() + 0.5F), (double)((float)var4.p() + 0.5F), this.a.H.b(), (this.a.H.d() + 1.0F) / 2.0F, this.a.H.e() * 0.8F);
            --var1.b;
         }

         return true;
      } else {
         return false;
      }
   }

   public static boolean a(World var0, Location var1, ItemStack var2) {
      if(var2.n() && var2.o().b("BlockEntityTag", 10)) {
         TileEntity var3 = var0.s(var1);
         if(var3 != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            NBTTagCompound var5 = (NBTTagCompound)var4.b();
            var3.b(var4);
            NBTTagCompound var6 = (NBTTagCompound)var2.o().a("BlockEntityTag");
            var4.a(var6);
            var4.setInt("x", var1.n());
            var4.setInt("y", var1.o());
            var4.setInt("z", var1.p());
            if(!var4.equals(var5)) {
               var3.a(var4);
               var3.o_();
               return true;
            }
         }
      }

      return false;
   }

   public String e_(ItemStack var1) {
      return this.a.a();
   }

   public String a() {
      return this.a.a();
   }

   public Block d() {
      return this.a;
   }

   // $FF: synthetic method
   public Item c(String var1) {
      return this.b(var1);
   }
}
