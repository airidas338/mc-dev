package net.minecraft.server;

public class aio extends aib {

   public ain a = new ain(this, 3, 3);
   public IInventory f = new aji();
   private World g;
   private Location h;


   public aio(ahb var1, World var2, Location var3) {
      this.g = var2;
      this.h = var3;
      this.a((ajk)(new ajj(var1.d, this.a, this.f, 0, 124, 35)));

      int var4;
      int var5;
      for(var4 = 0; var4 < 3; ++var4) {
         for(var5 = 0; var5 < 3; ++var5) {
            this.a(new ajk(this.a, var5 + var4 * 3, 30 + var5 * 18, 17 + var4 * 18));
         }
      }

      for(var4 = 0; var4 < 3; ++var4) {
         for(var5 = 0; var5 < 9; ++var5) {
            this.a(new ajk(var1, var5 + var4 * 9 + 9, 8 + var5 * 18, 84 + var4 * 18));
         }
      }

      for(var4 = 0; var4 < 9; ++var4) {
         this.a(new ajk(var1, var4, 8 + var4 * 18, 142));
      }

      this.a((IInventory)this.a);
   }

   public void a(IInventory var1) {
      this.f.a(0, CraftingManager.getInstance().a(this.a, this.g));
   }

   public void b(EntityHuman var1) {
      super.b(var1);
      if(!this.g.isStatic) {
         for(int var2 = 0; var2 < 9; ++var2) {
            ItemStack var3 = this.a.b(var2);
            if(var3 != null) {
               var1.a(var3, false);
            }
         }

      }
   }

   public boolean a(EntityHuman var1) {
      return this.g.getData(this.h).c() != Blocks.CRAFTING_TABLE?false:var1.e((double)this.h.n() + 0.5D, (double)this.h.o() + 0.5D, (double)this.h.p() + 0.5D) <= 64.0D;
   }

   public ItemStack b(EntityHuman var1, int var2) {
      ItemStack var3 = null;
      ajk var4 = (ajk)this.c.get(var2);
      if(var4 != null && var4.e()) {
         ItemStack var5 = var4.d();
         var3 = var5.cloneItemStack();
         if(var2 == 0) {
            if(!this.a(var5, 10, 46, true)) {
               return null;
            }

            var4.a(var5, var3);
         } else if(var2 >= 10 && var2 < 37) {
            if(!this.a(var5, 37, 46, false)) {
               return null;
            }
         } else if(var2 >= 37 && var2 < 46) {
            if(!this.a(var5, 10, 37, false)) {
               return null;
            }
         } else if(!this.a(var5, 10, 46, false)) {
            return null;
         }

         if(var5.count == 0) {
            var4.d((ItemStack)null);
         } else {
            var4.f();
         }

         if(var5.count == var3.count) {
            return null;
         }

         var4.a(var1, var5);
      }

      return var3;
   }

   public boolean a(ItemStack var1, ajk var2) {
      return var2.d != this.f && super.a(var1, var2);
   }
}
