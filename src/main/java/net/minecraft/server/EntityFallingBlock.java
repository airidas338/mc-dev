package net.minecraft.server;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Iterator;

public class EntityFallingBlock extends Entity {

   private IBlockData d;
   public int a;
   public boolean b = true;
   private boolean e;
   private boolean f;
   private int g = 40;
   private float h = 2.0F;
   public NBTTagCompound c;


   public EntityFallingBlock(World var1) {
      super(var1);
   }

   public EntityFallingBlock(World var1, double var2, double var4, double var6, IBlockData var8) {
      super(var1);
      this.d = var8;
      this.k = true;
      this.a(0.98F, 0.98F);
      this.b(var2, var4, var6);
      this.v = 0.0D;
      this.w = 0.0D;
      this.x = 0.0D;
      this.p = var2;
      this.q = var4;
      this.r = var6;
   }

   protected boolean r_() {
      return false;
   }

   protected void h() {}

   public boolean ad() {
      return !this.I;
   }

   public void s_() {
      Block var1 = this.d.c();
      if(var1.getMaterial() == Material.AIR) {
         this.J();
      } else {
         this.p = this.s;
         this.q = this.t;
         this.r = this.u;
         Location var2;
         if(this.a++ == 0) {
            var2 = new Location(this);
            if(this.o.getData(var2).c() == var1) {
               this.o.g(var2);
            } else if(!this.o.isStatic) {
               this.J();
               return;
            }
         }

         this.w -= 0.03999999910593033D;
         this.d(this.v, this.w, this.x);
         this.v *= 0.9800000190734863D;
         this.w *= 0.9800000190734863D;
         this.x *= 0.9800000190734863D;
         if(!this.o.isStatic) {
            var2 = new Location(this);
            if(this.C) {
               this.v *= 0.699999988079071D;
               this.x *= 0.699999988079071D;
               this.w *= -0.5D;
               if(this.o.getData(var2).c() != Blocks.PISTON_MOVING) {
                  this.J();
                  if(!this.e && this.o.a(var1, var2, true, EnumFacing.UP, (Entity)null, (ItemStack)null) && !BlockFalling.d(this.o, var2.b()) && this.o.a(var2, this.d, 3)) {
                     if(var1 instanceof BlockFalling) {
                        ((BlockFalling)var1).a_(this.o, var2);
                     }

                     if(this.c != null && var1 instanceof IContainer) {
                        TileEntity var3 = this.o.s(var2);
                        if(var3 != null) {
                           NBTTagCompound var4 = new NBTTagCompound();
                           var3.b(var4);
                           Iterator var5 = this.c.c().iterator();

                           while(var5.hasNext()) {
                              String var6 = (String)var5.next();
                              NBTBase var7 = this.c.get(var6);
                              if(!var6.equals("x") && !var6.equals("y") && !var6.equals("z")) {
                                 var4.set(var6, var7.clone());
                              }
                           }

                           var3.a(var4);
                           var3.o_();
                        }
                     }
                  } else if(this.b && !this.e && this.o.Q().b("doTileDrops")) {
                     this.a(new ItemStack(var1, 1, var1.a(this.d)), 0.0F);
                  }
               }
            } else if(this.a > 100 && !this.o.isStatic && (var2.o() < 1 || var2.o() > 256) || this.a > 600) {
               if(this.b && this.o.Q().b("doTileDrops")) {
                  this.a(new ItemStack(var1, 1, var1.a(this.d)), 0.0F);
               }

               this.J();
            }
         }

      }
   }

   public void e(float var1, float var2) {
      Block var3 = this.d.c();
      if(this.f) {
         int var4 = MathHelper.f(var1 - 1.0F);
         if(var4 > 0) {
            ArrayList var5 = Lists.newArrayList(this.o.b((Entity)this, this.aQ()));
            boolean var6 = var3 == Blocks.ANVIL;
            DamageSource var7 = var6?DamageSource.ANVIL:DamageSource.FALLING_BLOCK;
            Iterator var8 = var5.iterator();

            while(var8.hasNext()) {
               Entity var9 = (Entity)var8.next();
               var9.a(var7, (float)Math.min(MathHelper.d((float)var4 * this.h), this.g));
            }

            if(var6 && (double)this.V.nextFloat() < 0.05000000074505806D + (double)var4 * 0.05D) {
               int var10 = ((Integer)this.d.b(BlockAnvil.b)).intValue();
               ++var10;
               if(var10 > 2) {
                  this.e = true;
               } else {
                  this.d = this.d.a(BlockAnvil.b, Integer.valueOf(var10));
               }
            }
         }
      }

   }

   protected void b(NBTTagCompound var1) {
      Block var2 = this.d != null?this.d.c():Blocks.AIR;
      RegistryPrepender var3 = (RegistryPrepender)Block.REGISTRY.c(var2);
      var1.setString("Block", var3 == null?"":var3.toString());
      var1.setByte("Data", (byte)var2.c(this.d));
      var1.setByte("Time", (byte)this.a);
      var1.setBoolean("DropItem", this.b);
      var1.setBoolean("HurtEntities", this.f);
      var1.setFloat("FallHurtAmount", this.h);
      var1.setInt("FallHurtMax", this.g);
      if(this.c != null) {
         var1.set("TileEntityData", (NBTBase)this.c);
      }

   }

   protected void a(NBTTagCompound var1) {
      int var2 = var1.getByte("Data") & 255;
      if(var1.hasKeyOfType("Block", 8)) {
         this.d = Block.b(var1.getString("Block")).a(var2);
      } else if(var1.hasKeyOfType("TileID", 99)) {
         this.d = Block.c(var1.getInt("TileID")).a(var2);
      } else {
         this.d = Block.c(var1.getByte("Tile") & 255).a(var2);
      }

      this.a = var1.getByte("Time") & 255;
      Block var3 = this.d.c();
      if(var1.hasKeyOfType("HurtEntities", 99)) {
         this.f = var1.getBoolean("HurtEntities");
         this.h = var1.getFloat("FallHurtAmount");
         this.g = var1.getInt("FallHurtMax");
      } else if(var3 == Blocks.ANVIL) {
         this.f = true;
      }

      if(var1.hasKeyOfType("DropItem", 99)) {
         this.b = var1.getBoolean("DropItem");
      }

      if(var1.hasKeyOfType("TileEntityData", 10)) {
         this.c = var1.getCompound("TileEntityData");
      }

      if(var3 == null || var3.getMaterial() == Material.AIR) {
         this.d = Blocks.SAND.P();
      }

   }

   public void a(boolean var1) {
      this.f = var1;
   }

   public void getAttributeInstance(CrashReportSystemDetails var1) {
      super.getAttributeInstance(var1);
      if(this.d != null) {
         Block var2 = this.d.c();
         var1.a("Immitating block ID", (Object)Integer.valueOf(Block.getId(var2)));
         var1.a("Immitating block data", (Object)Integer.valueOf(var2.c(this.d)));
      }

   }

   public IBlockData l() {
      return this.d;
   }
}
