package net.minecraft.server;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TileEntityBeacon extends TileEntityLockable implements IUpdatePlayerListBox, IInventory {

   public static final MobEffectList[][] a = new MobEffectList[][]{{MobEffectList.c, MobEffectList.e}, {MobEffectList.m, MobEffectList.j}, {MobEffectList.g}, {MobEffectList.l}};
   private final List f = Lists.newArrayList();
   private boolean i;
   private int j = -1;
   private int k;
   private int l;
   private ItemStack m;
   private String n;


   public void c() {
      if(this.b.getTime() % 80L == 0L) {
         this.m();
      }

   }

   public void m() {
      this.B();
      this.A();
   }

   private void A() {
      if(this.i && this.j > 0 && !this.b.isStatic && this.k > 0) {
         double var1 = (double)(this.j * 10 + 10);
         byte var3 = 0;
         if(this.j >= 4 && this.k == this.l) {
            var3 = 1;
         }

         int var4 = this.c.n();
         int var5 = this.c.o();
         int var6 = this.c.p();
         AxisAlignedBB var7 = (new AxisAlignedBB((double)var4, (double)var5, (double)var6, (double)(var4 + 1), (double)(var5 + 1), (double)(var6 + 1))).b(var1, var1, var1).a(0.0D, (double)this.b.U(), 0.0D);
         List var8 = this.b.getEntities(EntityHuman.class, var7);
         Iterator var9 = var8.iterator();

         EntityHuman var10;
         while(var9.hasNext()) {
            var10 = (EntityHuman)var9.next();
            var10.c(new MobEffect(this.k, 180, var3, true, true));
         }

         if(this.j >= 4 && this.k != this.l && this.l > 0) {
            var9 = var8.iterator();

            while(var9.hasNext()) {
               var10 = (EntityHuman)var9.next();
               var10.c(new MobEffect(this.l, 180, 0, true, true));
            }
         }
      }

   }

   private void B() {
      int var1 = this.j;
      int var2 = this.c.n();
      int var3 = this.c.o();
      int var4 = this.c.p();
      this.j = 0;
      this.f.clear();
      this.i = true;
      bcl var5 = new bcl(EntitySheep.a(akv.a));
      this.f.add(var5);
      boolean var6 = true;

      int var7;
      for(var7 = var3 + 1; var7 < this.b.V(); ++var7) {
         Location var8 = new Location(var2, var7, var4);
         IBlockData var9 = this.b.getData(var8);
         float[] var10;
         if(var9.c() == Blocks.STAINED_GLASS) {
            var10 = EntitySheep.a((akv)var9.b(BlockStainedGlass.a));
         } else {
            if(var9.c() != Blocks.STAINED_GLASS_PANE) {
               if(var9.c().n() >= 15) {
                  this.i = false;
                  this.f.clear();
                  break;
               }

               var5.a();
               continue;
            }

            var10 = EntitySheep.a((akv)var9.b(BlockStainedGlassPane.a));
         }

         if(!var6) {
            var10 = new float[]{(var5.b()[0] + var10[0]) / 2.0F, (var5.b()[1] + var10[1]) / 2.0F, (var5.b()[2] + var10[2]) / 2.0F};
         }

         if(Arrays.equals(var10, var5.b())) {
            var5.a();
         } else {
            var5 = new bcl(var10);
            this.f.add(var5);
         }

         var6 = false;
      }

      if(this.i) {
         for(var7 = 1; var7 <= 4; this.j = var7++) {
            int var14 = var3 - var7;
            if(var14 < 0) {
               break;
            }

            boolean var16 = true;

            for(int var17 = var2 - var7; var17 <= var2 + var7 && var16; ++var17) {
               for(int var11 = var4 - var7; var11 <= var4 + var7; ++var11) {
                  Block var12 = this.b.getData(new Location(var17, var14, var11)).c();
                  if(var12 != Blocks.EMERALD_BLOCK && var12 != Blocks.GOLD_BLOCK && var12 != Blocks.DIAMOND_BLOCK && var12 != Blocks.IRON_BLOCK) {
                     var16 = false;
                     break;
                  }
               }
            }

            if(!var16) {
               break;
            }
         }

         if(this.j == 0) {
            this.i = false;
         }
      }

      if(!this.b.isStatic && this.j == 4 && var1 < this.j) {
         Iterator var15 = this.b.getEntities(EntityHuman.class, (new AxisAlignedBB((double)var2, (double)var3, (double)var4, (double)var2, (double)(var3 - 4), (double)var4)).b(10.0D, 5.0D, 10.0D)).iterator();

         while(var15.hasNext()) {
            EntityHuman var13 = (EntityHuman)var15.next();
            var13.b((Statistic)AchievementList.K);
         }
      }

   }

   public Packet x_() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.b(var1);
      return new PacketPlayOutTileEntityData(this.c, 3, var1);
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      this.k = var1.getInt("Primary");
      this.l = var1.getInt("Secondary");
      this.j = var1.getInt("Levels");
   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.setInt("Primary", this.k);
      var1.setInt("Secondary", this.l);
      var1.setInt("Levels", this.j);
   }

   public int n_() {
      return 1;
   }

   public ItemStack a(int var1) {
      return var1 == 0?this.m:null;
   }

   public ItemStack a(int var1, int var2) {
      if(var1 == 0 && this.m != null) {
         if(var2 >= this.m.count) {
            ItemStack var3 = this.m;
            this.m = null;
            return var3;
         } else {
            this.m.count -= var2;
            return new ItemStack(this.m.getItem(), var2, this.m.getData());
         }
      } else {
         return null;
      }
   }

   public ItemStack b(int var1) {
      if(var1 == 0 && this.m != null) {
         ItemStack var2 = this.m;
         this.m = null;
         return var2;
      } else {
         return null;
      }
   }

   public void a(int var1, ItemStack var2) {
      if(var1 == 0) {
         this.m = var2;
      }

   }

   public String getName() {
      return this.k_()?this.n:"container.beacon";
   }

   public boolean k_() {
      return this.n != null && this.n.length() > 0;
   }

   public void a(String var1) {
      this.n = var1;
   }

   public int p_() {
      return 1;
   }

   public boolean a(EntityHuman var1) {
      return this.b.getTileEntity(this.c) != this?false:var1.e((double)this.c.n() + 0.5D, (double)this.c.o() + 0.5D, (double)this.c.p() + 0.5D) <= 64.0D;
   }

   public void b(EntityHuman var1) {}

   public void c(EntityHuman var1) {}

   public boolean b(int var1, ItemStack var2) {
      return var2.getItem() == Items.bO || var2.getItem() == Items.DIAMOND || var2.getItem() == Items.GOLD_INGOT || var2.getItem() == Items.IRON_INGOT;
   }

   public String k() {
      return "minecraft:beacon";
   }

   public aib a(ahb var1, EntityHuman var2) {
      return new aig(var1, this);
   }

   public int a_(int var1) {
      switch(var1) {
      case 0:
         return this.j;
      case 1:
         return this.k;
      case 2:
         return this.l;
      default:
         return 0;
      }
   }

   public void b(int var1, int var2) {
      switch(var1) {
      case 0:
         this.j = var2;
         break;
      case 1:
         this.k = var2;
         break;
      case 2:
         this.l = var2;
      }

   }

   public int g() {
      return 3;
   }

   public void l() {
      this.m = null;
   }

   public boolean c(int var1, int var2) {
      if(var1 == 1) {
         this.m();
         return true;
      } else {
         return super.c(var1, var2);
      }
   }

}
