package net.minecraft.server;

public class ajh extends wa {

   private bda a;


   public ajh() {
      super("container.enderchest", false, 27);
   }

   public void a(bda var1) {
      this.a = var1;
   }

   public void a(NBTTagList var1) {
      int var2;
      for(var2 = 0; var2 < this.n_(); ++var2) {
         this.a(var2, (ItemStack)null);
      }

      for(var2 = 0; var2 < var1.c(); ++var2) {
         NBTTagCompound var3 = var1.b(var2);
         int var4 = var3.getByte("Slot") & 255;
         if(var4 >= 0 && var4 < this.n_()) {
            this.a(var4, ItemStack.a(var3));
         }
      }

   }

   public NBTTagList h() {
      NBTTagList var1 = new NBTTagList();

      for(int var2 = 0; var2 < this.n_(); ++var2) {
         ItemStack var3 = this.a(var2);
         if(var3 != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.setByte("Slot", (byte)var2);
            var3.b(var4);
            var1.a((NBTBase)var4);
         }
      }

      return var1;
   }

   public boolean a(EntityHuman var1) {
      return this.a != null && !this.a.a(var1)?false:super.a(var1);
   }

   public void b(EntityHuman var1) {
      if(this.a != null) {
         this.a.b();
      }

      super.b(var1);
   }

   public void c(EntityHuman var1) {
      if(this.a != null) {
         this.a.d();
      }

      super.c(var1);
      this.a = null;
   }
}
