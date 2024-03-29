package net.minecraft.server;


public class EntityItemFrame extends EntityHanging {

   private float c = 1.0F;


   public EntityItemFrame(World var1) {
      super(var1);
   }

   public EntityItemFrame(World var1, Location var2, EnumFacing var3) {
      super(var1, var2);
      this.a(var3);
   }

   protected void h() {
      this.H().a(8, 5);
      this.H().a(9, Byte.valueOf((byte)0));
   }

   public float ao() {
      return 0.0F;
   }

   public boolean a(DamageSource var1, float var2) {
      if(this.b(var1)) {
         return false;
      } else if(!var1.isExplosion() && this.o() != null) {
         if(!this.o.isStatic) {
            this.a(var1.getEntity(), false);
            this.a((ItemStack)null);
         }

         return true;
      } else {
         return super.a(var1, var2);
      }
   }

   public int l() {
      return 12;
   }

   public int m() {
      return 12;
   }

   public void b(Entity var1) {
      this.a(var1, true);
   }

   public void a(Entity var1, boolean var2) {
      if(this.o.getGameRules().getBoolean("doTileDrops")) {
         ItemStack var3 = this.o();
         if(var1 instanceof EntityHuman) {
            EntityHuman var4 = (EntityHuman)var1;
            if(var4.abilities.canInstantlyBuild) {
               this.b(var3);
               return;
            }
         }

         if(var2) {
            this.a(new ItemStack(Items.bP), 0.0F);
         }

         if(var3 != null && this.V.nextFloat() < this.c) {
            var3 = var3.cloneItemStack();
            this.b(var3);
            this.a(var3, 0.0F);
         }

      }
   }

   private void b(ItemStack var1) {
      if(var1 != null) {
         if(var1.getItem() == Items.bd) {
            WorldMap var2 = ((ItemWorldMap)var1.getItem()).a(var1, this.o);
            var2.h.remove("frame-" + this.F());
         }

         var1.a((EntityItemFrame)null);
      }
   }

   public ItemStack o() {
      return this.H().f(8);
   }

   public void a(ItemStack var1) {
      this.a(var1, true);
   }

   private void a(ItemStack var1, boolean var2) {
      if(var1 != null) {
         var1 = var1.cloneItemStack();
         var1.count = 1;
         var1.a(this);
      }

      this.H().b(8, var1);
      this.H().i(8);
      if(var2 && this.a != null) {
         this.o.updateAdjacentComparators(this.a, Blocks.AIR);
      }

   }

   public int p() {
      return this.H().a(9);
   }

   public void a(int var1) {
      this.a(var1, true);
   }

   private void a(int var1, boolean var2) {
      this.H().b(9, Byte.valueOf((byte)(var1 % 8)));
      if(var2 && this.a != null) {
         this.o.updateAdjacentComparators(this.a, Blocks.AIR);
      }

   }

   public void b(NBTTagCompound var1) {
      if(this.o() != null) {
         var1.set("Item", (NBTBase)this.o().save(new NBTTagCompound()));
         var1.setByte("ItemRotation", (byte)this.p());
         var1.setFloat("ItemDropChance", this.c);
      }

      super.b(var1);
   }

   public void a(NBTTagCompound var1) {
      NBTTagCompound var2 = var1.getCompound("Item");
      if(var2 != null && !var2.isEmpty()) {
         this.a(ItemStack.createStack(var2), false);
         this.a(var1.getByte("ItemRotation"), false);
         if(var1.hasKeyOfType("ItemDropChance", 99)) {
            this.c = var1.getFloat("ItemDropChance");
         }

         if(var1.hasKey("Direction")) {
            this.a(this.p() * 2, false);
         }
      }

      super.a(var1);
   }

   public boolean e(EntityHuman var1) {
      if(this.o() == null) {
         ItemStack var2 = var1.bz();
         if(var2 != null && !this.o.isStatic) {
            this.a(var2);
            if(!var1.abilities.canInstantlyBuild && --var2.count <= 0) {
               var1.bg.a(var1.bg.c, (ItemStack)null);
            }
         }
      } else if(!this.o.isStatic) {
         this.a(this.p() + 1);
      }

      return true;
   }

   public int q() {
      return this.o() == null?0:this.p() % 8 + 1;
   }
}
